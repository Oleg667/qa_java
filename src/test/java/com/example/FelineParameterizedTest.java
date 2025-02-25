package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineParameterizedTest {

    private final Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void testGetKittensWithVariousValues(int kittensCount) {
        // Проверяем, что Feline.getKittens(int) возвращает переданное значение
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
