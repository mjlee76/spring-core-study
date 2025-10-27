package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //기존 AppConfig에서 수동 등록한 빈은 스캔하지 않도록 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // memoryMemberRepository는 이미 빈으로 자동등록되어있지만 같은 이름으로 수동으로 등록해보자
    // 테스트는 실행이 된다 -> 수동으로 등록한게 우선으로 오버라이딩됨.
    // 하지만 스프링 부트를 실행하면 이걸 오류로 처리해버림.
    // 이렇게 오버라이딩 되도록하면 나중에 꼬일 수 있기 때문.
    // 하지만 이 기능 사용하고 싶으면 application.properties에
    // spring.main.allow-bean-definition-overriding=true 로 설정하면 실행 가능하다.
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
