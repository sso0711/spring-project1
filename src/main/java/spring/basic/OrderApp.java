package spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.basic.member.Grade;
import spring.basic.member.Member;
import spring.basic.member.MemberService;
import spring.basic.member.MemberServiceImpl;
import spring.basic.order.Order;
import spring.basic.order.OrderService;
import spring.basic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        // 스프링 컨테이너 생성.
        // 매개변수로 넘어온 AppConfig에 있는 모든 스프링 빈들을 스프링 컨테이너에 등록한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // getBean(빈 이름, 빈 타입)으로 컨테이너에서 찾는다.
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
