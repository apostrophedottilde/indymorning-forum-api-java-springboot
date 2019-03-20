package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.assembler;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Post;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.PostController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.PostResource;
import org.springframework.stereotype.Component;

@Component
public class PostResourceAssembler extends BaseResourceAssembler<Post, PostResource> {

    public PostResourceAssembler() {
        super(PostController.class, PostResource.class);
    }

    @Override
    public PostResource toResource(Post entity) {
        PostResource resource = super.toResource(entity);
        resource.setText(entity.getText());
        return resource;
    }
}
