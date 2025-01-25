package com.poetry.poetry_was_common.user.domain;

import org.springframework.util.Assert;

public record UserName(String value) {
    public UserName {
        Assert.notNull(value, "UserName value must not be null");
        Assert.isTrue(value.length() > 0, "UserName value must not be empty");
    }
}
