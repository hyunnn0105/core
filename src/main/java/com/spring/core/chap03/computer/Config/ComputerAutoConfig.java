package com.spring.core.chap03.computer.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// ??? 루트에 오류 있었던듯
// 구현하고 싶은 구현체에 빈 등록 @Component
//
@ComponentScan(basePackages = "com.spring.core.chap03.computer")
public class ComputerAutoConfig {

}
