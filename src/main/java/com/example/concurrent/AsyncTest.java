package com.example.concurrent;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wangyihao
 * @ClassName: AsyncTest
 * @Description:
 * @date 2021/8/11 17:11
 */
@Component
public class AsyncTest {

    @Async
    public void test(){
        System.out.println("------");
    }

}
