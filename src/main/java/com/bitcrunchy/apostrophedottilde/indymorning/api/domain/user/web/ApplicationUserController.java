package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUser;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUserRepository;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.resource.ApplicationUserResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.web.resource.assembler.ApplicationUserResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {

    private ApplicationUserRepository applicationUserRepository;

    private ApplicationUserResourceAssembler applicationUserResourceAssembler;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserController(ApplicationUserRepository applicationUserRepository,
                                     ApplicationUserResourceAssembler applicationUserResourceAssembler, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.applicationUserResourceAssembler = applicationUserResourceAssembler;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Resource<ApplicationUserResource>> getUser(@PathVariable long userId) {
        ApplicationUser applicationUser = applicationUserRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(""));
        ApplicationUserResource applicationUserResource = applicationUserResourceAssembler.toResource(applicationUser);
        return ResponseEntity.ok(new Resource<>(applicationUserResource));
    }
}