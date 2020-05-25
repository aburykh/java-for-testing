package ru.geekbrains.java.for_testing.lesson4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayCompositionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true},
                {new int[]{9, 6, 7, 2, 7, 3, 5, 1}, false},
                {new int[]{1, 4, 8, 7, 7}, false},
                {new int[]{1, 1, 4, 1, 1}, true}
        });
    }
    private int[] in;
    private boolean out;

    public ArrayCompositionTest(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private T2ArrayComposition t2ArrayComposition;

    @BeforeAll
    public void startTest() {
        t2ArrayComposition = new T2ArrayComposition();
    }

    @Test
    public void onlyOneAndFour() {
        Assert.assertEquals(T2ArrayComposition.CheckComposition(in), out);
    }

}