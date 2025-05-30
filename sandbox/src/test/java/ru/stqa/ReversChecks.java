package ru.stqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReversChecks {
    @Test
    void testSqrt() {
        var input = 5;
        var result = Math.sqrt(input);
        var revers = result * result;
        Assertions.assertEquals(input, revers, 0.000001);
    }

    @Test
    void testSort() {
        var input = new ArrayList<>(List.of(3, 7, 4, 9, 0));
        input.sort(Integer::compareTo);
        for (int i = 0; i < input.size()-1; i++){
            Assertions.assertTrue(input.get(i) <= input.get(i+1));
        }
    }
}
