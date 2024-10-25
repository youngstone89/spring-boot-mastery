package com.youngstone.mastery.resolver;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.youngstone.mastery.exception.CustomException3;
import com.youngstone.mastery.exception.CustomException4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomHandlerExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    @Nullable
    protected ModelAndView doResolveException(
            HttpServletRequest request, HttpServletResponse response,
            @Nullable Object handler, Exception ex) {
        // Check if the exception is of the type CustomException
        if (ex instanceof CustomException3) {
            try {
                // Set the response status
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());

                // Create and return an empty ModelAndView
                return new ModelAndView();
            } catch (Exception e) {
                logger.error("Handling CustomException failed", e);
            }
        } else if (ex instanceof CustomException4) {
            try {
                // Set the response status
                response.sendError(HttpServletResponse.SC_FORBIDDEN, ex.getMessage());

                // Create and return an empty ModelAndView
                return new ModelAndView();
            } catch (Exception e) {
                logger.error("Handling CustomException failed", e);
            }

        }
        return null; // Allow other resolvers to handle this exception if not handled here
    }

}
