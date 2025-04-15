package com.javainterviewpreparation.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest()
class RtStringTest {

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    @Description("""
              reverseTheString
              Time Complexity: O(n)
              Space Complexity: O(n)
            """)
    void reverseTheString() {

        String str = "123456789";
        int length = str.length();
        length -= 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        System.out.println("stringBuilder = " + stringBuilder);
        Assertions.assertThat(stringBuilder.toString()).isEqualTo("987654321");
    }

    @Test
    @Description("""
              reverseTheString V2
              Time Complexity: O(n)
              Space Complexity: O(n)
            """)
    void reverseTheStringV2() {
        String str = "123456789";
        StringBuilder stringBuilder = new StringBuilder(str).reverse();

        System.out.println("stringBuilder = " + stringBuilder);
        Assertions.assertThat(stringBuilder.toString()).isEqualTo("987654321");
    }

    @Test
    @Description("""
              reverseTheString V3
            """)
    void reverseTheStringV3() {
        String str = "123456789";
        Stack<Character> chars = new Stack<>();

        for (char c : str.toCharArray()) {
            chars.push(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!chars.isEmpty()) {
            Character pop = chars.pop();
            stringBuilder.append(pop);
        }

        System.out.println("stringBuilder = " + stringBuilder);
        Assertions.assertThat(stringBuilder.toString()).isEqualTo("987654321");
    }

    @Test
    @Description("""
              reverseTheString V4
            """)
    void reverseTheStringV4() {
        String str = "123456789";
        String reversed = str.chars()
                .mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        System.out.println("reversed = " + reversed);
        Assertions.assertThat(reversed).isEqualTo("987654321");
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    @Description("palindromeString")
    void palindromeString() {

        //String str = "madam";
        String str = "123454321";
        str = str.toLowerCase();
        int length = str.length();
        Assertions.assertThat(length % 2).isEqualTo(1);

        length -= 1;
        boolean result = true;
        for (int i = 0, j = length; i < length / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                result = false;
                break;
            }
        }

        Assertions.assertThat(result).isTrue();
    }

    @Test
    @Description("palindromeStringV2")
    void palindromeStringV2() {
        String str = "123454321"; // Sample input
        str = str.toLowerCase();

        boolean isPalindrome = str.contentEquals(new StringBuilder(str).reverse());
        Assertions.assertThat(isPalindrome).isTrue();
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    @Description("numberOfNumericalInString")
    void numberOfNumericalInString() {

        String str = "abcd12345dgtr";
        long counter = 0;
        int asciiCode = 0;
        for (int i = 0; i < str.length(); i++) {
            asciiCode = str.charAt(i);
            if (asciiCode >= 48 && asciiCode <= 57) {
                counter++;
            }
        }
        System.out.println("counter = " + counter);
        Assertions.assertThat(counter).isEqualTo(5);
    }


    @Test
    @Description("numberOfNumericalInStringV2")
    void numberOfNumericalInStringV2() {
        String str = "abcd12345dgtr";

        long digitCount = str.chars()
                .filter(Character::isDigit)
                .count();

        System.out.println("digitCount = " + digitCount);
        Assertions.assertThat(digitCount).isEqualTo(5);
    }

    @Test
    @Description("numberOfNumericalInStringV3")
    void numberOfNumericalInStringV3() {
        String str = "abcd12345dgtr";
        int count = 0;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        Assertions.assertThat(count).isEqualTo(5);
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    @Description("countForOccurrenceParticularCharacterInString")
    void countForOccurrenceParticularCharacterInString() {

        String str = "AkdfhkdhfAsldkjflsdjflAkdjfhlkAAAAA";
        char targetCharacter = 'A';

        long count = str.chars().filter(operand -> targetCharacter == operand).count();
        System.out.println("count = " + count);
        Assertions.assertThat(count).isEqualTo(8);
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    @Description("anagramStrings")
    void anagramStrings() {

        String str1 = "heart";
        String str2 = "earth";

        Assertions.assertThat(str1.length()).isEqualTo(str2.length());

        char[] charArray1 = str1.toLowerCase().toCharArray();
        char[] charArray2 = str2.toLowerCase().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        Assertions.assertThat(charArray1).isEqualTo(charArray2);
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    void numberOfVowelsAndConsonantsInString() {
        String str = "Alireza";
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        String lowerCase = str.toLowerCase();

        AtomicInteger vowelsCounter = new AtomicInteger();
        AtomicInteger consonantsCounter = new AtomicInteger();
        lowerCase.chars().forEach(operand -> {
            char charRepresent = (char) operand;
            if (vowels.contains(charRepresent)) {
                vowelsCounter.getAndIncrement();
            } else if (Character.isLetter(charRepresent)) {
                consonantsCounter.getAndIncrement();
            }
        });

        System.out.println("vowelsCounter = " + vowelsCounter);
        System.out.println("consonantsCounter = " + consonantsCounter);

        Assertions.assertThat(vowelsCounter.get()).isEqualTo(4);
        Assertions.assertThat(consonantsCounter.get()).isEqualTo(3);

    }


    @Test
    @Description("""
               numberOfVowelsAndConsonantsInStringV2
            Difference: A Set generally provides faster look-up times for contains checks compared to a List.
            This is because checking membership in a Set typically has O(1) complexity, while it has O(n) in a List.
            """)
    void numberOfVowelsAndConsonantsInStringV2() {
        String str = "Alireza";
        String lowerCase = str.toLowerCase();

        // Set of vowels for faster lookup
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        AtomicInteger vowelsCounter = new AtomicInteger();
        AtomicInteger consonantsCounter = new AtomicInteger();

        lowerCase.chars()
                .mapToObj(c -> (char) c) // Convert int to Character
                .forEach(ch -> {
                    if (vowels.contains(ch)) {
                        vowelsCounter.getAndIncrement(); // Increment the vowel counter
                    } else if (Character.isLetter(ch)) {
                        consonantsCounter.getAndIncrement(); // Increment the consonant counter
                    }
                });

        System.out.println("vowelsCounter = " + vowelsCounter.get());
        System.out.println("consonantsCounter = " + consonantsCounter.get());

        Assertions.assertThat(vowelsCounter.get()).isEqualTo(4);
        Assertions.assertThat(consonantsCounter.get()).isEqualTo(3);

    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    void reverseAnArray() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        System.out.println("arrayList = " + arrayList);
        Collections.reverse(arrayList);
        System.out.println("reversed = " + arrayList);

    }

    @Test
    void reverseAnArrayV2() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            arrayList.add(array[i]);
        }
        System.out.println("arrayList = " + arrayList);
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    void maximumElementInArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        Optional<Integer> max = arrayList.stream().max(Integer::compare);
        max.ifPresent(integer -> System.out.println("integer = " + integer));

    }

    @Test
    void maximumElementInArrayV2() {
        int[] intArray = {3, 1, 4, 1, 5, 9};
        int maxElement = intArray[0];
        for (int num : intArray) {
            if (num > maxElement) {
                maxElement = num;
            }
        }
        Assertions.assertThat(maxElement).isEqualTo(9);
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test
    void arrayOfIntegersInAscendingOrder() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        arrayList.sort((o1, o2) -> o2 - o1);
        System.out.println("arrayList = " + arrayList);
    }

    @Test
    void arrayOfIntegersInAscendingOrderV2() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        List<Integer> collect = arrayList.stream().sorted((o1, o2) -> o2 - o1).toList();
        System.out.println("collect = " + collect);

    }

    @Test
    void averageOfNumbersInList() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        OptionalDouble average = arrayList.stream().mapToInt(Integer::intValue).average();
        average.ifPresent(value -> System.out.println("value = " + value));
    }


    @Test
    void middleElementOfLinkedList() {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);

        Stack<Integer> stack = new Stack<>();
        stack.addAll(linkedList);
        int size = stack.size();
        System.out.println("size = " + size);

        // size >> 1 == size / 2
        Integer integer = linkedList.get(size >> 1);
        System.out.println("integer = " + integer);

    }


    @Test
    void mergeTwoSortedLinkedLists() {

        LinkedList<Integer> firstList = new LinkedList<>();
        firstList.add(1);
        firstList.add(3);
        firstList.add(5);
        firstList.add(7);
        firstList.add(9);

        LinkedList<Integer> secondList = new LinkedList<>();
        secondList.add(2);
        secondList.add(4);
        secondList.add(6);
        secondList.add(8);

        System.out.println("firstList = " + firstList);
        System.out.println("secondList = " + secondList);


        ListIterator<Integer> firstIterator = firstList.listIterator();
        ListIterator<Integer> secondIterator = secondList.listIterator();

        LinkedList<Object> mergedList = new LinkedList<>();


        Integer firstNext = firstIterator.hasNext() ? firstIterator.next() : null;
        Integer secondNext = secondIterator.hasNext() ? secondIterator.next() : null;

        while (firstNext != null || secondNext != null) {
            if (firstNext != null && (secondNext == null || firstNext <= secondNext)) {
                mergedList.add(firstNext);
                firstNext = firstIterator.hasNext() ? firstIterator.next() : null;
            } else {
                mergedList.add(secondNext);
                secondNext = secondIterator.hasNext() ? secondIterator.next() : null;
            }
        }
        System.out.println("mergedList = " + mergedList);
    }


    @Test
    void name() {
        int[] addresses = {1, 2, 3, 2, 1, 5, 3, 1, 2, 1, 4, 5, 6};

        // Create a HashSet using Arrays.stream
        Set<Integer> addressSet = new HashSet<>(Arrays.stream(addresses) // Create a stream from the array
                .boxed() // Convert each int to Integer
                .toList()); // Collect as a List

        // Convert HashSet to an Integer array
        Integer[] addressArray = addressSet.toArray(new Integer[0]);

        // Print the Integer array
        System.out.println(Arrays.toString(addressArray));

        // If you need a primitive int array instead of Integer array
        int[] primitiveArray = Arrays.stream(addressArray)
                .mapToInt(Integer::intValue)
                .toArray();

        // Print the primitive int array
        System.out.println(Arrays.toString(primitiveArray));


    }


    //------------------------------------------------------------------------------------------------------------------
    // Sort a String: Perfect
    //------------------------------------------------------------------------------------------------------------------
//    String sortCharacters(String input) {
//        char[] chars = input.toCharArray();
//        Arrays.sort(chars);
//        return new String(chars);
//    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

}