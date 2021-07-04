package hello.core.member;

public interface MemberService {
    void join(Member member); //회원가입
    Member finMember(Long memberId); // 회원 검색

}
