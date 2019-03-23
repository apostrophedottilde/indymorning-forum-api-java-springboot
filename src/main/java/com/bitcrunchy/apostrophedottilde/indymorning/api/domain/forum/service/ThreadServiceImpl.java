package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository.ThreadRepository;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.util.LoggedInUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThreadServiceImpl implements ThreadService {

    private ThreadRepository threadRepository;

    private LoggedInUserManager<Thread> loggedInUserManager;

    @Autowired
    public ThreadServiceImpl(ThreadRepository threadRepository, LoggedInUserManager<Thread> loggedInUserManager) {
        this.threadRepository = threadRepository;
        this.loggedInUserManager = loggedInUserManager;
    }

    @Override
    public Page<Thread> fetchAllThreads(Pageable paging) {
        return threadRepository.findAll(paging);
    }

    @Override
    public Optional<Thread> fetchThread(long threadId) {
        return threadRepository.findById(threadId);
    }

    @Override
    public Thread createThread(Thread thread) {
        loggedInUserManager.attachLoggedInUser(thread);
        return threadRepository.save(thread);
    }

    @Override
    public Thread saveThread(Thread thread) {
        return threadRepository.save(thread);
    }

    @Override
    public void deleteThread(long threadId) {
        threadRepository.deleteById(threadId);
    }
}
