package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    // Добавлено поле `predator` типа `Predator`, чтобы инъектировать зависимость вместо жесткой привязки к `Feline`
    private final Predator predator;

    // Конструктор теперь принимает `Predator` в качестве аргумента, что позволяет передавать любую реализацию `Predator`
    public Lion(String sex, Predator predator) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
        // Сохраняем переданную зависимость `Predator`, позволяя использовать разные реализации
        this.predator = predator;
    }

    public int getKittens() {
        // Добавлена проверка, является ли `predator` экземпляром `Feline`, чтобы вызывать `getKittens()`
        if (predator instanceof Feline) {
            return ((Feline) predator).getKittens();
        }
        return 0;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        // Теперь метод `getFood()` вызывает `eatMeat()` через интерфейс `Predator`, а не напрямую через `Feline`
        return predator.eatMeat();
    }
}
