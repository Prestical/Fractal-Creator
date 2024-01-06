
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		// App runner
		SwingUtilities.invokeLater(() ->{
			Main app = new Main();
			app.frameCreater();
		});
	}

	public void frameCreater(){

		// Creating the frame
		JFrame frame = new JFrame();
		frame.setTitle("CENG114 Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Creating buttons
		JButton lineButton = new JButton("Line Fractal");
		JButton circleButton = new JButton("Circle Fractal");
		JButton triangleButton = new JButton("Triangle Fractal");
		JButton rectangleButton = new JButton("Rectangle Fractal");

		// Adding functionality to buttons
		circleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				PopUp<Circle> circle = new PopUp<Circle>(new Circle(1));
				circle.createFrame();
			}	
		});
		triangleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopUp<Triangle> triangle = new PopUp<Triangle>(new Triangle(0));
				triangle.createFrame();
			}
		});
		lineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopUp<Line> line = new PopUp<Line>(new Line(0));
				line.createFrame();
			}
		});
		rectangleButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				PopUp<Rectangle> rectangle = new PopUp<Rectangle>(new Rectangle(0));
				rectangle.createFrame();
			}
		});

		// Placing buttons to center of the frame
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lineButton, gbc);
        gbc.gridy++;
        panel.add(circleButton, gbc);
        gbc.gridy++;
		panel.add(triangleButton, gbc);
		gbc.gridy++;
		panel.add(rectangleButton, gbc);

		// Adding buttons to the frame
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}