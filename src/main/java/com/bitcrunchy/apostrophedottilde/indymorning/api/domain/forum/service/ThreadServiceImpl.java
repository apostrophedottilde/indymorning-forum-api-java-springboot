package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ThreadServiceImpl implements ThreadService {

    private ThreadRepository threadRepository;

    @Autowired
    public ThreadServiceImpl(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
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
        return threadRepository.save(thread);
    }

    @Override
    public Thread saveThread(Thread thread) {
        return threadRepository.save(thread);
    }

    @Override
    public void closeThreadWithId(long threadId) {
        Thread thread = threadRepository.findById(threadId).orElseThrow(() -> new EntityNotFoundException("Could not find thread with Id: " + threadId + " so cannot CLOSE it."));
        thread.setState("CLOSED");
        threadRepository.save(thread);
    }
}
