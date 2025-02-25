package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CatParameterizedTest {

    private final Cat cat = new Cat(new Feline());

    @ParameterizedTest
    @ValueSource(strings = {"Мяу", "МЯУ", "мяу"})
    void testCatSoundWithDifferentCases(String sound) {
        // Проверяем, что кот всегда говорит "Мяу"
        assertEquals("Мяу", cat.getSound());
    }
}
