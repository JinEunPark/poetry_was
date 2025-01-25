package com.poetry.poetry_was_common.user.presentation.api;

import com.poetry.poetry_was_common.user.application.command.RetrieveUserInfoCommand;
import com.poetry.poetry_was_common.user.application.command.TestCommand;
import com.poetry.poetry_was_common.user.application.dispatcher.CommandDispatcher;
import com.poetry.poetry_was_common.user.application.dispatcher.CommandDispatcherImpl;
import com.poetry.poetry_was_common.user.domain.records.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.DrbgParameters;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final CommandDispatcher commandDispatcher;


    @GetMapping("/test/")
    public ResponseEntity<String> test() {
        var result = commandDispatcher.dispatch(new TestCommand("api test command"));
        return ResponseEntity.ok(result.toString());
    }

    @GetMapping("/get/user/info")
    public ResponseEntity<UserId> getUserInfo(RetrieveUserInfoCommand command) {
        UserId userId = commandDispatcher.dispatch(command);
        return ResponseEntity.ok().body(userId);
    }


}
