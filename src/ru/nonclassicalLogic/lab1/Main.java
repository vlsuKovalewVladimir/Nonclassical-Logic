package ru.nonclassicalLogic.lab1;

public class Main{

    public static void main(String[] args) {

        TFuzzy.n = 10;
        TFuzzy[] tFuzzies = new TFuzzy[9];
        tFuzzies[1] = new TFuzzy(1, 2, 4);

        /*tFuzzies[3] = new TFuzzy(3, 2, 6, 3);
        tFuzzies[4] = new TFuzzy(4, 1, 6, 3);
        tFuzzies[5] = new TFuzzy(5, 2, 6, 4, 5);
        tFuzzies[6] = new TFuzzy(6, 7, 2);
        tFuzzies[7] = new TFuzzy(7, 2, 5);
        tFuzzies[8] = new TFuzzy(8, 7, 2, 4);*/

        for(TFuzzy tf:tFuzzies){
            if (tf != null){
                System.out.println("---------------------------------");
                for (Expansion a:tf.listExpansion){
                    System.out.printf("l = %.2f\t_a = %.2f\ta_ = %.2f\n", a.l, a._a, a.a_);
                }
            }
        }
    }
}
