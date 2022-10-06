package io.str_counter.ua;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterCounterImplTest {

    private static CharacterCounter counter;

    @BeforeAll
    public static void init() {
        counter = new CharacterCounterImpl();
    }

    @Test
    public void testInvalidString() {
        assertThrows(NullPointerException.class, () -> counter.countCharacters(null));
        assertThrows(IllegalArgumentException.class, () -> counter.countCharacters(List.of()));

    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testCountChars(List<String> string, Map<String, Integer> expected) {
        assertEquals(expected, counter.countCharacters(string));
    }

    public static Stream<Arguments> testCases() {
        var inputList = List.of("What", " if you want", " to loop through the", " data in ", "an array");

        var map1 = new HashMap<>();
        map1.put("W", 1); map1.put("e", 1);
        map1.put("l", 1); map1.put("p", 1);
        map1.put("w", 1); map1.put("h", 4);
        map1.put("a", 7); map1.put("t", 6);
        map1.put("i", 2); map1.put("f", 1);
        map1.put("y", 2); map1.put("o", 5);
        map1.put("u", 2); map1.put("r", 3);
        map1.put("g", 1); map1.put("d", 1);
        map1.put("n", 3);


        return Stream.of(
                Arguments.of(inputList, map1)
        );
    }
}
