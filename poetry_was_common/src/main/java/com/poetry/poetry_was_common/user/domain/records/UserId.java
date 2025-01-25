package com.poetry.poetry_was_common.user.domain;

import org.springframework.util.Assert;

public record UserId(Long value) {

    public UserId(Long value) {
        Assert.notNull(value, "UserId value must not be null");
        this.value = value;
    }
}
