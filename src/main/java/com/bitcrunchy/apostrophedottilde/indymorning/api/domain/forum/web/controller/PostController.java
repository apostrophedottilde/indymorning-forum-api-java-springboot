package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.ForumFacade;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.PostRequest;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.mapper.PostRequestMapper;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.PostResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service.PostService;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.assembler.PostResourceAssembler;
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
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    private ForumFacade forumFacade;

    private PostResourceAssembler postResourceAssembler;

    private PagedResourcesAssembler pagedResourcesAssembler;

    private PostRequestMapper postRequestMapper;

    @Autowired
    public PostController(PostService postService, ForumFacade forumFacade, PostResourceAssembler postResourceAssembler, PagedResourcesAssembler pagedResourcesAssembler, PostRequestMapper postRequestMapper) {
        this.postService = postService;
        this.forumFacade = forumFacade;
        this.postResourceAssembler = postResourceAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.postRequestMapper = postRequestMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResource> getPost(@PathVariable long id) {
        Post post = postService.fetchPost(id)
                .orElseThrow(() -> new EntityNotFoundException("not found thread " + id));
        PostResource postResource = postResourceAssembler.toResource(post);

        return ResponseEntity.ok(postResource);
    }

    @GetMapping
    public ResponseEntity<PagedResources<Resource<PostResource>>> getPostsInThread(@RequestParam long threadId, @PageableDefault Pageable pageable) {
        Page<Post> postsInThread = forumFacade.fetchPostsInThread(threadId, pageable);
        Page<PostResource> map = postsInThread.map(t -> postResourceAssembler.toResource(t));
        return ResponseEntity.ok(pagedResourcesAssembler.toResource(map));
    }


    @PostMapping
    public ResponseEntity<Resource<PostResource>> submitPost(@Valid @RequestBody PostRequest request) throws URISyntaxException {
        final Post post = postRequestMapper.toEntity(request);
        Post newPost = forumFacade.submitPostInThread(request.getThreadId(), post);
        PostResource resource = postResourceAssembler.toResource(newPost);
        return ResponseEntity.created(new URI(resource.getId().getHref())).body(new Resource<>(resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable long id) {
        forumFacade.closePostWithId(id);
        return ResponseEntity.ok().build();
    }
}
