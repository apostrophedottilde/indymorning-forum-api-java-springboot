package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.service;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.repository.PostRepository;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.util.LoggedInUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private LoggedInUserManager<Post> loggedInUserManager;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, LoggedInUserManager<Post> loggedInUserManager) {
        this.postRepository = postRepository;
        this.loggedInUserManager = loggedInUserManager;
    }

    @Override
    public Post savePost(Post post) {
        loggedInUserManager.attachLoggedInUser(post);
        return postRepository.save(post);
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
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Page<Post> findPostsInThread(long threadId, Pageable pageable) {
        return postRepository.findPostsByThreadId(threadId, pageable);
    }
}
