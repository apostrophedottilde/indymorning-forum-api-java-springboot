package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.PostController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.controller.ThreadController;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link.ThreadLinks;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class ThreadResourceProcessor implements ResourceProcessor<Resource<ThreadResource>> {

    private @NonNull ThreadLinks links;

    @Autowired
    public ThreadResourceProcessor(ThreadLinks links) {
        this.links = links;
    }

    @Override
    public Resource<ThreadResource> process(Resource<ThreadResource> resource) {
        final ThreadResource content = resource.getContent();
        final String state = content.getState();

        // BEGIN: related resource links)
        content.add(ControllerLinkBuilder.linkTo(methodOn(PostController.class).getPostsInThread(content.getThisId(), new PageRequest(0, 1))).withRel("posts"));
        // END: related resource links)

        // BEGIN: stateful links
//        if("OPEN".equals(state)) {
//            content.add(links.getCloseLink(content));
//            content.add(links.getUpVoteLink(content));
//            content.add(links.getDownVoteLink(content));
//        }
//        if("CLOSED".equals(state)) {
//            content.add(links.getReopenLink(content));
//        }
        // END: stateful links

        return resource;
    }
}