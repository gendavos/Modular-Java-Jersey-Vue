package com.app.api;

import com.app.model.BaseResponse;
import org.glassfish.jersey.server.ParamException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class HandleInputJsonParseException implements ExceptionMapper<ParamException>{
    @Override
    public Response toResponse(ParamException e) {
        BaseResponse resp = new BaseResponse();
        resp.setErrorMessage("illegal value for parameter '" + e.getParameterName() + "'");
        return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(resp)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}
