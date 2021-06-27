package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    //원래는 동시성 문제 때문에 ConCurrentHashMap 사용해야 함
    @Override
    public void save(Member member) {
        // TODO Auto-generated method stub
        store.put(member.getId(), member);
        
    }

    @Override
    public Member findById(Long memberId) {
        // TODO Auto-generated method stub
        return store.get(memberId);
    }


    
    
}
