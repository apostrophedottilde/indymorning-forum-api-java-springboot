package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.assembler;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.CommentController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.CommentResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.assembler.BaseResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class CommentResourceAssembler extends BaseResourceAssembler<Comment, CommentResource> {

    public CommentResourceAssembler() {
        super(CommentController.class, CommentResource.class);
    }

    @Override
    public CommentResource toResource(Comment entity) {
        super.toResource(entity);
        CommentResource resource = super.toResource(entity);
        resource.setText(entity.getText());
        return resource;
    }
}
