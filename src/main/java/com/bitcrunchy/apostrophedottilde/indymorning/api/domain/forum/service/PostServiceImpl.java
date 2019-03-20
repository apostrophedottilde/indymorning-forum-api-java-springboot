package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Thread;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository.PostRepository;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private ThreadRepository threadRepository;

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(ThreadRepository threadRepository, PostRepository postRepository) {
        this.threadRepository = threadRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public Page<Post> fetchAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Post> fetchPost(long threadId) {
        return postRepository.findById(threadId);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    @Override
    public Page<Post> findPostsInThread(long threadId, Pageable pageable) {
        return postRepository.findPostsByThreadId(threadId, pageable);
    }
}
