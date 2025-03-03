package com.javaee.ex08.controller;

import com.javaee.ex08.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @GetMapping("/test_arithmetic_exception")
    public void testArithmeticException(){
        int i = 1 / 0;
    }
    @GetMapping("/test_array_index_out_of_bounds_exception")
    public void testArrayIndexOutOfBoundsException(){
        int[] arr = {1,2,3,4,5};
        arr[5] = 10;
    }
    @GetMapping("/test_default_exception")
    public void testDefaultException(){
        Object object = null;
        System.out.println(object.getClass());
    }
    @GetMapping("/test_self_defined_exception")
    public void testSelfDefinitionException()throws MyException {
        throw new MyException("写文件失败");
    }
}
