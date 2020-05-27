package ru.geekbrains.java.for_testing.lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Tests one more time")
public class ArrayCompositionTest {

    public static Stream<Arguments> dataArray() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true),
                Arguments.of(new int[]{9, 6, 7, 2, 7, 3, 5, 1}, false),
                Arguments.of(new int[]{1, 4, 8, 7, 7}, false),
                Arguments.of(new int[]{1, 1, 4, 1, 1}, true)
        );
    }

    @ParameterizedTest(name = "{index} ==> Input array: {0} --> Result: {1}")
    @MethodSource("dataArray")
    public void onlyOneAndFour(int[] in, boolean out) {
        assertEquals(T2ArrayComposition.CheckComposition(in), out);
    }

}