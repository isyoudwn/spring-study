package isyoudwn.core.order;

import isyoudwn.core.discount.DiscountPolicy;
import isyoudwn.core.discount.FixDiscountPolicy;
import isyoudwn.core.member.Member;
import isyoudwn.core.member.MemberRepository;
import isyoudwn.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
