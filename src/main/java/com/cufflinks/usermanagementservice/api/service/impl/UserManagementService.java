package com.cufflinks.usermanagementservice.api.service.impl;

import com.cufflinks.common.dataService.TeamService;
import com.cufflinks.common.dto.entity.Team;
import com.cufflinks.common.dto.model.request.LoginRequest;
import com.cufflinks.common.dto.model.response.LoginResponse;
import com.cufflinks.common.util.JWTUtil;
import com.cufflinks.usermanagementservice.infra.builder.FailureResponseBuilder;
import com.cufflinks.usermanagementservice.infra.builder.SuccessResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManagementService {
    @Autowired
    private FailureResponseBuilder failureResponseBuilder;

    @Autowired
    private SuccessResponseBuilder successResponseBuilder;

    @Autowired
    private TeamService teamService;

    private JWTUtil jwtUtil = new JWTUtil();

    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        Optional<Team> team = teamService.findByTeamName(loginRequest.getTeamName());
        LoginResponse loginResponse;
        if(!team.isPresent()){
            loginResponse = failureResponseBuilder.emptyLoginRequest();
        } else {
            if(team.get().getPassword().equals(loginRequest.getPassword())){
                String token = jwtUtil.generateToken(team.get());
                loginResponse = successResponseBuilder.successLoginRequest(token,team.get());
            }else{
                loginResponse = failureResponseBuilder.invalidCredentials();
            }
        }
        return loginResponse;
    }
}
