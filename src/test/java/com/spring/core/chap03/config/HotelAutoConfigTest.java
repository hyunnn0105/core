package com.spring.core.chap03.config;

import com.spring.core.chap03.Chef;
import com.spring.core.chap03.Hotel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class HotelAutoConfigTest {
    @Test
    @DisplayName("component 애너테이션이 붙은 빈들이 등록되어야한다")
    void CheckBeans(){

        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(HotelAutoConfig.class);

        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
        // Autowiring 자동결합 -> 생성자의 타입을 보고 자동으로 넣어줌
    }

    @Test
    @DisplayName("자동 빈이 등록되면 자동주입에 실패해랴한다")
    void CheckBeans1(){

        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(HotelAutoConfig.class);

        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
        // Autowiring 자동결합 -> 생성자의 타입을 보고 자동으로 넣어줌
    }

}