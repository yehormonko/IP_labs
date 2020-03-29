package labs;

import java.util.Arrays;

public class Lab1 {
    String ua_letters = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    String ua_letters_without_g = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя";
    int I = 7;
    int J = 5;

    public void task1() {
        String cryptoText = " сгьиіл о-тйор вьмво инаоб леєне есше цтп";
        cryptoText = cryptoText.replaceAll(" ", "");
        int pos = 0;
        char[][] table = new char[I][J];
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                if (pos > cryptoText.length() - 1) table[i][j] = ' ';
                else table[i][j] = cryptoText.charAt(pos);
                System.out.print(table[i][j] + " ");
                pos++;
            }
            System.out.println();
        }
        char[] result = new char[I * J];
        pos = 0;
        for (int j = 0; j < J; j++) {
            for (int i = 0; i < I; i++) {
                result[pos] = table[i][j];
                pos++;
            }
        }
        String encoded = new String(result);
        System.out.println(encoded);
    }

    public void task2() {
        String text = "ШАЛЕНІЮ ВІД НЕБА БЛАКИТНОГО, ВІД ЛАСКАВОГО ШЕПОТУ ТРАВ";
        String key = "СУМИ";
        char[] chars = key.toCharArray();
        char[] sortedChars = Arrays.copyOf(chars, chars.length);
        Arrays.sort(sortedChars);
        int[] numbers = new int[sortedChars.length];
        for (int i = 0; i < sortedChars.length; i++) {
            char c = chars[i];
            int index = Arrays.binarySearch(sortedChars, c);
            numbers[i] = index;
        }
        text = text.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "");
        int dif = text.length() % key.length();
        if (dif != 0) {
            for (int i = 0; i < (key.length() - dif); i++) {
                text += " ";
            }
        }
        String[] strings = text.split("(?<=\\G.{" + key.length() + "})");
        for (int j = 0; j < strings.length; j++) {
            String string = strings[j];
            char[] partArray = string.toCharArray();
            char[] parSortedArray = new char[partArray.length];
            for (int i = 0; i < numbers.length; i++) {
                if (i >= partArray.length) break;
                parSortedArray[i] = partArray[numbers[i]];
            }
            strings[j] = new String(parSortedArray);
        }
        String result = String.join("", strings);
        System.out.println(result);
    }

    public void task4() {
        String text = "ИНОШ ЖУМOЙУ ДТКЛХЯ МЗИ-О ДС!ОТЛ ОВАДИ ЯМЮ";
        //String text = "BGEARHTCOEKPETERHSWPEODEINAHDSDHTMEDEURLBESNIIHNODEHTB";
        text = text.replaceAll(" ", "");
        String key = "1462573_51324";
        //String key = "632541_193756482";
        int[] keyRow = key.split("_")[0].chars()
                .map(x -> x - '0')
                .toArray();
        int[] keyColumn = key.split("_")[1].chars()
                .map(x -> x - '0')
                .toArray();
        int I = keyColumn.length;
        int J = keyRow.length;
        char[][] chars = new char[I][J];
        int pos = 0;
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                chars[i][j] = text.charAt(pos);
                //System.out.print(chars[i][j] + " ");
                pos++;
            }
            System.out.println();
        }
        char[][] resMatrix = new char[I][J];
        //COLUMN SWAP
        //System.out.println("column swap");
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                resMatrix[i][j] = chars[i][keyRow[j] - 1];
                //System.out.print(resMatrix[i][j] + " ");
            }
            System.out.println();
        }
        char[][] resMatrix2 = new char[I][J];
        //ROW SWAP
        //System.out.println("row swap");
        for (int i = 0; i < I; i++) {
            resMatrix2[i] = resMatrix[keyColumn[i] - 1];
        }
        char[] encoded = new char[I * J];
        pos = 0;
        for (int j = 0; j < J; j++) {
            for (int i = 0; i < I; i++) {
                //System.out.print(resMatrix2[i][j] + " ");
                encoded[pos] = resMatrix2[i][j];
                pos++;
            }
            System.out.println();
        }
        System.out.println(new String(encoded));


    }

}
