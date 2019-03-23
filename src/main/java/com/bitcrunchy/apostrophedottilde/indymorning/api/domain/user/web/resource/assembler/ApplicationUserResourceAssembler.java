package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.resource.assembler;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.assembler.BaseResourceAssembler;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUser;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.ApplicationUserController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.resource.ApplicationUserResource;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserResourceAssembler extends BaseResourceAssembler<ApplicationUser, ApplicationUserResource> {
    public ApplicationUserResourceAssembler() {
        super(ApplicationUserController.class, ApplicationUserResource.class);
    }

    @Override
    public ApplicationUserResource toResource(ApplicationUser entity) {
        ApplicationUserResource resource = super.toResource(entity);
        return resource;
    }
}
