package ru.nonclassicalLogic.lab1;

import java.util.ArrayList;
import java.util.List;

public class TFuzzy {

    private int count;
    private NameFunction nameFunction;

    private double a, b, c, d;

    private List<Expansion> listExpansion;

    public TFuzzy(NameFunction nameFunction, double a, double b){
        this(nameFunction, a, b, 0);
    }
    public TFuzzy(NameFunction nameFunction, double a, double b, double c){
        this(nameFunction, a, b, c, 0);
    }
    public TFuzzy(NameFunction nameFunction, double a, double b, double c, double d){
        this.nameFunction = nameFunction;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.count = 10;
        calculation(nameFunction, a, b, c, d);
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
        calculation(nameFunction, a, b, c, d);
    }

    public NameFunction getNameFunction() {
        return nameFunction;
    }

    public List<Expansion> getListExpansion() {
        return listExpansion;
    }

    private void calculation(NameFunction nameFunction1, double a, double b, double c, double d){
        listExpansion = new ArrayList<Expansion>();
        for (double y = 0; y <= 1.0; y += 1.0 / this.count){
            Expansion temp = new Expansion();
            temp.y = y;
            switch (nameFunction1) {
                case ONE:
                    // TODO: Не работает
                    if (y <= 0.5)
                        temp._x = Math.sqrt(y/2)*(b-a) + a;
                    else
                        temp._x =  Math.sqrt((1-y)/2)*(b-a) + a;
                    break;
                case TWO:
                    // TODO: Доделать
                    break;
                case THREE:
                    temp._x =  (c - a)*y + a;
                    temp.x_ = -(b - c)*y + b;
                    break;
                case FOUR:
                    temp._x = Math.pow(((1/y)-1)/a, 1.0/b) + c;
                    break;
                case FIVE:
                    temp._x =  (c - a)*y + a;
                    temp.x_ = -(b - d)*y + b;
                    break;
                case SIX:
                    temp._x = Math.sqrt(-Math.log(y)*2.0)*b + a;
                    temp.x_ = -Math.sqrt(-Math.log(y)*2.0)*b + a;
                    break;
                case SEVEN:
                    temp._x = -Math.log((1/y)-1)/a + b;
                    break;
                case EIGHT:
                    temp._x = Math.sqrt(-Math.log(y)*2.0)*b + a;
                    temp.x_ = -Math.sqrt(-Math.log(y)*2.0)*c + a;
                    break;

                default:
                    break;
            }
            listExpansion.add(temp);
        }
    }
}
