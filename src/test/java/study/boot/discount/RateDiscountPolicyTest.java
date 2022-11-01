package study.boot.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.boot.member.Grade;
import study.boot.member.Member;



class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 구매고객은 10% 할인이 되어야함")
    void vip_have_to_be_discounted_10_percent() {
        //given
        Member member = new Member(1L, "Tanos", Grade.VIP);
        //when
        int discountedPrice = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌 구매고객은 할인이 되지 않아야함")
    void non_vip_have_to_be_discounted_0_percent() {
        //given
        Member member = new Member(1L, "Tanos", Grade.BASIC);
        //when
        int discountedPrice = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }
}