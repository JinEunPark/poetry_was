package com.poetry.poetry_was_common.user.application.dispatcher;

import com.poetry.poetry_was_common.user.application.interfaces.Command;

public interface CommandDispatcher {
    public <R, T extends Command> R dispatch(T command);
}
