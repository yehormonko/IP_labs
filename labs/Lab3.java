package labs;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab3 {
    public void task1() {
        String text = "HEWASSOPLEASEDTHATHEHADTHREERUBLESALLOFHISOWNANDTHENONCEAGAINHEPUTHISHANDINHISPOCKETANDITWASEMPTY";
        int a = 5;
        int b = 6;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] text_array = text.toCharArray();
        char[] new_text = new char[text.length()];
        int i = 0;
        for (char c : text_array) {
            int pos = alphabet.indexOf(c);
            pos = (a * pos + b) % alphabet.length();
            new_text[i] = alphabet.charAt(pos);
            i++;
        }
        String decoded = new String(new_text);
        System.out.println(decoded);
    }

    public void task2() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text = "HEWASSOPLEASEDTHATHEHADTHREERUBLESALLOFHISOWNANDTHENONCEAGAINHEPUTHISHANDINHISPOCKETANDITWASEMPTY";
        int key = 9;
        String keyText = "CULMINATE";
        alphabet = alphabet.substring(0, key) + keyText + alphabet.substring(key);
        char[] text_array = text.toCharArray();
        char[] new_text = new char[text.length()];
        int i = 0;
        for (char c : text_array) {
            int pos = alphabet.indexOf(c);
            pos = (pos + key) % alphabet.length();
            new_text[i] = alphabet.charAt(pos);
            i++;
        }
        String decoded = new String(new_text);
        System.out.println(decoded);
    }

    public void task3() {
        String text = "MYRLBELRBTDMAMBWDWEJVLJPCBMRABWLVTXPWMRYTRBZWQLEBBZWGZWWFAFLJMRBZWAZWV";
        String keyText = "MISFORTUNE";
        int key = 8;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Character> new_alphabet = new ArrayList<Character>(alphabet.length() + keyText.length());
        for (int i = 0; i < alphabet.length(); i++) {
            new_alphabet.add(' ');
        }
        int pos = key;
        for (char c : keyText.toCharArray()) {
            new_alphabet.add(pos, c);
            pos++;
        }
        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            if (pos >= alphabet.length()) pos = 0;
            boolean already = new_alphabet.contains(c);
            if (!already) {
                new_alphabet.set(pos, c);
                pos++;
            }
        }
        char[] text_array = text.toCharArray();
        char[] new_text = new char[text.length()];
        int i = 0;
        for (char c : text_array) {
            pos = new_alphabet.indexOf(c);
            if (pos < 0) pos = 25;
            new_text[i] = alphabet.charAt(pos);

            i++;
        }
        String decoded = new String(new_text);
        System.out.println(decoded);
    }

    public void task4() {
        String alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        String text = "короткаукраїнськаприказка";
        int key = 9;
        String keyText = "слово";
        alphabet = alphabet.substring(0, key) + keyText + alphabet.substring(key);
        char[] text_array = text.toCharArray();
        char[] new_text = new char[text.length()];
        int i = 0;
        for (char c : text_array) {
            int pos = alphabet.indexOf(c);
            pos = (pos + key) % alphabet.length();
            new_text[i] = alphabet.charAt(pos);
            i++;
        }
        String decoded = new String(new_text);
        System.out.println(decoded);
    }
}
