package com.greenkey20.hellospring.repository;

import com.greenkey20.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// 2022.11.16(수) 18h45
public interface MemberRepository {
    // 기능
    Member save(Member member); // 회원을 저장소에 저장
    Optional<Member> findById(Long id); // Optional = Java8에서 들어간 기능 -> id나 이름으로 검색 시 검색 결과가 없어 null이 반환될 수 있는데, null 처리 방법으로써 null을 그대로(x) Optional로 감싸서(o) 반환하는 방식 선호
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모든 회원 list를 반환
}
