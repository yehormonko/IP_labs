package labs;

public class Lab4 {
    public void task1() {
        String ua_letters = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя,._";
        char[][] table = new char[4][8];
        char[] key = "моньк".toCharArray();
        for (int i = key.length - 1; i >= 0; i--) {
            ua_letters = ua_letters.replace(key[i], '!');
            ua_letters = key[i] + ua_letters;
        }
        ua_letters = ua_letters.replace("!", "");
        int pos = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = ua_letters.charAt(pos);
                pos++;
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        String text = "нехайвтвоїмсерцілюбовінезгаснесвященийвогоньякпершепромовленесловонамовінародусвого";
        if (text.length() % 2 != 0) text = text + "х";
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            char f = text.charAt(i);
            int[] pos1 = getPos(f, table, 4, 8);
            char res1;
            if (pos1[0] + 1 > 3) res1 = table[0][pos1[1]];
            else res1 = table[pos1[0] + 1][pos1[1]];
            res = res + res1;
        }
        System.out.println(res);
    }

    public void task2() {
        String ua_letters = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя,._";
        char[][] table = new char[][]{
                {'з','ч','к','ь','н','м'},
                {'д','т','е','с','и','і'},
                {'о','л','у','б','ї','г'},
                {'я','.','ґ',',','щ','_'},
                {'ю','х','ж','ц','ш','п'},
                {'р','й','в','ф','а','є'},
        };
        String text = "нехайвтвоїмсерцілюбовінезгаснесвященийвогоньякпершепромовленесловонамовінародусвого";
        if (text.length() % 2 != 0) text = text + "х";
        String res = "";
        for (int i = 0; i < text.length(); i = i + 2) {
            char f = text.charAt(i);
            char s = text.charAt(i + 1);
            int[] pos1 = getPos(f, table, 6, 6);
            int[] pos2 = getPos(s, table, 6, 6);
            char res1;
            char res2;
            if (pos1[0] == pos2[0]) {
                if (pos1[1] + 1 > 5) res1 = table[pos1[0]][0];
                else res1 = table[pos1[0]][pos1[1] + 1];
                if (pos2[1] + 1 > 5) res2 = table[pos2[0]][0];
                else res2 = table[pos2[0]][pos2[1] + 1];
            } else if (pos1[1] == pos2[1]) {
                if (pos1[0] + 1 > 5) res1 = table[0][pos1[1]];
                else res1 = table[pos1[0] + 1][pos1[1]];
                if (pos2[0] + 1 > 5) res2 = table[0][pos2[1]];
                else res2 = table[pos2[0] + 1][pos2[1]];
            } else {
                res1 = table[pos2[0]][pos1[1]];
                res2 = table[pos1[0]][pos2[1]];
            }
            res = res + res1 + res2;
        }
        System.out.println(res);
    }
    public void task3(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //26 length
        //determinant = 5, OK 5 and 26
        int[][] t1 = {{5, 3},
                      {5, 4}};
        //determinant = 8, NOT OK
        int[][] t2 = {{7, 3},
                      {2, 2}};
        String text = "UNIVERSITY";
        int[] codes = new int[text.length()];
        char[] alphabet_arr = alphabet.toCharArray();
        for (int i = 0; i < text.length(); i++){
            int pos = -1;
            for (int j = 0; j <alphabet_arr.length; j++){
                if(text.charAt(i)==alphabet_arr[j]) pos = j;
            }
            codes[i] = pos;
        }
        String res  = "";
        for (int i = 0; i <text.length(); i=i+2){
            System.out.println(codes[i]+" "+codes[i+1]);
            int res_code1 = codes[i]*t1[0][0]+codes[i+1]*t1[0][1];
            if(res_code1>=26) res_code1 = res_code1%alphabet.length();
            int res_code2 = codes[i]*t1[1][0]+codes[i+1]*t1[1][1];
            if(res_code2>=26) res_code2 = res_code2%alphabet.length();
            res=res+alphabet_arr[res_code1]+alphabet_arr[res_code2];
        }
        System.out.println(res);
    }
    public int[] getPos(char c, char[][] table, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (table[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public void task4() {
        String ua_letters = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя,._";
        char[][] table = new char[4][8];
        char[] key = "моньк".toCharArray();
        for (int i = key.length - 1; i >= 0; i--) {
            ua_letters = ua_letters.replace(key[i], '!');
            ua_letters = key[i] + ua_letters;
        }
        ua_letters = ua_letters.replace("!", "");
        int pos = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = ua_letters.charAt(pos);
                pos++;
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        String text = "нехайвтвоїмсерцілюбовінезгаснесвященийвогоньякпершепромовленесловонамовінародусвого";
        if (text.length() % 2 != 0) text = text + "х";
        String res = "";
        for (int i = 0; i < text.length(); i = i + 2) {
            char f = text.charAt(i);
            char s = text.charAt(i + 1);
            int[] pos1 = getPos(f, table, 4, 8);
            int[] pos2 = getPos(s, table, 4, 8);
            char res1;
            char res2;
            if (pos1[0] == pos2[0]) {
                if (pos1[1] + 1 > 7) res1 = table[pos1[0]][0];
                else res1 = table[pos1[0]][pos1[1] + 1];
                if (pos2[1] + 1 > 7) res2 = table[pos2[0]][0];
                else res2 = table[pos2[0]][pos2[1] + 1];
            } else if (pos1[1] == pos2[1]) {
                if (pos1[0] + 1 > 3) res1 = table[0][pos1[1]];
                else res1 = table[pos1[0] + 1][pos1[1]];
                if (pos2[0] + 1 > 3) res2 = table[0][pos2[1]];
                else res2 = table[pos2[0] + 1][pos2[1]];
            } else {
                res1 = table[pos2[0]][pos1[1]];
                res2 = table[pos1[0]][pos2[1]];
            }
            res = res + res1 + res2;
        }
        System.out.println(res);
    }
}
