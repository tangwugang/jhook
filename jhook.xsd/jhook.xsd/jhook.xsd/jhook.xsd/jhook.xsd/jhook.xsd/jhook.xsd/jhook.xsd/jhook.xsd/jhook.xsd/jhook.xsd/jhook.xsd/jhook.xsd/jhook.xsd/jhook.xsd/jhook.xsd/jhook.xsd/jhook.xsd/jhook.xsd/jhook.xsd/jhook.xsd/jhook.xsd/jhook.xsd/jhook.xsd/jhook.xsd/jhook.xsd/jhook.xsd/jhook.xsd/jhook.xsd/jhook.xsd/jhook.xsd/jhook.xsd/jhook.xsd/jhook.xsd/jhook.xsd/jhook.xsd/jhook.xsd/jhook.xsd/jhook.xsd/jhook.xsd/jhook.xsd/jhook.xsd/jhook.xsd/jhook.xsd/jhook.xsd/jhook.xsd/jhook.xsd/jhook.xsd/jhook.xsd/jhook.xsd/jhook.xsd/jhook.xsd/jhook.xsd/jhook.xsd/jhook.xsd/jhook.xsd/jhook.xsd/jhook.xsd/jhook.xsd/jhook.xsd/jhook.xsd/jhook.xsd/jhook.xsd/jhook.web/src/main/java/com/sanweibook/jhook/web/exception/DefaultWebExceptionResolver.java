package com.sanweibook.jhook.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by twg on 16/12/27.
 */
@Slf4j
public class DefaultWebExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // Expose ModelAndView for chosen error view.
        String viewName = determineViewName(ex, request);
        if (viewName != null) {
            /*非ajax请求*/
            if (request.getHeader("x-requested-with") == null || !request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            }
            try {
                PrintWriter writer = response.getWriter();
                writer.write(ex.getMessage());
            } catch (IOException e) {
                log.error("ajax请求异常：",e);
            }
            return null;
        } else {
            return null;
        }
    }
}
