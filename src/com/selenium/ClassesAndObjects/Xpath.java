package com.selenium.ClassesAndObjects;

/**
 // - искать везде
 / - искать на уровень ниже
 //book[@author='Tolstoy'] - найти книжку с аттрибутом author='Tolstoy'
 //book[2] - втора€ книга
 //*[@id='name'] - любой тег с id=name
 //pages[text()='999']    - tag pages у которго между тегами написано 999
 //pages[text()='999']/.. - на уровень выше
    //book/pages[text()='999']
  омбинацией данных функций можем получить:
 Ч не четные элементы ul/li[position() mod 2 = 1]
 Ч четные элементы: ul/li[position() mod 2 = 0]

 «апрос ul/li/div/p[last()] Ч возвратит последние параграфы дл€ каждого узла списка Ђulї

 ќперации сравнени€
 < Ч логическое Ђменьшеї
 > Ч логическое Ђбольшеї
 <= Ч логическое Ђменьше либо равної
 >= Ч логическое Ђбольше либо равної

 ul/li[position() > 2] , ul/li[position() <= 2] Ч элементы списка начина€ с 3го номера и наоборот.

 ≈сли в книге два name
 //book[count(name) = 2]

 —ледующий элемент
 //title[text()='hi']/following::shelf[1]

 */
public class Xpath {


    public static void main(String[] args) {

    }
}
