package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

class LionTest {

    private Feline felineMock;

    @BeforeEach
    void setUp() {
        felineMock = mock(Feline.class);
    }

    @Test
    void testLionHasManeForMale() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane(), "У самца должна быть грива");
    }

    @Test
    void testLionNoManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane(), "У самки не должно быть гривы");
    }

    @Test
    void testLionThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другое", felineMock));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens(), "Метод getKittens() должен возвращать значение из Feline");
    }

    @Test
    void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expectedFood, lion.getFood(), "Метод getFood() должен возвращать рацион из Feline");
    }
}
