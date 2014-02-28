package ru.nonclassicalLogic.lab1.form;

import ru.nonclassicalLogic.lab1.Expansion;
import ru.nonclassicalLogic.lab1.TFuzzy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class GraphPanel extends JPanel {

    private int graphMargin;
    private int countX;
    private TFuzzy tFuzzy;
    private BufferedImage biSystemOfAxes;

    public GraphPanel() {
        setGraphMargin(40);
        setCountX(10);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawSystemOfAxes1(g);
        drawAuxiliaryLines(g);
        drawGraph(g);
    }

    private void drawSystemOfAxes(Graphics g){

        int m = getGraphMargin();
        int dx = getDx();
        int dy = getDy();
        int countX = getCountX();

        Graphics2D g2d = (Graphics2D) g;


        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        g2d.drawLine(m, m, m, dy);
        g2d.drawLine(m, dy, dx, dy);

        for (double i = 0.1; i <= 1; i += 0.1){
            int x1 = m - 2;
            int x2 = m + 2;
            int y1 = dy - (int)((dy-m)*i);
            g2d.drawLine(x1, y1, x2, y1);
            g2d.drawString(String.format("%.1f", i), x1 - 25, y1 + 5);
        }

        g2d.setPaint(Color.RED);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{10,5}, 0));

        g2d.drawLine(m, (dy+m)/2, dx, (dy+m)/2);
        g2d.drawLine(m, m, dx, m);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (int i = 1; i <= countX; i++){
            int y1 = dy - 2;
            int y2 = dy + 2;
            int x1 = (dx - m)*i/countX + m;
            g2d.drawLine(x1, y1, x1, y2);
            g2d.drawString(String.valueOf(i), x1 - 5, dy + 25);
        }

    }
    private void drawSystemOfAxes1(Graphics g){

        if (biSystemOfAxes != null){
            g.drawImage(biSystemOfAxes,0,0,this);
            return;
        }

        int m = getGraphMargin();
        int dx = getDx();
        int dy = getDy();
        int countX = getCountX();

        biSystemOfAxes = (BufferedImage)createImage(getWidth(),getHeight());

        Graphics2D g2d = biSystemOfAxes.createGraphics();


        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        g2d.drawLine(m, m, m, dy);
        g2d.drawLine(m, dy, dx, dy);

        for (double i = 0.1; i <= 1; i += 0.1){
            int x1 = m - 2;
            int x2 = m + 2;
            int y1 = dy - (int)((dy-m)*i);
            g2d.drawLine(x1, y1, x2, y1);
            g2d.drawString(String.format("%.1f", i), x1 - 25, y1 + 5);
        }

        g2d.setPaint(Color.RED);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{10,5}, 0));

        g2d.drawLine(m, (dy+m)/2, dx, (dy+m)/2);
        g2d.drawLine(m, m, dx, m);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (int i = 1; i <= countX; i++){
            int y1 = dy - 2;
            int y2 = dy + 2;
            int x1 = (dx - m)*i/countX + m;
            g2d.drawLine(x1, y1, x1, y2);
            g2d.drawString(String.valueOf(i), x1 - 5, dy + 25);
        }

        g.drawImage(biSystemOfAxes,0,0,this);
    }

    private void drawAuxiliaryLines(Graphics g){
        if (tFuzzy == null)
            return;

        Graphics2D g2d = (Graphics2D) g;

        int m = getGraphMargin();
        int dx = getDx();
        int dy = getDy();
        int countX = getCountX();

        g2d.setPaint(Color.GRAY);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{5,10}, 0));

        double a = tFuzzy.getA();
        double b = tFuzzy.getB();
        double c = tFuzzy.getC();
        double d = tFuzzy.getD();

        int x = (int)((dx - m)*a/countX + m);
        g2d.drawLine(x, m, x, dy);
        g2d.drawString("a", x - 5, m - 5);
        x = (int)((dx - m)*b/countX + m);
        g2d.drawLine(x, m, x, dy);
        g2d.drawString("b", x - 5, m - 5);
        if ( ! Double.isNaN(c) ){
            x = (int)((dx - m)*c/countX + m);
            g2d.drawLine(x, m, x, dy);
            g2d.drawString("c", x - 5, m - 5);
        }
        if ( ! Double.isNaN(d) ){
            x = (int)((dx - m)*d/countX + m);
            g2d.drawLine(x, m, x, dy);
            g2d.drawString("d", x - 5, m - 5);
        }
    }

    private void drawGraph(Graphics g) {
        if (tFuzzy == null)
            return;

        List<Expansion> listExpansion = tFuzzy.getListExpansion();

        Graphics2D g2d = (Graphics2D) g;

        int m = getGraphMargin();
        int dx = getDx();
        int dy = getDy();
        int countX = getCountX();

        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (int i = 1; i < listExpansion.size(); i++){
            int _x1 = (int)((dx - m)*listExpansion.get(i-1)._x/countX + m);
            int y1 = dy - (int)((dy-m)*listExpansion.get(i-1).y);
            int _x2 = (int)((dx - m)*listExpansion.get(i)._x/countX + m);
            int y2 = dy - (int)((dy-m)*listExpansion.get(i).y);
            int x1_ = (int)((dx - m)*listExpansion.get(i-1).x_/countX + m);
            int x2_ = (int)((dx - m)*listExpansion.get(i).x_/countX + m);

            g2d.drawLine(_x1, y1, _x2, y2);
            if ( ! Double.isNaN(listExpansion.get(i-1).x_) )
                g2d.drawLine(x1_, y1, x2_, y2);
        }
    }

    public void drawFunction(TFuzzy tFuzzy){
        if (tFuzzy == null)
            return;

        this.tFuzzy = tFuzzy;

        paint(this.getGraphics());
    }


    public int getGraphMargin() {
        return graphMargin;
    }
    public void setGraphMargin(int graphMargin) {
        this.graphMargin = graphMargin;
    }

    public int getDx() {
        return getWidth() - getGraphMargin();
    }
    public int getDy() {
        return this.getHeight() - getGraphMargin();
    }

    public int getCountX() {
        return countX;
    }
    public void setCountX(int countX) {
        this.countX = countX;
    }
}
