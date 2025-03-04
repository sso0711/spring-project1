package spring.basic.member;

public class MemberServiceImpl implements MemberService {

    // 인터페이스와 구현체 모두에 의존!! (DIP 위반)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member); //MemoryMemberRepository의 함수가 호출된다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId); //MemoryMemberRepository의 함수가 호출된다.
    }
}
