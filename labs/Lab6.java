package labs;

public class Lab6 {
    public void task1(){
        char[][]table1 = new char[][]{
                {'з','ч','к','ь','н','м'},
                {'д','т','е','с','и','і'},
                {'о','л','у','б','ї','г'},
                {'я','.','ґ',',','щ','_'},
                {'ю','х','ж','ц','ш','п'},
                {'р','й','в','ф','а','є'}
        };
        char[][]table2 = new char[][]{
                {',','х','г','ч','є','і'},
                {'о','ц','н','й','п','_'},
                {'ш','ю','к','л','в','ь'},
                {'щ','р','а','и','ф','з'},
                {'.','я','е','у','м','ґ'},
                {'б','д','ж','с','ї','т'}
        };
        String text = "нехай_в_твоїм_серці_любові_не_згасне_священий_вогонь,_як_перше_промовлене_слово_на_мові_народу_свого";
        if(text.length()%2!=0)text=text+"_";
        String res = "";
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(table1[i][j]+" ");
            }
            System.out.print("  ");
            for(int k=0;k<6;k++){
                System.out.print(table2[i][k]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < text.length(); i = i + 2) {
            char f = text.charAt(i);
            char s = text.charAt(i + 1);
            int[] pos1 = getPos(f, table1, 6, 6);
            int[] pos2 = getPos(s, table2, 6, 6);
            char res1;
            char res2;
            if (pos1[0] == pos2[0]) {
                res1 = table2[pos1[0]][pos1[1]];
                res2 = table1[pos2[0]][pos2[1]];
            } else {
                res2 = table1[pos2[0]][pos1[1]];
                res1 = table2[pos1[0]][pos2[1]];
            }
            res = res + res1 + res2;
        }
        System.out.println(res);
    }
    public void task1_2(){
        char[][]table2 = new char[][]{
                {'з','ч','к','ь','н','м'},
                {'д','т','е','с','и','і'},
                {'о','л','у','б','ї','г'},
                {'я','.','ґ',',','щ','_'},
                {'ю','х','ж','ц','ш','п'},
                {'р','й','в','ф','а','є'}
        };
        char[][]table1 = new char[][]{
                {',','х','г','ч','є','і'},
                {'о','ц','н','й','п','_'},
                {'ш','ю','к','л','в','ь'},
                {'щ','р','а','и','ф','з'},
                {'.','я','е','у','м','ґ'},
                {'б','д','ж','с','ї','т'}
        };
        String text = "гше.ттмєґйьдгшфібшїшеп_азчзєбеюн_зпжйуісгш.зьяй.гщзсшсзєіпйтепбнипхґаї,изсшсзєіпгщфг_ьґтьегщійюргщзт";
        if(text.length()%2!=0)text=text+"_";
        String res = "";
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(table1[i][j]+" ");
            }
            System.out.print("  ");
            for(int k=0;k<6;k++){
                System.out.print(table2[i][k]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < text.length(); i = i + 2) {
            char f = text.charAt(i);
            char s = text.charAt(i + 1);
            int[] pos1 = getPos(f, table1, 6, 6);
            int[] pos2 = getPos(s, table2, 6, 6);
            char res1;
            char res2;
            if (pos1[0] == pos2[0]) {
                res1 = table2[pos1[0]][pos1[1]];
                res2 = table1[pos2[0]][pos2[1]];
            } else {
                res2 = Character.toUpperCase(table1[pos2[0]][pos1[1]]);
                res1 = Character.toUpperCase(table2[pos1[0]][pos2[1]]);
            }
            res = res + res1 + res2;
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
}
