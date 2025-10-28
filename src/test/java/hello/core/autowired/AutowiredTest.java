package hello.core.autowired;

import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        //Autowired 옵션 테스트
        //주입할 빈이 없을때 사용하는 옵션
        //Autowired(required = ture): 기본값

        //Autowired(required = false): 주입받을 빈 없으면 호출하지 않도록 함
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        //@Nullable: 주입받을 빈 없으면 호출하고 null을 넣어줌
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        //Optional<>: 주입받을 빈 없으면 호출하고 Optional.empty로 감싸줌
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
