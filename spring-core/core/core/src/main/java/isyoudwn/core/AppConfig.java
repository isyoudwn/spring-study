package isyoudwn.core;

import isyoudwn.core.discount.DiscountPolicy;
import isyoudwn.core.discount.FixDiscountPolicy;
import isyoudwn.core.discount.RateDiscountPolicy;
import isyoudwn.core.member.MemberRepository;
import isyoudwn.core.member.MemberService;
import isyoudwn.core.member.MemberServiceImpl;
import isyoudwn.core.member.MemoryMemberRepository;
import isyoudwn.core.order.OrderService;
import isyoudwn.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
// 생성자를 통해 객체 주입
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
