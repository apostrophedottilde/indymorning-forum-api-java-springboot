package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.util;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.BaseEntity;
import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUser;

public interface LoggedInUserManager<E extends BaseEntity> {
    void attachLoggedInUser(E entity);

    ApplicationUser fetchLoggedInUser();
}
