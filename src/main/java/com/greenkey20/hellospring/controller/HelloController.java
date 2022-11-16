package com.greenkey20.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 2022.8.2(화) 21h
@Controller
public class HelloController {
    // thymeleaf 템플릿엔진 동작 확인
    @GetMapping("hello") // // web application에서 '/hello'라고 들어오면(url 매칭) 이 메소드를 Spring이 호출/실행함
    public String hello(Model model) { // Spring이 Model이란 것을 만들어서 넣어줌
//        model.addAttribute("data", "hello ^^");
        model.addAttribute("data", "spring~");
        return "hello"; // resources > templates에 있는 hello.html 문서를 Spring이 찾아(가)서 rendering/이 문서 실행해라(thymeleaf template engine이 처리해줌)
    }

    // web 개발 3가지 방법
    // 방법1) 정적 컨텐츠 = 특정 html 문서를 url로 직접 요청 -> 해당 정적 파일을 그대로 클라이언트에게 전달/반환

    // 2022.11.16(수) 15h15 방법2) MVC + 템플릿엔진 = viewResolver가 view 찾아주고 템플릿엔진 연결 -> 템플릿엔진이 렌더링한 html 반환
    // 15h30 요청 시 400 bad request 오류 = Resolved [org.springframework.web.bind.MissingServletRequestParameterException: Required request parameter 'name' for method parameter type String is not present]
    // Mac 단축 키 cmd + p = parameter info -> @RequestParam required 속성의 default 값 = true -> "name" 키 값 필수적으로 요청 시 받아야 함
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 2022.11.16(수) 17h5 방법3) API
    @GetMapping("hello-string")
    @ResponseBody // html의 body tag(x) http 통신 프로토콜(응답)의 header/body부(o)에 데이터를 내가 직접 넣어주겠다, 데이터를 그냥 넘겨야겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello, " + name; // view 없음 + 이 문자열 자체가 응답으로써 내려감
    }

    // 2022.11.16(수) 17h15
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // tip = 문장 쓰다가 cmd + shift + Enter -> 남은 문장 자동 완성
        hello.setName(name);
        return hello; // JSON 형태로 데이터가 응답/반환됨
        /* 과거에는 XML 방식도 많이 쓰였음
        HTML도 여/닫는 태그 있음 = XML 방식
        특징 = 무거움 + 여/닫는 태그 2번 써야 하므로 번거로움

        vs JSON = simple -> 최근(2020년 강의 제작 시점) 거의 JSON으로 통일됨
        객체 반환하고 @ResponseBody = Spring에서는 기본적으로(default setting) JSON으로 반환
         */
    }

    // static 클래스 하나 만듦 -> 이 클래스 안에서 사용 가능(HelloController.Hello)
    static class Hello {
        // Java bean 규약/표준방식 = property (접근)방식 = 필드는 private인 바, 외부에서 바로 못 꺼냄 -> public 메서드(g/setter)를 통해서 접근
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
