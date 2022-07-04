package com.spring.core.chap01_1;

public class WesternRestaurant implements Restaurant {
    // 변경이 자주 일어난다는 가정하에 설정
    private Chef chef;
    private Course course;

    // 생성자 초기화
    public WesternRestaurant() {
        this.chef = new JuanChef();
        this.course = new FrendhCourse();
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
