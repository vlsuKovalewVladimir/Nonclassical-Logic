package ru.nonclassicalLogic.lab1.form;

import ru.nonclassicalLogic.lab1.TFuzzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.List;

public class MyForm extends JFrame implements ItemListener{

    private JRadioButton[] rbs;
    private GraphPanel graphPanel;

    private List<TFuzzy> tFuzzyList;


    public MyForm(List<TFuzzy> tFuzzyList){
        this.tFuzzyList = tFuzzyList;

        setTitle("Лабораторная работа №1, Ковалев В.Е ИТс-112");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        initDesign();
        initEvent();

        setVisible(true);
    }

    private void initDesign(){
        // Инициализация элементов
        graphPanel = new GraphPanel();

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBackground(Color.LIGHT_GRAY);

        rbs = new JRadioButton[tFuzzyList.size()];
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < rbs.length; i++){
            String str = String.valueOf(i+1);
            if (tFuzzyList.get(i) != null)
                str += "(" + tFuzzyList.get(i).getNameFunction().toString() + ")";
            rbs[i] = new JRadioButton(str);
            rbs[i].putClientProperty("tFuzzy", i);
            rbs[i].setBackground(Color.LIGHT_GRAY);
            bg.add(rbs[i]);
            jPanel.add(rbs[i]);
        }

        // Отображение элементов
        this.getContentPane().setLayout(new BorderLayout(10, 10));
        this.getContentPane().add(graphPanel, BorderLayout.CENTER);
        this.getContentPane().add(jPanel, BorderLayout.WEST);
    }

    private void initEvent() {
        for(JRadioButton rb : rbs)
            rb.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange()== ItemEvent.DESELECTED)
            return;
        JRadioButton rb =  (JRadioButton)e.getSource();
        int i = Integer.parseInt(rb.getClientProperty("tFuzzy").toString());
        graphPanel.drawFunction(tFuzzyList.get(i));
    }
}
