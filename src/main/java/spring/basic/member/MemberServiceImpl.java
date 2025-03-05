package spring.basic.member;

public class MemberServiceImpl implements MemberService {

    // 객체의 생성과 주입 책임은 AppConfig에 위임(SRP)
    // 실행만 담당
    private final MemberRepository memberRepository;
    // 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); //MemoryMemberRepository의 함수가 호출된다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId); //MemoryMemberRepository의 함수가 호출된다.
    }
}
