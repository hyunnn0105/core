package com.spring.core.chap02;

import com.spring.core.chap02.computer.Computer;
import com.spring.core.chap02.computer.Config.ComputerConfig;
import com.spring.core.chap02.computer.Monitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerWmlTest {
    @Test
    @DisplayName("자바 클래스 설정파일에 등록한 Computer 빈을 가져와야 한다.")
    void findBeanClassConfigTest() {

        ApplicationContext ac
                = new AnnotationConfigApplicationContext(ComputerConfig.class);

        Computer computer = ac.getBean(Computer.class);
        computer.showSpec();
    }

    @Test
    @DisplayName("컨테이너에서 조회한 빈은 단 하나의 객체여야 한다.")
    void singleton() {
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(ComputerConfig.class);

        Monitor m1 = ac.getBean(Monitor.class);
        Monitor m2 = ac.getBean(Monitor.class);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);

        assertEquals(m1, m2);
    }

    @Test
    @DisplayName("xml 설정파일에 등록한 Computer 빈을 가져와야 한다.")
    void findBeanXMLConfigTest() {

        ApplicationContext ac
                = new GenericXmlApplicationContext("ComputerConfig.xml");

        Computer computer = ac.getBean(Computer.class);
        computer.showSpec();

    }
}
