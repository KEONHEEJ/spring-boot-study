package study.boot.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.boot.AutoAppConfig;
import study.boot.member.MemberService;

public class AutoAppConfigTest {

    @Test
    @DisplayName("컴포넌트 스캔 자동 주입 테스트")
    void basicScan() {
            AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
