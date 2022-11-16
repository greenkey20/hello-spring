package com.greenkey20.hellospring.repository;

import com.greenkey20.hellospring.domain.Member;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// 2022.11.16(수) 18h55
// 'implements 인터페이스'한 뒤에 option + Enter = options 목록 보고 선택 가능
public class MemoryMemberRepository implements MemberRepository {
    /* 메모리 어딘가에 저장을 해 두어야 함 -> Map을 사용하기로 함
    실무에서는 동시성 문제가 있을 수 있어, 공유되는 변수일 때는 ConcurrentHashMap 사용 vs 여기에서는 예제니까 단순하게 HashMap 사용
     */
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L; // sequence = 0, 1, 2 등 key 값 생성; 실무에서는 동시성 문제를 고려해서 Long(x) AtomicLong 등(o) 사용 vs 여기에서는 그냥 가장 단순하게 함

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 회원 저장 시 store/db에 넣기 전 sequence 값을 하나 올려주어 회원의 id 값 세팅
        store.put(member.getId(), member);
        return member; // 스펙에 따라 저장된 결과를 반환해줌
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // ofNullable = id로 검색한 결과가 null이어도 Optional로 감쌀 수 있음 -> 클라이언트가 활용 가능(추후 설명)
    }

    @Override
    public Optional<Member> findByName(String name) {
        // Java8의 lambda 사용 구현
        // map store에서 loop 돌면서 이 메서드의 인자/parameter로 넘어온 name과 같은지 확인 -> 같은 경우에만 filtering -> 그 중에서 하나라도 찾으면(findAny() 연산) 바로 결과가 Optional로 반환됨 vs 끝까지 loop 돌렸는데 없으면 Optional에 null이 포함되어 반환됨
        // 2022.11.16(수) 19h25 나의 생각 = 단순 예제니까 그렇겠지만, 동명이인이 있는 경우 그냥 가장 처음 검색되는 사람 1명 정보를 반환하게 되는 로직이구나
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();

        // 인터페이스의 메서드들 자동 구현 시 추가된 코드
//        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        // Java 실무에서 list 많이 씀(loop 돌리기도 편하고) vs 현재 메모리 저장소는 map으로 되어있음
        return new ArrayList<>(store.values());
    }

    // 2022.11.16(수) 19h30 현재까지 위와 같이 구현한 코드가 제대로 동작하는지 검증 <- 테스트 케이스 작성
}
