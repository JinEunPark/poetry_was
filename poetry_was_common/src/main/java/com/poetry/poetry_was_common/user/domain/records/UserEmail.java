package com.poetry.poetry_was_common.user.domain;

import org.springframework.util.Assert;

public record UserEmail(String value) {

    public UserEmail {
        Assert.notNull(value, "UserEmail value must not be null");
        Assert.isTrue(value.length() > 0, "UserEmail value must not be empty");
        Assert.isTrue(value.contains("@"), "email must contain @");
    }
}
