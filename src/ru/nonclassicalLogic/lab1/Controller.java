package ru.nonclassicalLogic.lab1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import ru.nonclassicalLogic.lab1.model.NameFunction;
import ru.nonclassicalLogic.lab1.model.TFuzzy;

public class Controller {

    public Button btn;
    public ListView listView;

    public void click(ActionEvent actionEvent) {
        /*ObservableList<TFuzzy> tFuzzyList = FXCollections.observableArrayList();
        tFuzzyList.add(new TFuzzy(NameFunction.ONE,   2, 6));
        tFuzzyList.add(new TFuzzy(NameFunction.TWO,   2, 4,  6));
        tFuzzyList.add(new TFuzzy(NameFunction.THREE, 2, 10, 4));
        tFuzzyList.add(new TFuzzy(NameFunction.FOUR,  1, 3,  0.5));
        tFuzzyList.add(new TFuzzy(NameFunction.FIVE,  2, 6,  4, 5));
        tFuzzyList.add(new TFuzzy(NameFunction.SIX,   5, 1.3));
        tFuzzyList.add(new TFuzzy(NameFunction.SEVEN, 2, 5));
        tFuzzyList.add(new TFuzzy(NameFunction.EIGHT, 7, 1.6, 0.5));*/

        ObservableList<String> tFuzzyList = FXCollections.observableArrayList();
        tFuzzyList.add("1");
        tFuzzyList.add("2");
        tFuzzyList.add("3");
        tFuzzyList.add("4");
        tFuzzyList.add("5");
        
        listView.setItems(tFuzzyList);


        listView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        System.out.println("1");
                    }
                });
    }

    public void edf(ListView.EditEvent<TFuzzy> tEditEvent) {
        btn.setText("1");
    }
}
