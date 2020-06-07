/**
package ru.geekbrains.java.for_testing.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


@DisplayName("Tests")
public class ArgIsNotEmptyArrayTest {


    private static Stream<Arguments> dataArray() {
        return Stream.of(
                Arguments.of(new int[]{1, 6, 5, 4, 2, 3, 3}, new int[]{2, 3, 3}),
                Arguments.of(new int[]{4, 3, 7, 5, 4, 4, 3, 2}, new int[]{3, 2}),
                Arguments.of(new int[]{1, 2, 4, 4, 7, 2, 5, 4}, new int[]{})
        );
    }


    @ParameterizedTest(name = "{index} ==> Input array: {0}, Output array: {1}")
    @MethodSource("dataArray")
    public void testElementsAfterLastFour(int[] in, int[] out) {
        assertArrayEquals(out, T1ArgIsNotEmptyArray.ElementsAfterLastFour(in));
    }

    @Test
    public void testElementsAfterLastFourException() throws RuntimeException {
        Assertions.assertThrows(RuntimeException.class, () -> {
            T1ArgIsNotEmptyArray.ElementsAfterLastFour(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
        });
    }

}
 */