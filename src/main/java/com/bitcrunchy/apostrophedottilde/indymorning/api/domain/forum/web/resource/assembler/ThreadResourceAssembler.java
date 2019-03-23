package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.assembler;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.ThreadController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.assembler.BaseResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class ThreadResourceAssembler extends BaseResourceAssembler<Thread, ThreadResource> {

    public ThreadResourceAssembler() {
        super(ThreadController.class, ThreadResource.class);
    }

    @Override
    public ThreadResource toResource(Thread entity) {
        super.toResource(entity);
        ThreadResource resource = super.toResource(entity);
        resource.setTitle(entity.getTitle());
        resource.setDescription(entity.getDescription());
        resource.setState(entity.getState());
        return resource;
    }
}
