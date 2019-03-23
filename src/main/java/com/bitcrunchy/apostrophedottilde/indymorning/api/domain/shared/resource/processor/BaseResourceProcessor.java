package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.BaseResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.ApplicationUserController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public abstract class BaseResourceProcessor<R extends BaseResource> implements ResourceProcessor<Resource<R>> {

    @Override
    public Resource<R> process(Resource<R> resource) {
        final BaseResource content = resource.getContent();
        content.add(ControllerLinkBuilder.linkTo(methodOn(ApplicationUserController.class).getUser(content.getCreator()))
                .withRel("creator"));
        return resource;
    }
}
