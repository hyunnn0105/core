package com.spring.core.chap03.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Computer {

    private final Keyboard keyboard;
    private final Mouse mouse;
    private final Monitor monitor;

    @Autowired
    // 여러개 등록시 @Quli~~ 로 이름 넣어주기
    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    //컴퓨터 부품의 전체정보를 보여주는 메서드
    public void showSpec() {
        System.out.println("\n======= 컴퓨터 정보 =======");
        monitor.info();
        mouse.info();
        keyboard.info();
    }
}
