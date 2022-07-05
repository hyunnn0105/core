package com.spring.core.chap02.config;

import com.spring.core.chap02.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 스프링 빈을 등록하는 설정파일 -> @Configuration
@Configuration
public class HotelConfig {
    
    // 빈 등록 방식 1. 생성자 주입 , 2.세터 주입
    @Bean
    public Chef chef(){
        // 주입할거X
        return new KimuraChef();
    }
    @Bean(name = "sc")
    public Course Sushicourse(){
        return new SushiCourse();
    }

    @Bean(name = "fc")
    public Course frenchCourse(){
        return new FrendhCourse();
    }

    @Bean(name = "res") // 빈 이름 짓기 -> 안지으면 기본값 생성?
    public Restaurant restaurant(){
        // 생성자주입(constructor injection)** 더 안전함
//        EasternRestaurant er = new EasternRestaurant(chef(), Sushicourse());

        // 수정자 주입(setter injection) like builder
        EasternRestaurant er = new EasternRestaurant();
        er.setChef(chef());
        er.setCourse(Sushicourse());

        return er;
    }
    
    // java 생성자 빌더 패턴 but 생성자가 가장 좋다
    
    @Bean
    public Hotel hotel(){
        return new Hotel(restaurant(), chef());
    }
    
    
}
