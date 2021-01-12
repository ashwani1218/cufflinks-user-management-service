package com.cufflinks.usermanagementservice.infra.builder;

import com.cufflinks.common.constants.ResponseConstants;
import com.cufflinks.common.dto.entity.Team;
import com.cufflinks.common.dto.model.response.LoginResponse;
import com.cufflinks.common.dto.model.response.RegistrationResponse;
import com.cufflinks.common.dto.model.response.UpdateTeamResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class SuccessResponseBuilder {

    /**
     * @param token
     * @return
     */
    public LoginResponse successLoginRequest(String token, Team team) {
        LoginResponse resp = new LoginResponse();

        resp.setHttpStatus(HttpStatus.OK);
        resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
        resp.setResponseDescription(ResponseConstants.SUCCESS_LOGIN_DESCRIPTION);
        resp.setStatus(ResponseConstants.SUCCESS_STATUS);
        resp.setTeam(team);
        resp.setToken(token);
        return resp;
    }

    /**
     * @return
     */
    public RegistrationResponse successRegisterRequest() {
        RegistrationResponse resp = new RegistrationResponse();
        resp.setHttpStatus(HttpStatus.CREATED);
        resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
        resp.setResponseDescription(ResponseConstants.SUCCESS_REGISTRATION);
        resp.setStatus(ResponseConstants.SUCCESS_STATUS);
        return resp;
    }

    /**
     * @return
     */
    public UpdateTeamResponse successUpdateRequest() {
        UpdateTeamResponse resp = new UpdateTeamResponse();
        resp.setHttpStatus(HttpStatus.CREATED);
        resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
        resp.setResponseDescription(ResponseConstants.SUCCESS_UPDATE);
        resp.setStatus(ResponseConstants.SUCCESS_STATUS);
        return resp;
    }
}
