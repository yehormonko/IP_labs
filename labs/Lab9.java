package labs;

public class Lab9 {
    public void task1(){
        int a = 5427;
        int b = 32887;
        while (a!=0&&b!=0) {
            if(a>b) a = a%b;
            else b=b%a;
        }
        System.out.println(a+b);
        int a1 = 7650;
        int b1 = 25245;
        while (a1!=0&&b1!=0) {
            if(a1>b1) a1 = a1%b1;
            else b1=b1%a1;
        }
        System.out.println(a1+b1);
    }
    public void task2_2() {
        String a = "238716";
        String div = "31";

        while (a.length() > 2) {
            int last = Integer.parseInt(a.charAt(a.length() - 1)+"");
            int sum = Integer.parseInt(a.substring(0, a.length() - 1));
            sum = last * (Integer.parseInt(div.charAt(0)+"")) - sum;
            a = sum + "";
        }
        System.out.println(a+" "+div);
    }
    public void task2(){
        String a = "294177";
        String div = "39";

        while (a.length() > 2) {
            int last = Integer.parseInt(a.charAt(a.length() - 1)+"");
            int sum = Integer.parseInt(a.substring(0, a.length() - 1));
            sum = last * (Integer.parseInt(div.charAt(0)+"")+1) + sum;
            a = sum + "";
        }
        System.out.println(a+" "+div);
    }
}
