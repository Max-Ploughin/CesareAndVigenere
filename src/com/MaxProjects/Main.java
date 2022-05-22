package com.MaxProjects;

public class Main {

    public static void main(String[] args) {

        System.out.println(Cesare.toCesarCode("hello", 3));
        System.out.println(Cesare.fromCesareCode("khoor", 33));

        System.out.println(Vigenere.toVigenere("hello", "lem"));
        System.out.println(Vigenere.fromCodeVigenere("sixws", "lem"));

    }
}
