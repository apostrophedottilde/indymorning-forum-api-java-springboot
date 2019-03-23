package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.mapper;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.Comment;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request.CommentRequest;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.web.request.mapper.MapsRequestToEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentRequestMapper implements MapsRequestToEntity<CommentRequest, Comment> {

    @Override
    public Comment toEntity(CommentRequest req) {
        Comment comment = new Comment();
        comment.setText(req.getText());
        return comment;
    }
}
