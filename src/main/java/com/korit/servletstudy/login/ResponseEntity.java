package com.korit.servletstudy.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class ResponseEntity<T> {
    private int status;
    private T body;

    public void response(ServletResponse response) throws IOException {
        HttpServletResponse httpsResponse = (HttpServletResponse) response;
        httpsResponse.setStatus(status);
        httpsResponse.setContentType("application/json");
        httpsResponse.getWriter().println(JsonParserUtil.stringify(this));
    }
}

