package com.javaee.ex08.controller;

import com.javaee.ex08.exception.MyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public String doArithmeticException(ArithmeticException e, Model model){
        model.addAttribute("exp_type", "该异常由注解方法统一处理");
        model.addAttribute("exp_info", e.getMessage());
        return "forward:/exception/arithmetic_exception.jsp";
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String doArrayIndexOutOfBoundsException(
            ArrayIndexOutOfBoundsException e, Model model){
        model.addAttribute("exp_type", "该异常由注解方法统一处理");
        model.addAttribute("exp_info", e.getMessage());
        return "forward:/exception/out_of_bounds_exception.jsp";
    }
    @ExceptionHandler(MyException.class)
    public String doMyException(MyException e, Model model){
        model.addAttribute("exp_type", "该异常由注解方法统一处理");
        model.addAttribute("exp_info", e.getMessage());
        return "forward:/exception/self_defined_exception.jsp";
    }
    @ExceptionHandler(Exception.class)
    public String doException(Exception e, Model model){
        model.addAttribute("exp_type", "该异常由注解方法统一处理");
        model.addAttribute("exp_info", e.getMessage());
        System.out.println(e.getMessage());
        return "forward:/exception/else_exception.jsp";
    }
}
