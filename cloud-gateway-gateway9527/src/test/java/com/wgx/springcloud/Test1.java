package com.wgx.springcloud;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * author:wgx
 * version:1.0
 */
public class Test1 {
    @Test
    public void test1() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
