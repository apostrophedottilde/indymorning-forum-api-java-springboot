package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.ForumFacade;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service.CommentService;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.CommentRequest;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.mapper.CommentRequestMapper;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.CommentResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.assembler.CommentResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RepositoryRestController
@RequestMapping("/comments")
public class CommentController {

    private ForumFacade forumFacade;

    private CommentService commentService;

    private CommentRequestMapper commentRequestMapper;

    private CommentResourceAssembler commentResourceAssembler;

    private PagedResourcesAssembler pagedResourcesAssembler;

    @Autowired
    public CommentController(ForumFacade forumFacade,
                             CommentService commentService,
                             CommentRequestMapper commentRequestMapper,
                             CommentResourceAssembler commentResourceAssembler,
                             PagedResourcesAssembler pagedResourcesAssembler) {
        this.forumFacade = forumFacade;
        this.commentService = commentService;
        this.commentRequestMapper = commentRequestMapper;
        this.commentResourceAssembler = commentResourceAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResource> getComment(@PathVariable long id) {
        Comment comment = commentService.fetchComment(id)
                .orElseThrow(() -> new EntityNotFoundException("not found comment " + id));
        CommentResource commentResource = commentResourceAssembler.toResource(comment);

        return ResponseEntity.ok(commentResource);
    }

    @GetMapping
    public ResponseEntity<PagedResources<Resource<CommentResource>>> getCommentsOnPost(@RequestParam long postId, @PageableDefault Pageable pageable) {
        Page<Comment> commentsOnPost = forumFacade.fetchCommentsOnPost(postId, pageable);
        Page<CommentResource> map = commentsOnPost.map(t -> commentResourceAssembler.toResource(t));
        return ResponseEntity.ok(pagedResourcesAssembler.toResource(map));
    }

    @PostMapping
    public ResponseEntity<CommentResource> submitComment(@Valid @RequestBody CommentRequest request) throws URISyntaxException {
        final Comment comment = commentRequestMapper.toEntity(request);
        Comment savedComment = forumFacade.submitCommentOnPost(request.getPostId(), comment);
        CommentResource resource = commentResourceAssembler.toResource(savedComment);
        return ResponseEntity.created(new URI(resource.getId().getHref())).body(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable long id) {
        forumFacade.closePostWithId(id);
        return ResponseEntity.ok().build();
    }
}
