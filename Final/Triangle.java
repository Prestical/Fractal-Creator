import java.awt.*;

public class Triangle extends Geometry {

    private int iterations = 0;
    
    Triangle(int iterations){
        this.iterations = iterations;
    }
    
    private void drawTriangle(Graphics g, int x, int y, int size, int depth){
        if(depth == 0){
            int[] xPoints = {x, x + size, x - size};
            int[] yPoints = {y - size, y, y};
            g.drawPolygon(xPoints,yPoints,3);
        }else{
            int newSize = size / 2; 
            drawTriangle(g, x, y - newSize, newSize, depth - 1);
            drawTriangle(g,x + newSize, y, newSize, depth - 1);
            drawTriangle(g, x - newSize, y, newSize, depth - 1);
        }
    }

    @Override
    void setIteration(int iterations) {this.iterations = iterations;}

    @Override
    void draw(Graphics g) {
        drawTriangle(g, getWidth() / 2, getHeight(), 620, this.iterations);
    }
}