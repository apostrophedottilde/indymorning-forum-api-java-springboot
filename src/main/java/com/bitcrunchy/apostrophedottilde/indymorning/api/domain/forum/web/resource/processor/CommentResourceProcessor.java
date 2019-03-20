package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.CommentController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.ThreadController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.CommentResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link.CommentLinks;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link.ThreadLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CommentResourceProcessor implements ResourceProcessor<Resource<CommentResource>> {

    private @NonNull CommentLinks links;

    @Autowired
    public CommentResourceProcessor(CommentLinks links) {
        this.links = links;
    }

    @Override
    public Resource<CommentResource> process(Resource<CommentResource> resource) {
        final CommentResource content = resource.getContent();

        // BEGIN: related resource links)
//        content.add(ControllerLinkBuilder.linkTo(methodOn(CommentController.class).getComment(content.getThisId())).slash("comments").withRel("posts"));
        // END: related resource links)

        // BEGIN: stateful links

        // END: stateful links

        return resource;
    }
}
