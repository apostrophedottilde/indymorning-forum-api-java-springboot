package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.util;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.BaseEntity;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUser;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoggedInUserManagerImpl<E extends BaseEntity> implements LoggedInUserManager<E> {

    private ApplicationUserService applicationUserService;

    @Autowired
    public LoggedInUserManagerImpl(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @Override
    public void attachLoggedInUser(E entity) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ApplicationUser loggedInUser = applicationUserService.findUserById(Long.valueOf(auth.getName()));
        entity.setCreator(loggedInUser);
    }

    @Override
    public ApplicationUser fetchLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ApplicationUser loggedInUser = applicationUserService.findUserById(Long.valueOf(auth.getName()));
        return loggedInUser;
    }
}
