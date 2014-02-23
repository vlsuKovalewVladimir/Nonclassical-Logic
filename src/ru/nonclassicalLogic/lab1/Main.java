package ru.nonclassicalLogic.lab1;

public class Main{

    public static void main(String[] args) {
        TFuzzy[] tFuzzes = new TFuzzy[9];
        tFuzzes[1] = new TFuzzy(EFunction.ONE, 2, 4);
        tFuzzes[2] = new TFuzzy(EFunction.TWO, 2, 4, 6);
        tFuzzes[3] = new TFuzzy(EFunction.THREE, 2, 6, 3);
        tFuzzes[4] = new TFuzzy(EFunction.FOUR,  1, 6, 3);
        tFuzzes[5] = new TFuzzy(EFunction.FIVE,  2, 6, 4, 5);
        tFuzzes[6] = new TFuzzy(EFunction.SIX,   7, 2);
        tFuzzes[7] = new TFuzzy(EFunction.SEVEN, 2, 5);
        tFuzzes[8] = new TFuzzy(EFunction.EIGHT, 7, 2, 4);

        for(TFuzzy tf:tFuzzes){
            if (tf != null){
                System.out.println("---------------------------------");
                for (Expansion a:tf.getListExpansion()){
                    System.out.printf("l = %.2f\t_a = %.2f\ta_ = %.2f\n", a.l, a._a, a.a_);
                }
            }
        }
    }
}
