package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ForumFacade {

    Post submitPostInThread(long threadId, Post post);

    Page<Post> fetchPostsInThread(long threadId, Pageable pageable);

    Page<Comment> fetchCommentsOnPost(long postId, Pageable pageable);

    Comment submitCommentOnPost(long postId, Comment comment);

    Thread createNewThread(Thread thread);

    Page<Thread> fetchAllThreads(Pageable pageable);

    Thread fetchThreadById(long threadId);

    void deleteThread(long threadId);

    void deleteComment(long id);

    void deletePost(long id);

}
