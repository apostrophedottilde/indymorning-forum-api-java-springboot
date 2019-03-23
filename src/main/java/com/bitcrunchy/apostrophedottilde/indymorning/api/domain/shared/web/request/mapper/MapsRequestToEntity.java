package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.web.request.mapper;

public interface MapsRequestToEntity<R, E> {

    E toEntity(R req);
}
