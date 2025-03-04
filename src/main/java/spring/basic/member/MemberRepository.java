package spring.basic.member;

public interface MemberRepository {
    // 회원 저장
    void save(Member member);

    // 회원 아이디로 찾기
    Member findById(Long memberId);
}
