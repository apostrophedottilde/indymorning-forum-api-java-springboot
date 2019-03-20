package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findAllByPostId(@Param("PostId") long postId, Pageable pageable);
}