package isyoudwn.core.discount;

import isyoudwn.core.member.Grade;
import isyoudwn.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        else {
            return 0;
        }

    }
}
