package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FelineTest {

    private Feline feline;

    @BeforeEach
    void setUp() {
        // Создаем объект Feline перед каждым тестом
        feline = Mockito.spy(new Feline());
    }

    @Test
    void testGetFood() throws Exception {
        // Проверяем, что Feline.getFood("Хищник") возвращает список еды
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.getFood("Хищник"));
    }

    @Test
    void testGetFamily() {
        // Проверяем, что Feline.getFamily() возвращает "Кошачьи"
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testEatMeat() throws Exception {
        // Проверяем, что Feline.eatMeat() вызывает getFood("Хищник")
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        doReturn(expectedFood).when(feline).getFood("Хищник");
        assertEquals(expectedFood, feline.eatMeat());
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    void testGetKittensDefault() {
        // Проверяем, что getKittens() без аргументов возвращает 1
        assertEquals(1, feline.getKittens(), "getKittens() должен возвращать 1");
    }
}
