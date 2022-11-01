package study.boot.discount;

import study.boot.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
