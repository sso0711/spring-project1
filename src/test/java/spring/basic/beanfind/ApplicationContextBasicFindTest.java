package spring.basic.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.basic.AppConfig;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회하기")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //역할이 아닌 구현에 의존한 것이므로 좋지 않다.
    @Test
    @DisplayName("구체 타입으로 조회하기")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //실패테스트
    @Test
    @DisplayName("해당하는 빈이 없음")
    void findBeanByNoName() {
        // 아래 코드를 추가하면 NoSuchBeanDefinitionException 에러가 난다.
        // MemberService memberService = ac.getBean("xxxxxx", MemberService.class);

        //예외가 발생해야 성공
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxxxx", MemberService.class));
    }
}
