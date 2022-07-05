package com.spring.core.chap01_2.config;

import com.spring.core.chap01_2.EasternRestaurant;
import com.spring.core.chap01_2.Restaurant;
import com.spring.core.chap01_2.*;

// 스프링이 호텔 매니저 같은 기능을 한다
// Bean Factory - Bean은 객체 - 객체공장
// = spring container
// 호텔에 필요한 객체들을 생성하고 조립하여 객체간의 의존관계를 설정하는 역할
// 여기서 모든것을 결정하고있음!! return

public class HotelManager {
    // 쉐프객체를 생성하여 리던하는 메서드 -> Bean
    public Chef chef(){
        return new JuanChef();
    }
    public Course course(){
        return new FrendhCourse();
    }
    public Restaurant restaurant(){
        return new WesternRestaurant(chef(), course());
    }
    public Hotel hotel(){
        return new Hotel(restaurant(), chef());
    }

}
