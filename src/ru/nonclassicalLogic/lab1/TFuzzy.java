package ru.nonclassicalLogic.lab1;

import java.util.ArrayList;
import java.util.List;

public class TFuzzy {
    private int n;
    private EFunction eFunction;
    private double a, b, c, d;
    private List<Expansion> listExpansion;

    public TFuzzy(EFunction eFunction, double a, double b){
        this(eFunction, a, b, 0);
    }
    public TFuzzy(EFunction eFunction, double a, double b, double c){
        this(eFunction, a, b, c, 0);
    }
    public TFuzzy(EFunction eFunction, double a, double b, double c, double d){
        this.eFunction = eFunction;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.n = 10;
        calculation(eFunction, a, b, c, d);
    }

    public List<Expansion> getListExpansion() {
        return listExpansion;
    }

    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
        calculation(eFunction, a, b, c, d);
    }

    private void calculation(EFunction eFunction, double a, double b, double c, double d){
        listExpansion = new ArrayList();
        for (double l = 0; l <= 1.0; l += 1.0 / this.n){
            Expansion temp = new Expansion();
            temp.l = l;
            switch (eFunction) {
                case ONE:
                    // TODO: Не работает
                    if (l <= 0.5)
                        temp._a = Math.sqrt(l/2)*(b-a) + a;
                    else
                        temp._a =  Math.sqrt((1-l)/2)*(b-a) + a;
                    break;
                case TWO:
                    // TODO: Доделать
                    break;
                case THREE:
                    temp._a =  (c - a)*l + a;
                    temp.a_ = -(b - c)*l + b;
                    break;
                case FOUR:
                    temp._a = Math.pow(((1/l)-1)/a, 1.0/b) + c;
                    break;
                case FIVE:
                    temp._a =  (c - a)*l + a;
                    temp.a_ = -(b - d)*l + b;
                    break;
                case SIX:
                    temp._a = Math.sqrt(-Math.log(l)*2.0)*b + a;
                    temp.a_ = -Math.sqrt(-Math.log(l)*2.0)*b + a;
                    break;
                case SEVEN:
                    temp._a = -Math.log((1/l)-1)/a + b;
                    break;
                case EIGHT:
                    temp._a = Math.sqrt(-Math.log(l)*2.0)*b + a;
                    temp.a_ = -Math.sqrt(-Math.log(l)*2.0)*c + a;
                    break;

                default:
                    break;
            }
            listExpansion.add(temp);
        }
    }
}
