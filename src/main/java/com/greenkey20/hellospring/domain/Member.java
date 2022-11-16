package com.greenkey20.hellospring.domain;

// 2022.11.16(수) 18h40
public class Member {
    // 프로젝트 요구사항에 따라 2가지 속성을 가짐
    private Long id; // 식별자 = 데이터 구분을 위해 시스템에 저장 시 등록되는 + 시스템이 저장하는/정해주는(o) 고객이 정하는(x) id, db에 저장하든 시퀀스로 오르든 임의의 값
    private String name; // 회원의 이름/name = 회원이 가입 시 직접 기입한 이름

    // g/setter 선호에 대한 논의와 별개로, 이 프로젝트는 가장 쉬운 예제로 하는 거니까 g/setter 다 만듦
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
