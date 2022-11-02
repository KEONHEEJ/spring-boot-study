package study.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.boot.discount.DiscountPolicy;
import study.boot.discount.FixDiscountPolicy;
import study.boot.discount.RateDiscountPolicy;
import study.boot.member.MemberRepository;
import study.boot.member.MemberService;
import study.boot.member.MemberServiceImpl;
import study.boot.member.MemoryMemberRepository;
import study.boot.order.OrderService;
import study.boot.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
