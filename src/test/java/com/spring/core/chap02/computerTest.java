package com.spring.core.chap02;

import com.spring.core.chap02.computer.Computer;
import com.spring.core.chap02.computer.Config.ComputerConfig;
import com.spring.core.chap02.computer.Monitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class computerTest {

    // (등록된 설정파일)에서 가져와라
    AnnotationConfigApplicationContext ac 
            = new AnnotationConfigApplicationContext(ComputerConfig.class);

    // 싱글톤 패턴 구현하기
    @Test
    @DisplayName("설정파일에 등록한 computer빈을 가져와야한다")
    void findComputerBeanTest(){
        Computer computer = ac.getBean(Computer.class);
        computer.showSpec();
    }

    @Test
    @DisplayName("컨테이너에서 조회한 빈은 단 하나의 객체여야한다")
    void singleton(){
        Monitor m1 = ac.getBean(Monitor.class);
        Monitor m2 = ac.getBean(Monitor.class);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);

        assertEquals(m1, m2);
        //singleton -> day12 static에 싱글톤
    }
}
