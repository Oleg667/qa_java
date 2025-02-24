package com.example;

public class Main {
    public static void main(String[] args) {
        try {
            Feline feline = new Feline();
            Cat cat = new Cat(feline);
            Lion lion = new Lion("Самец", feline); // Передаем Feline, реализующий Predator


            System.out.println("Кот говорит: " + cat.getSound());
            System.out.println("Еда кота: " + cat.getFood());
            System.out.println("Семейство льва: " + lion.getKittens());
            System.out.println("Есть ли у льва грива? " + lion.doesHaveMane());
            System.out.println("Еда льва: " + lion.getFood());

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
