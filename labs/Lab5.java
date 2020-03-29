package labs;

public class Lab5 {
    public void task1() {
        String text = "тескт – упорядкований набір з елементів алфавіту";
        String alphabet = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя";
        char[] chars = text.toCharArray();
        char[] alphabet_array = alphabet.toCharArray();
        int[] key = new int[]{2, 3, 4, 1, 7};
        int key_index = 0;
        String newStr="";
        for (char c:chars){
            int cur_index = alphabet.indexOf(c);
            newStr = newStr+alphabet_array[(key[key_index]+cur_index)%alphabet.length()];
        }
        System.out.println(newStr);
    }

    public void task2(){
        String text = "ИНДЕКСАЦИЯ ПРОЦЕСС ВКЛЮЧЕНИЯ ССЫЛКИ НА КАКОЙ ЛИБО РЕСУРС ИНТЕРНЕТА В БАЗУ ДАННЫХ ПОИСКОВОЙ МАШИНЫ";
        String res = "";
        String key = "МОНИТОР";
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'А' || c > 'Я')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'А') % 32 + 'А');
            j = ++j % key.length();
        }
        System.out.println(res);
    }

}
