package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.ForumFacade;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.ThreadRequest;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.mapper.ThreadRequestMapper;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.assembler.ThreadResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RepositoryRestController
@RequestMapping("/threads")
@ExposesResourceFor(Thread.class)
public class ThreadController {

    private ForumFacade forumFacade;

    private ThreadResourceAssembler threadResourceAssembler;

    private PagedResourcesAssembler pagedResourcesAssembler;

    private ThreadRequestMapper threadRequestMapper;


    @Autowired
    public ThreadController(ForumFacade forumFacade,
                            ThreadResourceAssembler threadResourceAssembler,
                            PagedResourcesAssembler pagedResourcesAssembler,
                            ThreadRequestMapper threadRequestMapper) {
        this.forumFacade = forumFacade;
        this.threadResourceAssembler = threadResourceAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.threadRequestMapper = threadRequestMapper;
    }

    @GetMapping("/{threadId}")
    public ResponseEntity<Resource<ThreadResource>> getThread(@PathVariable long threadId) {
        Thread thread = forumFacade.fetchThreadById(threadId);
        ThreadResource threadResource = threadResourceAssembler.toResource(thread);
        return ResponseEntity.ok(new Resource<>(threadResource));
    }

    @GetMapping
    public ResponseEntity<PagedResources<Resource<ThreadResource>>> getThreads(@PageableDefault Pageable pageable) {
        Page<Thread> threads = forumFacade.fetchAllThreads(pageable);
        Page<ThreadResource> map = threads.map(t -> threadResourceAssembler.toResource(t));
        return ResponseEntity.ok(pagedResourcesAssembler.toResource(map));
    }

    @PostMapping
    public ResponseEntity<Resource<ThreadResource>> createThread(@Valid @RequestBody ThreadRequest request) throws URISyntaxException {
        Thread thread = threadRequestMapper.toEntity(request);
        Thread savedThread = forumFacade.createNewThread(thread);
        ThreadResource resource = threadResourceAssembler.toResource(savedThread);
        return ResponseEntity.created(new URI(resource.getId().getHref())).body(new Resource<>(resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteThread(@PathVariable long id) {
        forumFacade.deleteThread(id);
        return ResponseEntity.ok().build();
    }
}