package com.spring.core.chap03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class EasternRestaurant implements Restaurant {

    // 역할에 의존하기 - 쉐프면 노상관
    private Chef chef;
    //암튼 코스 요리가 있다
    private Course course;

//    @Autowired
    // 변경할거 X -> 외부에서 넣어주는거 기다림
    public EasternRestaurant(Chef chef, Course course){
        this.chef = chef;
        this.course = course;
    }

    @Override
    public void reserve() {
        course.combineMenu();
    }

    @Override
    public void order() {
        chef.cook();
    }

    // 수성자 주입
    @Autowired
    @Qualifier("kc")
    public void setChef(Chef chef) {
        System.out.println("\n");
        System.out.println("Eastern set chef");
        System.out.println("\n");
        this.chef = chef;

    }
    @Autowired
    public void setCourse(Course course) {
        System.out.println("\n");
        System.out.println("eastern setcourse");
        System.out.println("\n");
        this.course = course;
    }
}
