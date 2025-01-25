package com.poetry.poetry_was_common.user.application.dispatcher;

import com.poetry.poetry_was_common.user.application.interfaces.Command;
import com.poetry.poetry_was_common.user.application.interfaces.CommandHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandDispatcherImpl implements CommandDispatcher{
    private final Map<Class<? extends Command>, CommandHandler<?, ? extends Command>> handlers = new HashMap<>();

    public CommandDispatcherImpl(List<CommandHandler<?, ? extends Command>> handlerList) {
        for (CommandHandler<?, ? extends Command> handler : handlerList) {
            // 제네릭 타입에서 Command 타입 추출
            ParameterizedType parameterizedType = (ParameterizedType) handler.getClass().getGenericInterfaces()[0];

            Class<? extends Command> commandType = (Class<? extends Command>) parameterizedType.getActualTypeArguments()[1];

            handlers.put(commandType, handler);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R, T extends Command> R dispatch(T command) {
        CommandHandler<R, T> handler = (CommandHandler<R, T>) handlers.get(command.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for command: " + command.getClass().getName());
        }
        return handler.handle(command);
    }
}
