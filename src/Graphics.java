import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.*;
import javax.swing.*;
public class Graphics implements ActionListener {
	private static JButton  copyButton,button;
	private static JLabel message;
	private static String x;
	private static JTextField panel;
	public static JLabel outcome;
	private static JFrame f;
	public static void main(String[] args) {     
		f= new JFrame("Website copier");  // creating instance of JFrame with message a on the upper left corner of the Window
		message=new JLabel("Copy the link of a website and click Submit");//creating label with message b above 
		message.setBounds(10,0,1000,100);//x axis, y axis, width, height  
	    copyButton = new JButton("Copy"); //adding copy button
		f.add(message);//adding message in JFrame  
		panel =new JTextField();
		panel.setBounds(10,70,300,20);
		f.add(panel);
		f.setSize(1000,300);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible
		button=new JButton("Submit");
		button.setBounds(10,100,80,25);
		button.addActionListener(new Graphics());
		copyButton.setBounds(100,100,80,25);
		f.add(button);
	}
	public void actionPerformed(ActionEvent e) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
	    f.add(copyButton);
		try {
			x = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException | IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		panel.setText(x);
		Major obj=new Major();
		try {
			x=obj.operation(x);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  copyButton.addActionListener(new ActionListener() {
	     public void actionPerformed(ActionEvent e) {
	    	 StringSelection selection = new StringSelection(x);
	    	 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    	 clipboard.setContents(selection, selection);
	          }
	   });
	}
}