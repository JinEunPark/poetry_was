package com.poetry.poetry_was_common.user.application.interfaces;

public interface CommandHandler <R,T extends Command>{
    R handle(T command);
}
