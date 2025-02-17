package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    private Predator predatorMock;
    private Feline felineMock;

    @BeforeEach
    void setUp() {
        // Создаем мок-объект для Predator, чтобы изолировать тестирование класса Lion
        predatorMock = mock(Predator.class);
        felineMock = mock(Feline.class);

    }

    @Test
    void testLionHasManeForMale() throws Exception { // Добавляем throws Exception
        Lion lion = new Lion("Самец", predatorMock);
        assertTrue(lion.doesHaveMane(), "У самца должна быть грива");
    }

    @Test
    void testLionNoManeForFemale() throws Exception { // Добавляем throws Exception
        Lion lion = new Lion("Самка", predatorMock);
        assertFalse(lion.doesHaveMane(), "У самки не должно быть гривы");
    }

    @Test
    void testLionThrowsExceptionForInvalidSex() {
        // Проверяем, что при неверном значении пола выбрасывается исключение
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другое", predatorMock));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    void testGetFood() throws Exception { // Добавляем throws Exception
        // Проверяем, что метод getFood вызывает eatMeat у mock-предатора
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(expectedFood, lion.getFood(), "Еда льва должна соответствовать мок-объекту");

        // Проверяем, что метод eatMeat был вызван один раз
        verify(predatorMock, times(1)).eatMeat();
    }

    @Test
    void testGetKittens() throws Exception { // Добавляем throws Exception
        // Проверяем, что если переданный Predator не является Feline, getKittens возвращает 0
        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(0, lion.getKittens(), "Если Predator не Feline, метод должен вернуть 0");
    }

    @Test
    void testGetKittens_WhenPredatorIsFeline() throws Exception {
        // Проверяем, что если predator — это Feline, метод getKittens() вызовется
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);

        assertEquals(3, lion.getKittens(), "Если predator — Feline, должен вернуться getKittens()");
    }

    @Test
    void testGetKittens_WhenPredatorIsNotFeline() throws Exception {
        // Проверяем, что если predator НЕ Feline, метод вернет 0
        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(0, lion.getKittens(), "Если predator не Feline, метод должен вернуть 0");
    }


}
