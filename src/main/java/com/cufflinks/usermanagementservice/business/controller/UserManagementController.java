package com.cufflinks.usermanagementservice.business.controller;

import com.cufflinks.common.dto.model.request.LoginRequest;
import com.cufflinks.common.dto.model.response.LoginResponse;
import com.cufflinks.usermanagementservice.api.service.impl.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/login")
    public LoginResponse login(LoginRequest loginRequest){
        LOGGER.info("Incoming Login request [{}]",loginRequest);
        LoginResponse loginResponse = userManagementService.authenticateUser(loginRequest);
        LOGGER.info("Outgoing Login request [{}]",loginResponse);
        return loginResponse;
    }
}
