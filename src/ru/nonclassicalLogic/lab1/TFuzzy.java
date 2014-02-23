package ru.nonclassicalLogic.lab1;

import java.util.ArrayList;
import java.util.List;

public class TFuzzy {

    public static int n;
    public List<Expansion> listExpansion;

    public TFuzzy(int n, double a, double b){
        this(n, a, b, 0);
    }
    public TFuzzy(int n, double a, double b, double c){
        this(n, a, b, c, 0);
    }

    public TFuzzy(int n, double a, double b, double c, double d){
        listExpansion = new ArrayList();
        for (double l = 0; l <= 1.0; l += 1.0 / this.n){
            Expansion temp = new Expansion();
            temp.l = l;
            switch (n) {
                case 1:
                    // TODO: Не работает
                    if (l <= 0.5)
                        temp._a = Math.sqrt(l/2)*(b-a) + a;
                    else
                        temp._a =  Math.sqrt((1-l)/2)*(b-a) + a;
                    break;
                case 2:
                    // TODO: Доделать
                    break;
                case 3:
                    temp._a =  (c - a)*l + a;
                    temp.a_ = -(b - c)*l + b;
                    break;
                case 4:
                    temp._a = Math.pow(((1/l)-1)/a, 1.0/b) + c;
                    break;
                case 5:
                    temp._a =  (c - a)*l + a;
                    temp.a_ = -(b - d)*l + b;
                    break;
                case 6:
                    temp._a = Math.sqrt(-Math.log(l)*2.0)*b + a;
                    temp.a_ = -Math.sqrt(-Math.log(l)*2.0)*b + a;
                    break;
                case 7:
                    temp._a = -Math.log((1/l)-1)/a + b;
                    break;
                case 8:
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
