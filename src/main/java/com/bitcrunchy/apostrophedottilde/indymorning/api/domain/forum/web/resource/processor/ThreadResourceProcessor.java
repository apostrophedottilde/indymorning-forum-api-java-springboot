package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.processor;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.ThreadResource;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource.link.ThreadLinks;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.processor.BaseResourceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ThreadResourceProcessor extends BaseResourceProcessor<ThreadResource> {

    private @NonNull ThreadLinks links;

    @Autowired
    public ThreadResourceProcessor(ThreadLinks links) {
        this.links = links;
    }

    @Override
    public Resource<ThreadResource> process(Resource<ThreadResource> resource) {
        super.process(resource);
        final ThreadResource content = resource.getContent();

        content.add(links.getPostsLink(content));

        return resource;
    }
}