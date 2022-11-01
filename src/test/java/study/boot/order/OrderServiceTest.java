package study.boot.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.boot.AppConfig;
import study.boot.member.Grade;
import study.boot.member.Member;
import study.boot.member.MemberService;
import study.boot.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;

        memberService.join(new Member(memberId, "Tanos", Grade.VIP));
        Order order = orderService.createOrder(memberId, "SpaceStone", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
