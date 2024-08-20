package isyoudwn.core.discount;

import isyoudwn.core.member.Grade;
import isyoudwn.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
  @Test
  @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
  void vip_o() {
      Member member = new Member(1L, "memberVIP", Grade.VIP);
      int discount = rateDiscountPolicy.discount(member, 10000);
      assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("BASIC은 10% 할인이 적용되지 않는다.")
  void vip_x() {
      Member member = new Member(1L, "memberBASIC", Grade.BASIC);
      int discount = rateDiscountPolicy.discount(member, 10000);
      assertThat(discount).isEqualTo(0);
  }
}