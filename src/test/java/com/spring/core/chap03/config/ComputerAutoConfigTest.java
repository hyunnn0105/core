package com.spring.core.chap03.config;

import com.spring.core.chap03.computer.Computer;
import com.spring.core.chap03.computer.Config.ComputerAutoConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerAutoConfigTest {
    @Test
    @DisplayName("component 애너테이션이 붙은 빈들이 등록되어야한다")
    void CheckBeans() {

        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(ComputerAutoConfig.class);

        Computer com = ac.getBean(Computer.class);
        com.showSpec();
    }
}
