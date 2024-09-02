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
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()


    // call AppConfig,memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("AppConfig.discountPolicy");
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
