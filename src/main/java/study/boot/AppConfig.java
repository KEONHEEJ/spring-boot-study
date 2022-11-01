package study.boot;

import study.boot.discount.DiscountPolicy;
import study.boot.discount.FixDiscountPolicy;
import study.boot.member.MemberRepository;
import study.boot.member.MemberService;
import study.boot.member.MemberServiceImpl;
import study.boot.member.MemoryMemberRepository;
import study.boot.order.OrderService;
import study.boot.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
