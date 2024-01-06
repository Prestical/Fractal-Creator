import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PopUp<T extends Geometry>{

    private T fractalPanel;
    private JFrame frame;

    PopUp(T fractalPanel){
        this.fractalPanel = fractalPanel;
        frame = new JFrame(this.fractalPanel.getClass().getName() + " Fractal");
    }

	// Creating another frame to iteract with fractals
    public void createFrame(){
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    JTextField tfOrder = new JTextField(4);
		tfOrder.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    String text = tfOrder.getText();
			    try {
		        	int iterations = Integer.parseInt(text);
				    fractalPanel.setIteration(iterations);
				    fractalPanel.repaint();
		        } catch (NumberFormatException ex) {
			    	JOptionPane.showMessageDialog(frame, "Please enter a valid integer value for order.");
			    }
		    }
		});

		JLabel label = new JLabel("Enter an order: ");
		JPanel inputPanel = new JPanel();
		inputPanel.add(label);
		inputPanel.add(tfOrder);
	
	    frame.add(fractalPanel, BorderLayout.CENTER);
	    frame.add(inputPanel, BorderLayout.SOUTH);
	
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
    }
}
