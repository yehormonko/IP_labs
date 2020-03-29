package labs;

import java.util.Arrays;

public class Lab2 {
    public void task1() {
        String text = "OFF WENT IGNAT, AND SOON HE FOUND THE THREE RUBLES, LYING UNDER A BURDOCK PLANT";
        String key = "OUTSIDER";
        char[] chars = key.toCharArray();
        char[] sortedChars = Arrays.copyOf(chars, chars.length);
        System.out.println(Arrays.toString(sortedChars));
        Arrays.sort(sortedChars);
        System.out.println(Arrays.toString(sortedChars));
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

    public void task2() {
        String text = "HE GRABBED THOSE THREE RUBLES AND HID THEM DEEP DOWN IN HIS POCKET";
        text = text.replaceAll(" ", "");
        String key = "632541_193756482";
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
                System.out.print(chars[i][j] + " ");
                pos++;
            }
            System.out.println();
        }
        char[][] resMatrix = new char[I][J];
        //ROW SWAP


        //COLUMN SWAP
        char[][] resMatrix2 = new char[I][J];
        System.out.println("column swap");
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                resMatrix[i][j] = chars[i][keyRow[j] - 1];
                System.out.print(resMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("row swap");
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                resMatrix2[i][j] = resMatrix[keyColumn[i]-1][j];
                System.out.print(resMatrix2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("__");
        char[] decoded = new char[I * J];
        pos = 0;
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                decoded[pos] = resMatrix2[i][j];
                pos++;
            }
        }
        System.out.println(new String(decoded));
    }
}
