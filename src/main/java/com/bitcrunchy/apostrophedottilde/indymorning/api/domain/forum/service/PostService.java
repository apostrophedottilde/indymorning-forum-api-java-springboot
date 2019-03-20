package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostService {
    Post savePost(Post post);

    Page<Post> fetchAllPosts(Pageable pageable);

    Optional<Post> fetchPost(long threadId);

    void deletePost(Post post);

    Page<Post> findPostsInThread(long threadId, Pageable pageable);
}
