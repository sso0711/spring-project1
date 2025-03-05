package spring.basic.order;

import spring.basic.discount.DiscountPolicy;
import spring.basic.discount.FixDiscountPolicy;
import spring.basic.member.Member;
import spring.basic.member.MemberRepository;
import spring.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    // 객체의 생성과 주입 책임은 AppConfig에 위임(SRP)
    // 실행만 담당
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 생성자 주입
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*
    * 주문 생성이 되면 먼저 회원 정보 조회를 하고, 할인
    * */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //단일책임원칙을 잘 지킨 설계이다! (주문,할인 분리)
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
