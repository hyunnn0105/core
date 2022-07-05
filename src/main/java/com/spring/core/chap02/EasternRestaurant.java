package com.spring.core.chap02;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 기본생성자
@NoArgsConstructor
@Setter @Getter
public class EasternRestaurant implements Restaurant {

    // 역할에 의존하기 - 쉐프면 노상관
    private Chef chef;
    //암튼 코스 요리가 있다
    private Course course;

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



}
