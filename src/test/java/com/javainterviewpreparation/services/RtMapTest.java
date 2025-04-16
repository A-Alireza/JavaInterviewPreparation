package com.javainterviewpreparation.services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest()
class RtMapTest {

    @Test
    public void temp() {
        Map<Integer, String> NashMap = Map.of(1,"a", 2,"b", 3,"c");
    }

}