package labs;

public class Lab11 {
    public void task1(){
        inverse_1();
        inverse_2();
    }
        public void inverse_1() {
        int a = 37 % 107;
        for (int x = 1; x < 107; x++) {
            if ((a * x) % 107 == 1) {
                System.out.println(x);
            }
        }
    }
    public void inverse_2() {
        int a = 137 % 837;
        for (int x = 1; x < 837; x++) {
            if ((a * x) % 837 == 1) {
                System.out.println(x);
            }
        }
    }
}
