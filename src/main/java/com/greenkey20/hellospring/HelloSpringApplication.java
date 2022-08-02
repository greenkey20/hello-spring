package com.greenkey20.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 2022.8.1(월) 19h start.spring.io에서 generate한 build.gradle 파일을 project로써 열면, 이 파일/클래스가 만들어져 있음
아래 main() 메소드 실행(run)하고 브라우저로 localhost:8080 접속하면 에러 페이지 뜸 = 프로젝트 환경 설정 성공
아래 main() 메소드 실행하면 @SpringBootApplication 어노테이션에 따라 Spring Boot 애플리케이션이 실행됨 + Tomcat이라는 웹서버를 내장(embedded)하고 있는데, Tomcat 웹서버를 자체적으로 띄우면서 Spring Boot가 같이 올라옴

과거에는 WAS(웹서버 e.g. Tomcat)를 서버에 직접 설치해두고, 거기에 Java 코드를 밀어넣음 -> 웹서버와 개발 라이브러리의 분리 -> Tomcat 서버 깔고, 들어가서 뭐 설치하고, 해야 했음(힘든 작업)
vs 요즘에는 소스 라이브러리에서 웹서버를 들고/내장하고 있음(embedded) -> Java main() 메소드만 실행하면 + 별도 설정 없이 웹서버 뜨고 8080으로 들어갈 수 있음 -> 라이브러리 하나 빌드해서 웹서버에 올리면 됨
 */

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
