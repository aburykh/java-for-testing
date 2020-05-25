package ru.geekbrains.java.for_testing.lesson4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArgIsNotEmptyArrayTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 6, 5, 4, 2, 3, 3}, new int[]{2, 3, 3}},
                {new int[]{4, 3, 7, 5, 4, 4, 3, 2}, new int[]{3, 2}}
        });
    }

    private int[] in;
    private int[] out;

    public ArgIsNotEmptyArrayTest(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }


    @Test
    public void testElementsAfterLastFour() {
        Assert.assertArrayEquals(out, T1ArgIsNotEmptyArray.ElementsAfterLastFour(in));
    }

    @Test(expected = RuntimeException.class)
    public void testElementsAfterLastFour2() {
        T1ArgIsNotEmptyArray.ElementsAfterLastFour(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }

}