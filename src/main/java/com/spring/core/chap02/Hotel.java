package com.spring.core.chap02;

import lombok.Builder;

//@Builder 빌더 생김
public class Hotel {

    // 호텔 레스토랑 운영 의존관계?
    /*
    private EasterRestaurant restaurant;
    private KimChef headChef;
    // 구현체에 의존X
    */

    
    private Restaurant restaurant;
    private Chef headChef;

    // 생성자 초기화?
    // 확장에는 열려있지만 수정에는 연결XX -> ocp 위반코드/dip,


    
    public Hotel(Restaurant restaurant, Chef chef){
        // 구현체에 의존하고있기도 함
        this.restaurant = restaurant;
        this.headChef = chef;
    }

    // 호텔의 기능
    public void inform(){
        System.out.printf("우리 호텔의 레스토랑은 %s이며, 헤드쉐프는 %s입니다.\n"
                , restaurant.getClass().getSimpleName(), headChef.getClass().getSimpleName());
        restaurant.reserve();
    }

}
