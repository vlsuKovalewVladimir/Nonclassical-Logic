package ru.fuzzyLogic.lab1;

import ru.fuzzyLogic.lab1.form.MyForm;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {

        List<TFuzzy> tFuzzyList = new ArrayList<TFuzzy>();

        tFuzzyList.add(new TFuzzy(NameFunction.ONE,   2, 6));
        tFuzzyList.add(new TFuzzy(NameFunction.TWO,   2, 4,  6));
        tFuzzyList.add(new TFuzzy(NameFunction.THREE, 2, 10, 4));
        tFuzzyList.add(new TFuzzy(NameFunction.FOUR,  1, 3,  0.5));
        tFuzzyList.add(new TFuzzy(NameFunction.FIVE,  2, 6,  4, 5));
        tFuzzyList.add(new TFuzzy(NameFunction.SIX,   5, 1.3));
        tFuzzyList.add(new TFuzzy(NameFunction.SEVEN, 2, 5));
        tFuzzyList.add(new TFuzzy(NameFunction.EIGHT, 7, 1.6, 0.5));
        //tFuzzyList.add(null);

        tFuzzyList.get(7).setCount(1300);

        new MyForm(tFuzzyList);

        printTFuzzyList(tFuzzyList);
    }

    private static void printTFuzzyList(List<TFuzzy> tFuzzyList){
        for(TFuzzy tf:tFuzzyList){
            if (tf != null){
                System.out.println("---------------------------------");
                for (Expansion a : tf.getListExpansion()) {
                    System.out.printf("y = %.60f\t_x = %.2f\tx_ = %.2f\n", a.y, a._x, a.x_);
                }
                System.out.println(tf.getListExpansion().size());
            }
        }
    }
}
