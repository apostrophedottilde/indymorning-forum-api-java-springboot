package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CommentService {
    Page<Comment> findCommentsOnPost(long postId, Pageable pageable);

    Comment saveComment(Comment comment);

    Optional<Comment> fetchComment(long commentId);

    Page<Comment> fetchAllComments(Pageable pageable);

    void deleteComment(long id);
}
