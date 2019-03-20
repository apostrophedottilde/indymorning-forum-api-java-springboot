package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p " +
            "JOIN Thread AS t " +
            "ON p.thread = t " +
            "WHERE p.thread.id = :threadId")
    Page<Post> findPostsByThreadId(@Param("threadId") long threadId, Pageable pageable);
}
