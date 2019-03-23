package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.assembler;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.BaseEntity;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.BaseResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public abstract class BaseResourceAssembler<E extends BaseEntity, R extends BaseResource> extends ResourceAssemblerSupport<E, R> {

    public BaseResourceAssembler(Class controllerClass, Class resourceClass) {
        super(controllerClass, resourceClass);
    }

    @Override
    public R toResource(E entity) {
        R resource = super.createResourceWithId(entity.getId(), entity);
        resource.setCreator(entity.getCreator().getId());
        resource.setCreatedOn(entity.getCreatedOn());
        resource.setUpdatedOn(entity.getUpdatedOn());
        resource.setThisId(entity.getId());
        return resource;
    }
}
