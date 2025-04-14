package com.javainterviewpreparation.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

@SpringBootTest()
class EffectiveJavaItem45Test {

    Stream<String> stringStream = Stream.of("Listen", "Silent",
            "Triangle", "Integral",
            "Stop", "Tops",
            "Evil", "Live",
            "Rat", "Tar",
            "Bare", "Bear",
            "Save", "Vase",
            "Note", "Tone",
            "Stressed", "Desserts",
            "Cider", "Cried",
            "Heart", "Earth",
            "Cheat", "Teach",
            "Save", "Vase",
            "Looped", "Poodle");

    String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    void printFormattedGroups(Map<String, Set<String>> groups) {
        groups.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
            System.out.println();
        });
    }

    @Test
    public void firstSolution() {
        HashMap<String, Set<String>> groups = new HashMap<>();
        stringStream.forEach(word ->
                groups.computeIfAbsent(sortString(word.toLowerCase()), k -> new HashSet<>())
                        .add(word));
        printFormattedGroups(groups);
        Assertions.assertThat(groups.size()).isEqualTo(13);
    }

    @Test
    public void lastSolutionHasIssue() {
        HashMap<String, Set<String>> groups = new HashMap<>();
        stringStream.collect(Collectors.groupingBy(word -> sortString(word.toLowerCase()))).values().forEach(g -> System.out.println(g.size() + ": " + g));
        printFormattedGroups(groups);
        Assertions.assertThat(groups.size()).isEqualTo(0);
    }

    @Test
    public void fixLastSolution() {
        Map<String, Set<String>> groups = stringStream
                .collect(Collectors.groupingBy(
                        word -> sortString(word.toLowerCase()),
                        Collectors.toSet()
                ));
        printFormattedGroups(groups);
        Assertions.assertThat(groups.size()).isEqualTo(13);
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    @Description("""
                A Mersenne prime is a prime number of the form M_p = 2^p - 1, where p is also a prime number. The first few Mersenne primes are:
                For p = 2:
                M_2 = 2^2 - 1 = 3
            
                For p = 3:
                M_3 = 2^3 - 1 = 7
            
                For p = 5:
                M_5 = 2^5 - 1 = 31
            
                For p = 7:
                M_7 = 2^7 - 1 = 127        
            """)
    void name() {
        Stream.iterate(TWO, BigInteger::nextProbablePrime)
                .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

}