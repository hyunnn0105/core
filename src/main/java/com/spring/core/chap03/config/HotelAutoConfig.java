package com.spring.core.chap03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// chap03 패키지 안에 있는 @Component가 붙은 클래스들을 자동으로 빈으로 등록한다
@Configuration
@ComponentScan(basePackages = "com.spring.core.chap03")
public class HotelAutoConfig {

}
