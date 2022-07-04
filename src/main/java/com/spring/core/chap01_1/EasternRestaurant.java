package com.spring.core.chap01_1;

public class EasternRestaurant implements Restaurant{

    // 역할에 의존하기 - 쉐프면 노상관
    private Chef chef;
    //암튼 코스 요리가 있다
    private Course course;


    public EasternRestaurant(){
        this.chef = new KimuraChef();
        this.course = new SushiCourse();
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
