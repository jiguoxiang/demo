package com.ji.demo.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoPropertiesTest {
    @Resource
    private DemoProperties properties;

    @Test
    public void testProperties() {
        assertEquals("JavaSpringBoot", properties.getClassName());
        assertEquals("description", properties.getDescription());
    }
}