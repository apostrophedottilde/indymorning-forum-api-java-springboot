package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.PostController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.ApplicationUserController;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ThreadLinks {

    public Link getPostsLink(ThreadResource resource) {
        return ControllerLinkBuilder.linkTo(methodOn(PostController .class).getPostsInThread(resource.getThisId(),
                new PageRequest(0, 1)))
                .withRel("posts");
    }

    public Link getCreatorLink(ThreadResource resource) {
        return ControllerLinkBuilder.linkTo(methodOn(ApplicationUserController .class).getUser(resource.getThisId()))
                .withRel("creator");
    }
}
