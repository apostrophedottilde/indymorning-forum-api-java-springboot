package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.ThreadController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ThreadLinks {

    public Link getCloseLink(ThreadResource resource) {
        return ControllerLinkBuilder.linkTo(methodOn(ThreadController.class).getThread(resource.getThisId())).slash("close").withRel("close");
    }

    public Link getReopenLink(ThreadResource resource) {
        return linkTo(methodOn(ThreadController.class).getThread(resource.getThisId())).slash("reopen").withRel("reOpen");
    }


    public Link getUpVoteLink(ThreadResource resource) {
        return linkTo(methodOn(ThreadController.class).getThread(resource.getThisId())).slash("up-vote").withRel("upVote");
    }

    public Link getDownVoteLink(ThreadResource resource) {
        return linkTo(methodOn(ThreadController.class).getThread(resource.getThisId())).slash("down-vote").withRel("downVote");
    }
}
