package com.javainterviewpreparation.services;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest()
class RtArrayListTest {

    @Test
    @Description("Different way to create an ArrayList.")
    public void createArrayList() {

        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        ArrayList<Integer> arrayList1 = new ArrayList<>(list1);
        System.out.println("arrayList1 = " + arrayList1);
        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------
        List<Integer> list2 = List.of(1, 2, 3);
        ArrayList<Integer> arrayList2 = new ArrayList<>(list2);
        System.out.println("arrayList2 = " + arrayList2);

        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------
        ArrayList<Object> arrayList3 = new ArrayList<>();
        arrayList3.add(1);
        arrayList3.add(2);
        arrayList3.add(3);
        System.out.println("arrayList3 = " + arrayList3);
        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------
        ArrayList<Integer> arrayList4 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println("arrayList4 = " + arrayList4);
        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------
        ArrayList<Integer> arrayList5 = Stream.of(1, 2, 3).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("arrayList5 = " + arrayList5);
        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------

    }

}