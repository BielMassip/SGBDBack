package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.controller.exceptions.ControllerException;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.converter.json.MappingJacksonValue;


public class BaseController {

    static String OK_MESSAGE = "\"ok\"";

    Long getLoggedUser(HttpSession session) {

        if (session == null) {
            throw new ControllerException("No sessions available!");
        }

        Long userId = (Long) session.getAttribute("simpleapp_auth_id");
        if (userId == null)
            throw new ControllerException("User is not authenticated!");

        return userId;
    }

    void checkNotLoggedIn(HttpSession session) {

        if (session == null) {
            throw new ControllerException("No sessions available!");
        }

        Long userId = (Long) session.getAttribute("simpleapp_auth_id");
        if (userId != null)
            throw new ControllerException("User is already authenticated!");
    }

    MappingJacksonValue toResponse(Object pojo, Class<?> view) {
        final MappingJacksonValue result = new MappingJacksonValue(pojo);
        result.setSerializationView(view);
        return result;
    }

}