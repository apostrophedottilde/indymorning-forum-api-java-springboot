package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.mapper;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.PostRequest;

public interface MapsRequestToEntity<R, E> {

    E toEntity(R req);
}
