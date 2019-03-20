package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.CommentController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.PostController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.ThreadController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.CommentResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.PostResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class PostResourceProcessor implements ResourceProcessor<Resource<PostResource>> {

    @Autowired
    public PostResourceProcessor() {
    }

    @Override
    public Resource<PostResource> process(Resource<PostResource> resource) {
        final PostResource content = resource.getContent();

        // BEGIN: related resource links)
        content.add(ControllerLinkBuilder.linkTo(methodOn(CommentController.class).getCommentsOnPost(content.getThisId(), null)).withRel("comments"));
        // END: related resource links)

        // BEGIN: stateful links

        // END: stateful links
        return resource;
    }
}
