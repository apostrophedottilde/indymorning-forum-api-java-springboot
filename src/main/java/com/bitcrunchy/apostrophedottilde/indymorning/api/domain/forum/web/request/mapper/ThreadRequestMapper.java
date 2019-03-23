package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.mapper;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.ThreadRequest;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.web.request.mapper.MapsRequestToEntity;
import org.springframework.stereotype.Component;

@Component
public class ThreadRequestMapper implements MapsRequestToEntity<ThreadRequest, Thread> {

    @Override
    public Thread toEntity(ThreadRequest req) {
        Thread thread = new Thread();
        thread.setTitle(req.getTitle());
        thread.setDescription(req.getDescription());
        return thread;
    }
}
