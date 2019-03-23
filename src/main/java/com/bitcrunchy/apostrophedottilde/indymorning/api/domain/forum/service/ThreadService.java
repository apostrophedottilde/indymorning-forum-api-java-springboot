package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ThreadService {

    Page<Thread> fetchAllThreads(Pageable pageable);

    Optional<Thread> fetchThread(long threadId);

    Thread createThread(Thread thread);

    Thread saveThread(Thread thread);

    void deleteThread(long threadId);

}
