package isyoudwn.core;

import isyoudwn.core.discount.DiscountPolicy;
import isyoudwn.core.discount.FixDiscountPolicy;
import isyoudwn.core.member.MemberRepository;
import isyoudwn.core.member.MemberService;
import isyoudwn.core.member.MemberServiceImpl;
import isyoudwn.core.member.MemoryMemberRepository;
import isyoudwn.core.order.OrderService;
import isyoudwn.core.order.OrderServiceImpl;

// 생성자를 통해 객체 주입
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
