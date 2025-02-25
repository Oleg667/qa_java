package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Feline feline; // Используем Feline напрямую

    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.feline = feline;
    }

    public int getKittens() {
        return feline.getKittens(); // Работает с переданным Feline
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat(); // Теперь напрямую вызываем у Feline
    }
}
