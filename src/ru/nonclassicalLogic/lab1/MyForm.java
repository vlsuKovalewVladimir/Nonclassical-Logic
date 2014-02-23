package ru.nonclassicalLogic.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.List;

public class MyForm extends JFrame implements ItemListener{

    private JRadioButton[] rbs;
    private Container container;
    private ButtonGroup bg;
    private JPanel jPanel;

    private List<TFuzzy> tFuzzyList;

    public MyForm(List<TFuzzy> tFuzzyList){
        this.tFuzzyList = tFuzzyList;

        setTitle("Лабораторная работа №1");
        setMaximumSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 400));
        //setBounds(100, 100, 400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initDesign();
        initEvent();

        setVisible(true);
    }

    private void initDesign(){
        // Инициализация элементов
        jPanel = new JPanel();
        container = new Container();
        container.setLayout(new FlowLayout());
        rbs = new JRadioButton[tFuzzyList.size()];
        bg = new ButtonGroup();
        for (int i = 0; i < rbs.length; i++){
            String str = String.valueOf(i+1);
            if (tFuzzyList.get(i) != null)
                str += "(" + tFuzzyList.get(i).getNameFunction().toString() + ")";
            rbs[i] = new JRadioButton(str);
            rbs[i].putClientProperty("tFuzzy", i);
            bg.add(rbs[i]);
            container.add(rbs[i]);
        }

        // Отображение элементов
        this.getContentPane().setLayout(new BorderLayout(10, 10));
        this.getContentPane().add(jPanel, BorderLayout.CENTER);
        this.getContentPane().add(container, BorderLayout.NORTH);

    }

    private void initEvent() {
        for(JRadioButton rb : rbs)
            rb.addItemListener(this);
    }

    private void drawGraph(Graphics g, TFuzzy tFuzzy){
        if (tFuzzy == null)
            return;

        jPanel.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setPaint(Color.GREEN);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        int m = 50;
        int dx = 500 + m;
        int dy = 300 + m;

        g2d.drawLine(m, m, m, dy);
        g2d.drawLine(m, dy, dx, dy);

        for (double i = 0.1; i <= 1; i += 0.1){
            int x1 = m - 5;
            int x2 = m + 5;
            int y1 = dy - (int)((dy-m)*i);
            g2d.drawLine(x1, y1, x2, y1);
            g2d.drawString(String.format("%.1f", i), x1 - 25, y1 + 5);
        }

        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{10,5}, 0));

        g2d.drawLine(m, (dy+m)/2, dx, (dy+m)/2);

        double minX = 999999;
        double maxX = 0;

        for (int i = 0; i < tFuzzy.getCount(); i++){
            double _x = tFuzzy.getExpansion(i)._x;
            double x_ = tFuzzy.getExpansion(i).x_;
            if (minX > _x) minX = _x;
            if (minX > _x) minX = x_;
            if (maxX < _x) maxX = _x;
            if (maxX < _x) maxX = x_;
        }

        System.out.println(""+ minX + "\n"+maxX);

       // for (dou)

        for (int i = 0; i < tFuzzy.getCount(); i++){
            g.drawLine(100,100,1,(int)tFuzzy.getExpansion(1)._x *100);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange()==e.DESELECTED)
            return;
        JRadioButton rb =  (JRadioButton)e.getSource();
        int i = Integer.parseInt(rb.getClientProperty("tFuzzy").toString());
        drawGraph(jPanel.getGraphics(), tFuzzyList.get(i));
    }
}
