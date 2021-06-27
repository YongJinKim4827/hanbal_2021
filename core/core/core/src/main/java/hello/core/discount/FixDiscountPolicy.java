package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discoutFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        // TODO Auto-generated method stub
        if(member.getGrade() == Grade.VIP){ //enum은 == 쓰는게 맞음
            return discoutFixAmount;
        }else{
            return 0;
        }
    }
    
}
