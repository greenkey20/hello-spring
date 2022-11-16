package com.greenkey20.hellospring.repository;

import org.junit.jupiter.api.Test;

// 2022.11.16(수) 19h40
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository  = new MemoryMemberRepository();

    // MemoryMemberRepository에서 만든 save() 기능이 동작하는지/회원 저장되는지 해봄 = @Test annotation 붙이면 해당 메서드를 그냥 실행할 수 있게 됨
    @Test
    public void save() {
        // main() 쓰는 것과 비슷

    }
}
