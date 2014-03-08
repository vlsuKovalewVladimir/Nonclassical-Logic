package ru.nonclassicalLogic.lab1.model;

import java.util.ArrayList;
import java.util.List;

public class TFuzzy {

    @Override
    public String toString() {
        String result = "(";
        result += getNameFunction().toString();
        result += ")";
        return result;
    }

    private int count;
    private NameFunction nameFunction;

    private double a;
    private double b;
    private double c;
    private double d;

    private List<Expansion> listExpansion;

    public TFuzzy(NameFunction nameFunction, double a, double b){
        this(nameFunction, a, b, Double.NaN);
    }
    public TFuzzy(NameFunction nameFunction, double a, double b, double c){
        this(nameFunction, a, b, c, Double.NaN);
    }
    public TFuzzy(NameFunction nameFunction, double a, double b, double c, double d){
        this.nameFunction = nameFunction;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        setCount(100);
        calculation(nameFunction);
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
        calculation(nameFunction);
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getD() {
        return d;
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
        temp.x_ = temp._x = Double.NaN;
        switch (nameFunction) {
            case ONE:
                temp._x = (y<=0.5) ?
                        a + Math.sqrt(y/2)*(b-a) :
                        b - Math.sqrt((1-y)/2)*(b-a);
                break;
            case TWO:
                temp._x = (y<=0.5) ?
                        a + Math.sqrt(y/2)*(b-a) :
                        b - Math.sqrt((1-y)/2)*(b-a);
                temp.x_ = (c+b) - temp._x;
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
                temp._x = - Math.sqrt(-Math.log(y)*2.0)*b + a;
                temp.x_ =  Math.sqrt(-Math.log(y)*2.0)*b + a;
                break;
            case SEVEN:
                temp._x = -Math.log((1/y)-1)/a + b;
                break;
            case EIGHT:
                temp._x = - Math.sqrt(-Math.log(y)*2.0)*b + a;
                temp.x_ = Math.sqrt(-Math.log(y)*2.0)*c + a;
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
