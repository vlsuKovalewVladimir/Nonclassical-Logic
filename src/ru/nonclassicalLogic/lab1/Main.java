package ru.nonclassicalLogic.lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ru.nonclassicalLogic.lab1.model.Expansion;
import ru.nonclassicalLogic.lab1.model.NameFunction;
import ru.nonclassicalLogic.lab1.model.TFuzzy;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

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

        printTFuzzyList(tFuzzyList);

        launch(args);
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
