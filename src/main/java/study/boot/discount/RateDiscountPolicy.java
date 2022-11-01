package study.boot.discount;

import study.boot.member.Grade;
import study.boot.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
