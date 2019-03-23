package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.CommentResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link.CommentLinks;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.processor.BaseResourceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CommentResourceProcessor extends BaseResourceProcessor<CommentResource> {

    private @NonNull CommentLinks links;

    @Autowired
    public CommentResourceProcessor(CommentLinks links) {
        this.links = links;
    }

    @Override
    public Resource<CommentResource> process(Resource<CommentResource> resource) {
        final CommentResource content = resource.getContent();

//        content.add(ControllerLinkBuilder.linkTo(methodOn(CommentController.class).getComment(content.getThisId())).slash("comments").withRel("posts"));

        return resource;
    }
}
