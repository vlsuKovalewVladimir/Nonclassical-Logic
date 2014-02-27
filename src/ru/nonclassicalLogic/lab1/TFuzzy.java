package ru.nonclassicalLogic.lab1;

import java.util.ArrayList;
import java.util.List;

public class TFuzzy {

    private int count;
    private NameFunction nameFunction;

    public double a, b, c, d; // TODO: Добавить get и set (private)

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
        calculation(nameFunction);
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
        calculation(nameFunction);
    }

    public NameFunction getNameFunction() {
        return nameFunction;
    }

    public List<Expansion> getListExpansion() {
        return listExpansion;
    }

    private Expansion calculationFunction(NameFunction nameFunction, double y){
        Expansion temp = new Expansion();
        temp.y = y;
        switch (nameFunction) {
            case ONE:
                // TODO: Не работает
                if (y <= 0.5)
                    temp._x = Math.sqrt(y/2)*(b-a) + a;
                else
                    temp._x =  Math.sqrt((1-y)/2)*(b-a) + a;

                // TODO: Сделать стандартное значение для temp.x_
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
        return temp;
    }

    private void calculation(NameFunction nameFunction){
        listExpansion = new ArrayList<Expansion>();
        double dy = 1f / this.getCount();
        for (double y = 0; y < 1; y += dy){
            Expansion temp = calculationFunction(nameFunction, y);
            listExpansion.add(temp);
        }
        listExpansion.add(calculationFunction(nameFunction, 1.0));
    }
}
