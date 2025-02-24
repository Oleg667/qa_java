package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatTest {

    private Cat cat;
    private Feline felineMock; // ✅ Должен быть именно Feline

    @BeforeEach
    void setUp() {
        // Создаем мок-объект для Feline (он реализует Predator)
        felineMock = mock(Feline.class);
        // Передаем мок в конструктор Cat
        cat = new Cat(felineMock);
    }

    @Test
    void testGetSound() {
        // Проверяем, что кот издает "Мяу"
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        // Проверяем, что getFood() вызывает eatMeat() у mock-предатора
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, cat.getFood());
        verify(felineMock, times(1)).eatMeat();
    }
}
