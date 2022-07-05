package com.spring.core.chap02.computer.Config;

import com.spring.core.chap02.computer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    1. config 파일 생성
    2. @Configuration 선언하기
    3. 등록할 빈들 생성자? 설정하기
    4. @Bean 등록해주기
    
 */

@Configuration
public class ComputerConfig {
    @Bean
    public Mouse mouse(){
        return new AppleMouse();
    }
    @Bean
    public Keyboard keyboard(){
        return new HpKeyboard();
    }
    @Bean
    public Monitor monitor(){
        return new LgMonitor();
    }
    @Bean
    public Computer computer(){
        Computer cm = new Computer( keyboard(),mouse(),monitor());
        return cm;
    }


}
