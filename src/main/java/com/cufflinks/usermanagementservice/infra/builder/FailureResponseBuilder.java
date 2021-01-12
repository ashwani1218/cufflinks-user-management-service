package com.cufflinks.usermanagementservice.infra.builder;

import com.cufflinks.common.constants.ResponseConstants;
import com.cufflinks.common.dto.model.response.LoginResponse;
import com.cufflinks.common.dto.model.response.RegistrationResponse;
import com.cufflinks.common.dto.model.response.UpdateTeamResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FailureResponseBuilder {

    /**
     *
     * @return
     */
    public LoginResponse emptyLoginRequest() {
        LoginResponse resp = new LoginResponse();
        resp.setHttpStatus(HttpStatus.BAD_REQUEST);
        resp.setResponseCode(ResponseConstants.EMPTY_LOGIN_REQUEST);
        resp.setResponseDescription(ResponseConstants.EMPTY_LOGIN_REQUEST);
        resp.setStatus(ResponseConstants.FAILED_STATUS);
        return resp;
    }

    /**
     * @return
     */
    public LoginResponse invalidCredentials() {
        LoginResponse resp = new LoginResponse();
        resp.setHttpStatus(HttpStatus.UNAUTHORIZED);
        resp.setResponseCode(ResponseConstants.UNAUTHENTIC_CODE);
        resp.setResponseDescription(ResponseConstants.UNAUTHENTIC_USER);
        resp.setStatus(ResponseConstants.FAILED_STATUS);

        return resp;
    }

    /**
     * @return
     */
    public RegistrationResponse alreadyATeam() {
        RegistrationResponse resp = new RegistrationResponse();

        resp.setHttpStatus(HttpStatus.BAD_REQUEST);
        resp.setResponseCode(ResponseConstants.ALREADY_USER_CODE);
        resp.setResponseDescription(ResponseConstants.ALREADY_TEAM);
        resp.setStatus(ResponseConstants.FAILED_STATUS);

        return resp;
    }

    /**
     * @return
     */
    public RegistrationResponse emptyRegisterRequest() {
        RegistrationResponse resp = new RegistrationResponse();

        resp.setHttpStatus(HttpStatus.BAD_REQUEST);
        resp.setResponseCode(ResponseConstants.FAILURE_CODE);
        resp.setResponseDescription(ResponseConstants.EMPTY_REGISTRATION_REQUEST);
        resp.setStatus(ResponseConstants.FAILED_STATUS);

        return resp;
    }

    /**
     * @return
     */
    public UpdateTeamResponse notATeam() {
        UpdateTeamResponse resp = new UpdateTeamResponse();
        resp.setHttpStatus(HttpStatus.BAD_REQUEST);
        resp.setResponseCode(ResponseConstants.FAILURE_CODE);
        resp.setResponseDescription(ResponseConstants.NOT_A_TEAM);
        resp.setStatus(ResponseConstants.FAILED_STATUS);
        return resp;
    }

    /**
     * @return
     */
    public UpdateTeamResponse invalidUpdateRequest() {
        UpdateTeamResponse resp = new UpdateTeamResponse();
        resp.setHttpStatus(HttpStatus.BAD_REQUEST);
        resp.setResponseCode(ResponseConstants.FAILURE_CODE);
        resp.setResponseDescription(ResponseConstants.INVALID_UPDATE_REQUEST);
        resp.setStatus(ResponseConstants.FAILED_STATUS);
        return resp;
    }
}
