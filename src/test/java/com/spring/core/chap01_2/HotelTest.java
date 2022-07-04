package com.spring.core.chap01_2;

import com.spring.core.chap01_2.JuanChef;
import com.spring.core.chap01_2.config.HotelManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HotelTest {
    @Test
    @DisplayName("실행되어야한다")
    void objectTest(){
//        Hotel hotel = new Hotel(new WesternRestaurant(new KimuraChef(), new SushiCourse()), new JuanChef());
        HotelManager hm = new HotelManager();
        Hotel hotel = hm.hotel();
        hotel.inform();


    }

}
