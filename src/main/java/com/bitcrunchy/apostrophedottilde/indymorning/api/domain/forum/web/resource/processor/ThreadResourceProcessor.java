package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.PostController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link.ThreadLinks;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.ApplicationUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ThreadResourceProcessor implements ResourceProcessor<Resource<ThreadResource>> {

    private @NonNull ThreadLinks links;

    @Autowired
    public ThreadResourceProcessor(ThreadLinks links) {
        this.links = links;
    }

    @Override
    public Resource<ThreadResource> process(Resource<ThreadResource> resource) {
        final ThreadResource content = resource.getContent();

        content.add(ControllerLinkBuilder.linkTo(methodOn(PostController.class).getPostsInThread(content.getThisId(), new PageRequest(0, 1))).withRel("posts"));
        content.add(ControllerLinkBuilder.linkTo(methodOn(ApplicationUserController.class).getUser(content.getThisId())).withRel("creator"));

        return resource;
    }
}