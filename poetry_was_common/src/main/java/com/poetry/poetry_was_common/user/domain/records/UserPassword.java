package com.poetry.poetry_was_common.user.domain;

import org.springframework.util.Assert;

public record UserPassword(String value) {
    public UserPassword {

        Assert.notNull(value, "UserPassword value must not be null");
        Assert.isTrue(value.length() > 5,
                "UserPassword value must not be longer than 5");

    }
}
