package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.CommentController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.PostResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.processor.BaseResourceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PostResourceProcessor extends BaseResourceProcessor<PostResource> {

    @Autowired
    public PostResourceProcessor() {
    }

    @Override
    public Resource<PostResource> process(Resource<PostResource> resource) {
        super.process(resource);

        final PostResource content = resource.getContent();

        content.add(ControllerLinkBuilder.linkTo(methodOn(CommentController.class).getCommentsOnPost(content.getThisId(), null)).withRel("comments"));

        return resource;
    }
}
