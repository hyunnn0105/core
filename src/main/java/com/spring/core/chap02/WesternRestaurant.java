
package com.spring.core.chap02;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class WesternRestaurant implements Restaurant {
    // 변경이 자주 일어난다는 가정하에 설정
    private Chef chef;
    private Course course;

    // 생성자 초기화
    public WesternRestaurant(Chef chef, Course course) {
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
