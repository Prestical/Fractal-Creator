import java.awt.*;

public class Circle extends Geometry {
    private int iterations = 0;

    public Circle(int iterations) {
        this.iterations = iterations;
    }
    
    private void drawCircle(Graphics g, int x, int y, int radius, int iterations) {
        if (iterations == 0) return;

        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        drawCircle(g, x + radius / 2, y, radius / 2, iterations - 1);
        drawCircle(g, x - radius / 2, y, radius / 2, iterations - 1);
    }
    
    @Override
    void setIteration(int iterations) {this.iterations = iterations;}

    @Override
    void draw(Graphics g) {
        drawCircle(g, getWidth() / 2, getHeight() / 2, getHeight() / 2, iterations);
    }

}