package study.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.boot.member.Grade;
import study.boot.member.Member;
import study.boot.member.MemberService;
import study.boot.member.MemberServiceImpl;
import study.boot.order.Order;
import study.boot.order.OrderService;
import study.boot.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "hey", Grade.VIP);
        memberService.join(member);

        Order createdOrder = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(createdOrder.toString());
    }
}
