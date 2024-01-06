import java.awt.*;


class Line extends Geometry {
    private int iterations = 0;
    private double angleFactor;
    private double sizeFactor;

    Line(int iterations) {
        this.angleFactor = Math.PI / 5;
        this.sizeFactor = 0.58;
        this.iterations = iterations;
    }
    
    private void paintTree(Graphics g, int depth, double x1, double y1,double length, double angle) {
        if (depth >= 0) {
            double x2 = x1 + Math.cos(angle) * length;
            double y2 = y1 - Math.sin(angle) * length;
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            paintTree(g, depth - 1, x2, y2, length * sizeFactor, angle + angleFactor);
            paintTree(g, depth - 1, x2, y2, length * sizeFactor, angle - angleFactor);
        }
    }

    @Override
    void setIteration(int iterations){this.iterations = iterations;}

    @Override
    void draw(Graphics g) {
        paintTree(g, this.iterations, getWidth() / 2, getHeight() - 10,getHeight() / 3, Math.PI / 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
}