package com.ALC.SC2BOAserver.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class HealthCheckController { 
    @RequestMapping(value="/healthcheck", method=RequestMethod.HEAD)
    public void healthCheck(HttpServletResponse response) {
        response.setContentLength(0);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
