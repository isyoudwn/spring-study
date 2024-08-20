package isyoudwn.core;

import isyoudwn.core.member.Grade;
import isyoudwn.core.member.Member;
import isyoudwn.core.member.MemberService;
import isyoudwn.core.order.Order;
import isyoudwn.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }
}
