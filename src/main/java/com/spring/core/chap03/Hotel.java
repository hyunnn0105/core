package com.spring.core.chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hotel {

    // 호텔 레스토랑 운영 의존관계?
    /*
    private EasterRestaurant restaurant;
    private KimChef headChef;
    // 구현체에 의존X
    */

    
    private final Restaurant restaurant;
    private final Chef headChef;

    // 생성자 초기화?
    // 확장에는 열려있지만 수정에는 연결XX -> ocp 위반코드/dip,


    // 내가 주입받을 빈의 명칭 입력
        //생성자 주입 사용시 생성자가 딱 한개면 오토와이어없이도 자동으로 생성자주입을 수행
    // @Qualifier(의존할 객체) -> 의존객체 선택
    @Autowired // 자동의존성 주입
    public Hotel(@Qualifier("EasternRestaurant") Restaurant restaurant
            , @Qualifier("kc") Chef chef){
        System.out.println("hotel 생성자 호출");
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
