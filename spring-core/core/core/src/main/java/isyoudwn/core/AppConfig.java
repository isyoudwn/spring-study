package isyoudwn.core;

import isyoudwn.core.discount.FixDiscountPolicy;
import isyoudwn.core.member.MemberService;
import isyoudwn.core.member.MemberServiceImpl;
import isyoudwn.core.member.MemoryMemberRepository;
import isyoudwn.core.order.OrderService;
import isyoudwn.core.order.OrderServiceImpl;

// 생성자를 통해 객체 주입
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
