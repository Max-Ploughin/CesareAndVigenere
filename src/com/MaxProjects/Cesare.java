package com.MaxProjects;

import java.util.Arrays;
import java.util.List;

public class Cesare {
    // массив - алфавит.
    // alphabet array.

    private static String alphabet[] = EnglishAlphabet.alphabet;
    // конвертируем массив в List.
    // converting array to List.
    private static List<String> convertedAlphabet = Arrays.asList(alphabet);

    // метод конвертации слова с помощью кода Цезаря.
    // encrypting word with Cesare code.
    public static String toCesarCode(String word, int key){
        // параметры - слово для шифра и шаг(сдвиг).
        // parameters - the word that you're going to encrypt and the step.

        // создаем пустой массив, куда будем помещать закодированые буквы.
        // empty array for encrypted letters.
        char[] replacedLetters = new char[word.length()];
        // цикл для прохода по слову.
        // loop for the word.
        for (int i = 0; i < word.length(); i++) {
            // берем первую букву слова и ищем ее индекс в нашем алфавите. после, прибавляем наш ключ и делим с
            // остатком на размер алфавита.
            // take the letter and find the index of this letter in our alphabet. then, add our key for the index
            // and devide it with excess on the length of alphabet.
            int index = ((convertedAlphabet.indexOf(Character.toString(word.charAt(i))) + key)) % alphabet.length;
            // помещаем новую букву, полученную по индексу в подготовленный массив.
            // adding letter that were finded by index in prepared array.
            replacedLetters[i] = convertedAlphabet.get(index).charAt(0);

        }
        // массив с буквами конвертируем в строку.
        // converting array with letters in String.
        String result = String.valueOf(replacedLetters);
        return result;
    }

    // расшифровка кода Цезаря.
    // decrypting Cesare code.
    public static String fromCesareCode (String codedWord, int key){

        // создаем пустой массив, куда будем помещать закодированые буквы.
        // creating empty array in which we will put decrypted letters.
        char[] decryptedLetters = new char[codedWord.length()];
        // цикл для прохода по слову.
        // loop for word.
        for (int i = 0; i < codedWord.length(); i++) {
            // берем первую букву слова и ищем ее индекс в нашем алфавите. после, прибавляем наш ключ и делим с
            // остатком на размер алфавита.
            // take the letter and find the index of this letter in our alphabet. then, add our key for the index
            // and devide it with excess on the length of alphabet.
            int index = ((convertedAlphabet.indexOf(Character.toString(codedWord.charAt(i))) - key)) % alphabet.length;
            // проверка на то, если у нас получилось отрицательное число, то нужно искать букву в конце алфавита.
            // checking if we got a negative value. if true, we have to add this value to our alphabet length.
            if (index < 0){
                index = alphabet.length + (index);
            }
            // помещаем новую букву, полученную по индексу в подготовленный массив.
            // adding letter that were finded by index in prepared array.
            decryptedLetters[i] = convertedAlphabet.get(index).charAt(0);

        }
        // массив с буквами конвертируем в строку.
        // converting array with letters in String.
        String result = String.valueOf(decryptedLetters);
        return result;
    }

}
