import java.awt.Graphics;

public class Rectangle extends Geometry {
    
    private int iteration = 0;

    Rectangle(int iteration){
        this.iteration = iteration;
    }

    private void drawSquare(Graphics g, int x, int y,int size, int iteration){
        if (iteration >= 0) {
            int[] xPoints = {x - size, x - size, x + size, x + size};
            int[] yPoints = {y - size, y + size, y + size, y - size};
            g.drawPolygon(xPoints, yPoints, 4);
            drawSquare(g, x - size, y - size, size / 2, iteration - 1);
            drawSquare(g, x + size, y + size, size / 2, iteration - 1);
            drawSquare(g, x - size, y + size, size / 2, iteration - 1);
            drawSquare(g, x + size, y - size, size / 2, iteration - 1);   
        }
    }

    @Override
    void setIteration(int iterations) {this.iteration = iterations;}

    @Override
    void draw(Graphics g) {
        drawSquare(g, getWidth() / 2, getWidth() / 4 + 50 , 175 , this.iteration);
    }

}
