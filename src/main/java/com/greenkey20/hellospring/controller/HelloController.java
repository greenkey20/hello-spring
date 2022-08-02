package com.greenkey20.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 2022.8.2(화) 21h

@Controller
public class HelloController {

    // web application에서 '/hello'라고 들어오면(url 매칭) 이 메소드를 Spring이 호출/실행함
    @GetMapping("hello")
    public String hello(Model model) { // Spring이 Model이란 것을 만들어서 넣어줌
//        model.addAttribute("data", "hello ^^");
        model.addAttribute("data", "spring~");
        return "hello"; // resources > templates에 있는 hello.html 문서를 Spring이 찾아(가)서 rendering/이 문서 실행해라(thymeleaf template engine이 처리해줌)
    }
}
