package com.spring.core.chap02;

import com.spring.core.chap02.config.HotelConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class HotelTeat {
    // 스프링 컨테이너에서 빈 가져오기 .class -> 클래스의 메타 데이터 가져옴
    //     AnnotationConfigApplicationContext이 @Configuration 붙은 클래스의 파일을 가져옴
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(HotelConfig.class);

    @Test
    @DisplayName("스프링 컨테이너에 등록된 빈들의 의존관계가 잘 결합되어 있어야한다")
    void beanTest(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
    }

    @Test
    @DisplayName("등록된 빈의 타입으로 빈을 가져와야한다")
    void FindbeanTypeTest(){
        Chef chef = ac.getBean(Chef.class);
        chef.cook();

        // 나는 chef의 실제 인스턴스가 kimura일것이라도 단언한다
        assertInstanceOf(KimuraChef.class, chef);
    }

    @Test
    @DisplayName("등록된 빈의 타입으로 빈을 가져와야한다")
    void FindbeanByDuplicateTest(){
//        Course course = ac.getBean(Course.class);
//        course.toString();

        // 나는 chef의 실제 인스턴스가 kimura일것이라도 단언한다
//        assertInstanceOf(KimuraChef.class, course);

        // 예외발생테스트
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class
                ,() -> ac.getBean(Course.class));
    }

    @Test
    @DisplayName("등록된 빈의 타입이 중복이면 빈의 이름과 타입으로 조회하면 된다")
    void FindbeanByDuplicateTest2(){
        Course course = ac.getBean("sc", Course.class);
        course.combineMenu();
        assertInstanceOf(SushiCourse.class, course);

    }

    @Test
    @DisplayName("등록된 빈의 이름으로 빈을 가져와야한다")
    void FindbeanByNameTest(){
        // 빈의 이름은 따로 정해놓지 않으면 등록 메서드명이 이름이 된다
        Restaurant restaurant = (Restaurant) ac.getBean("res");
        assertInstanceOf(EasternRestaurant.class, restaurant);
    }
    
    @Test
    @DisplayName("스프링 컨테이너에 등록된 모든 빈들을 출력해야한다")
    void FindAllBeans(){
        String[] beandefind = ac.getBeanDefinitionNames();
        for (String beanName : beandefind) {
            BeanDefinition bd = ac.getBeanDefinition(beanName);

            // ROLE_APPLICATION : 사용자가 직접 등록한 빈
            // ROLE_INFRASTRUCTURE : 스프링이 자체적으로 등록해서 사용하는 빈
            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println(beanName);
            }

        }
    }
}
