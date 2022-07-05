package com.spring.core.chap02;

import com.spring.core.chap02.config.HotelConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HotelXmlTest {
    
    // 스프링컨테이너 객체생성
    GenericXmlApplicationContext ac
            = new GenericXmlApplicationContext("HotelConfig.xml");

    @Test
    @DisplayName("xml 설정파일에 등록된 빈들을 조회해야 한다.")
    void findBeanTeat(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();

    }

}
