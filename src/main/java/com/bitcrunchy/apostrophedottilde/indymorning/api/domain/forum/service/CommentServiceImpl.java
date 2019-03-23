package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository.CommentRepository;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.util.LoggedInUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private LoggedInUserManager<Comment> loggedInUserManager;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, LoggedInUserManager<Comment> loggedInUserManager) {
        this.commentRepository = commentRepository;
        this.loggedInUserManager = loggedInUserManager;
    }

    @Override
    public Page<Comment> findCommentsOnPost(long postId, Pageable pageable) {
        return commentRepository.findAllByPostId(postId, pageable);
    }

    @Override
    public Comment saveComment(Comment comment) {
        loggedInUserManager.attachLoggedInUser(comment);
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> fetchComment(long commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public Page<Comment> fetchAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

}
