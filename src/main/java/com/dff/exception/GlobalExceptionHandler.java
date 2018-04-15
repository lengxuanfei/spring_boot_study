package com.dff.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: GlobalExceptionHandler
 * @Author: daifeifei
 * @CreateDate: 2018/4/13 1:09
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error", e);
        mv.addObject("url", request.getRequestURI());
        mv.setViewName("error");
        return mv;
    }

//    @ExceptionHandler
//    @ResponseBody
//    public String defaultExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
//        return e.getMessage();
//    }
}
