package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUser findUserById(long id) {
        return applicationUserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find the user with ID: " + id));
    }
}
