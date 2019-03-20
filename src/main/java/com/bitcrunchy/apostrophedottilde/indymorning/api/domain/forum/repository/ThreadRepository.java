package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ThreadRepository extends PagingAndSortingRepository<Thread, Long> {

}