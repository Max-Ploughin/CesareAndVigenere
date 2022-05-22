package com.MaxProjects;

import java.util.Arrays;
import java.util.List;


public class Vigenere {
    // массив - алфавит.
    // alphabet array.
    private static String alphabet[] = EnglishAlphabet.alphabet;

    // конвертируем массив в List.
    // converting array to List.
    private final static List<String> convertedAlphabet = Arrays.asList(alphabet);

    // создаем таблицу символов для кода Виженера.
    // creating Vigenere table.
    private static String[][] tableForVigenere = new String[alphabet.length][alphabet.length];


    // метод для заполнения таблицы Виженера.
    // method for adding values in Vigenere's table.
    private static String[][] generateVigenereAlphabet(String[][] tableForVigenere, String[] alphabet){
        int step = 0;

        for (int i=0; i < (tableForVigenere.length); i++){
            for (int j=0; j < (tableForVigenere[i].length); j++){
                tableForVigenere[i][j] = alphabet[(j + step) % alphabet.length];
            }
            step++;
        }
        return tableForVigenere;
    }

    // кодирование слова.
    // encrypting.
    public static String toVigenere (String word, String codeWord){
        // параметры - слово, которое необходимо зашивровать и секретное слово.
        // parameters = the word which we are going to encrypt and the secret word.
        String[][] tableForVigenere = generateVigenereAlphabet(Vigenere.tableForVigenere, alphabet);

        // создаем пустой массив, куда будем помещать закодированые буквы.
        // an empty array for adding encrypted letters.
        char[] codedWord = new char[word.length()];
        // создаем счетчик для слова-ключа, чтобы не выходить за рамки длины слова.
        // counter for the secret word to avoid exception.
        int countCode = -1;
        // циклом проходимся по слову.
        // loop for the word.
        for (int i = 0; i < word.length();i++){
            // сохраняем букву слова.
            // saving letter.
            char letter = word.charAt(i);
            countCode++;
            // проверяем не превышает ли счетчик кодового слова количество его индексов.
            // we have to check our countCode and start from the first letter of secret word if the counter bigger than
            // the size of secret word.
            if (countCode == codeWord.length()){
                // если да, то обнуляем счетчик.
                countCode = 0;
            }
            // сохраняем букву кодового слова.
            // save letter of secret word.
            char letterCode = codeWord.charAt(countCode);
            // получаем индексы букв из алфавита.
            // get indexies from the alphabet.
            int indexFirst = convertedAlphabet.indexOf(Character.toString(letter));
            int indexSecond = convertedAlphabet.indexOf(Character.toString(letterCode));
            // по индексам получаем нужную букву из двумерного массива.
            // geting letter by indexies.
            codedWord[i] = tableForVigenere[indexFirst][indexSecond].charAt(0);
        }
        String result = String.valueOf(codedWord);

        return result;

    }

    // расшифровка Виженера.
    // decrypting Vigenere code.
    public static String fromCodeVigenere (String codedWord, String codeWord) {
        String[][] tableForVigenere = generateVigenereAlphabet(Vigenere.tableForVigenere, alphabet);

        // создаем пустой массив, куда будем помещать закодированые буквы.
        // an empty array for adding encrypted letters.
        char[] deCodedWord = new char[codedWord.length()];
        // создаем счетчик для слова-ключа, чтобы не выходить за рамки длины слова.
        // counter for the secret word to avoid exception.
        int countCode = -1;
        // задаем переменную-позицию для массива раскодированных букв.
        // position for array of decoded letters.
        int position = 0;

        for (int i = 0; i < codedWord.length();i++){
            // сохраняем букву закодированного слова.
            // save letter of coded word.
            char letter = codedWord.charAt(i);
            countCode++;
            // проверяем не превышает ли счетчик кодового слова количество его индексов.
            // we have to check our countCode and start from the first letter of secret word if the counter bigger than
            // the size of secret word.
            if (countCode == codeWord.length()){
                // если да, то обнуляем счетчик.
                countCode = 0;
            }
            // сохраняем букву кодового слова.
            // save letter of secret word.
            char letterCode = codeWord.charAt(countCode);
            // получаем индекс буквы кодового слова из алфавита.
            // get index from the alphabet.
            int indexFirst = convertedAlphabet.indexOf(Character.toString(letterCode));

            // ищем столбец по букве кодового слова и в нем находим строчку с закодированным символом
            // далее определяем номер позиции найденного символа и по этому номеру позиции берем символ из алфавита.
            // using the letter of secret word we find the right column and the row of encoded character. Then, we take
            // the position of the symbol and take the letter from the alphabet by index.
            for (int j = 0; j < tableForVigenere[indexFirst].length; j++){
                if (tableForVigenere[indexFirst][j].equals(Character.toString(letter))){
                    deCodedWord[position] = alphabet[j].charAt(0);
                    position++;
                }
            }

        }
        String result = String.valueOf(deCodedWord);

        return result;

    }












}
