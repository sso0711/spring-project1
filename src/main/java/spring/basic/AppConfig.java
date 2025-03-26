package spring.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.member.MemberRepository;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;
import spring.basic.member.MemoryMemberRepository;
import spring.basic.order.Order;
import spring.basic.order.OrderService;
import spring.basic.order.OrderServiceImpl;

//객체의 생성과 연결을 담당 (관심사의 분리)
//이를 통해 DIP원칙을 준수할 수 있다.
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
