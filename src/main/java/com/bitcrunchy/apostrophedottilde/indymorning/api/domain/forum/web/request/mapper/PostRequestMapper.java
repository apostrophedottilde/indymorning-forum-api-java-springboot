package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.mapper;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.PostRequest;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.web.request.mapper.MapsRequestToEntity;
import org.springframework.stereotype.Component;

@Component
public class PostRequestMapper implements MapsRequestToEntity<PostRequest, Post> {

    public Post toEntity(PostRequest req) {
        Post post = new Post();
        post.setText(req.getText());
        return post;
    }
}
