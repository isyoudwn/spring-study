package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) // 스프링과 함께 테스트하기 위함
@SpringBootTest // 스프링 컨테이너 안에서 테스트 실행함
@Transactional // test 클래스에서는, roll-back이 된다. -> DB에 저장이 안 된다.
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

         //then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
    }
}