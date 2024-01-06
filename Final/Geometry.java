import java.awt.*;
import javax.swing.JPanel;

public abstract class Geometry extends JPanel{
    
    abstract void draw(Graphics g);
    abstract void setIteration(int iterations);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
}