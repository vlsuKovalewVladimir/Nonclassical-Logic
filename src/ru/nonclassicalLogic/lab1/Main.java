package ru.nonclassicalLogic.lab1;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {

        List<TFuzzy> tFuzzyList = new ArrayList<TFuzzy>();

        tFuzzyList.add(new TFuzzy(NameFunction.ONE, 2, 4));
        tFuzzyList.add(new TFuzzy(NameFunction.TWO, 2, 4, 6));
        tFuzzyList.add(new TFuzzy(NameFunction.THREE, 2, 6, 3));
        tFuzzyList.add(new TFuzzy(NameFunction.FOUR,  1, 6, 3));
        tFuzzyList.add(new TFuzzy(NameFunction.FIVE,  2, 6, 4, 5));
        tFuzzyList.add(new TFuzzy(NameFunction.SIX,   7, 2));
        tFuzzyList.add(new TFuzzy(NameFunction.SEVEN, 2, 5));
        tFuzzyList.add(new TFuzzy(NameFunction.EIGHT, 7, 2, 4));
        tFuzzyList.add(null);

        new MyForm(tFuzzyList);

       /* TFuzzy[] tFuzzes = new TFuzzy[9];
        tFuzzes[1] = new TFuzzy(NameFunction.ONE, 2, 4);
        tFuzzes[2] = new TFuzzy(NameFunction.TWO, 2, 4, 6);
        tFuzzes[3] = new TFuzzy(NameFunction.THREE, 2, 6, 3);
        tFuzzes[4] = new TFuzzy(NameFunction.FOUR,  1, 6, 3);
        tFuzzes[5] = new TFuzzy(NameFunction.FIVE,  2, 6, 4, 5);
        tFuzzes[6] = new TFuzzy(NameFunction.SIX,   7, 2);
        tFuzzes[7] = new TFuzzy(NameFunction.SEVEN, 2, 5);
        tFuzzes[8] = new TFuzzy(NameFunction.EIGHT, 7, 2, 4);

        for(TFuzzy tf:tFuzzes){
            if (tf != null){
                System.out.println("---------------------------------");
                for (Expansion a:tf.getListExpansion()){
                    System.out.printf("y = %.2f\t_x = %.2f\tx_ = %.2f\n", a.y, a._x, a.x_);
                }
            }
        }*/
    }
}
