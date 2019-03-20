package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service.CommentService;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service.PostService;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service.ThreadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ForumFacadeImpl implements ForumFacade {

    private ThreadService threadService;

    private PostService postService;

    private CommentService commentService;

    public ForumFacadeImpl(ThreadService threadService, PostService postService, CommentService commentService) {
        this.threadService = threadService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @Override
    public Post submitPostInThread(long threadId, Post post) {
        final Thread thread = threadService.fetchThread(threadId).orElseThrow(() -> new EntityNotFoundException("not found thread " + threadId));
        post.setThread(thread);
        return postService.savePost(post);
    }

    @Override
    public Page<Post> fetchPostsInThread(long threadId, Pageable pageable) {
        return postService.findPostsInThread(threadId, pageable);
    }

    @Override
    public Page<Comment> fetchCommentsOnPost(long postId, Pageable pageable) {
        return commentService.findCommentsOnPost(postId, pageable);
    }

    @Override
    public Comment submitCommentOnPost(long postId, Comment comment) {
        final Post post = postService.fetchPost(postId).orElseThrow(() -> new EntityNotFoundException("not found post " + postId));
        comment.setPost(post);
        return commentService.saveComment(comment);
    }

    @Override
    public void closeThreadWithId(long threadId) {
        threadService.closeThreadWithId(threadId);
    }

    @Override
    public Thread createNewThread(Thread thread) {
        return threadService.createThread(thread);
    }

    @Override
    public Page<Thread> fetchAllThreads(Pageable pageable) {
        return threadService.fetchAllThreads(pageable);
    }

    @Override
    public Thread fetchThreadById(long threadId) {
        return threadService.fetchThread(threadId).orElseThrow(() -> new EntityNotFoundException("not found thread " + threadId));
    }

    @Override
    public void closePostWithId(long id) {
        commentService.closePostWithId(id);
    }
}
