package com.xu.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.xu.main.xml.XmlDecodeWorker;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class MainWin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWin() {
		initialize();
	}
	JButton commitButton;
	JTextArea xmlText;
	JTextArea resultText;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 653, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
//		panel.setLayout(null);
		
		JLabel lblNewLabelXML = new JLabel("XML");
		lblNewLabelXML.setBounds(10, 61, 54, 15);
		frame.getContentPane().add(lblNewLabelXML, "cell 0 0");
		
		JScrollPane scrollPaneXML = new JScrollPane();
		scrollPaneXML.setBounds(102, 10, 408, 259);
		frame.getContentPane().add(scrollPaneXML, "cell 1 0,grow");
		
		JLabel lblNewLabelResult = new JLabel("Result");
		lblNewLabelResult.setBounds(10, 376, 54, 82);
		frame.getContentPane().add(lblNewLabelResult, "cell 0 1");
		
		JScrollPane scrollPaneResult = new JScrollPane();
		frame.getContentPane().add(scrollPaneResult, "cell 1 1,grow");
		 scrollPaneResult.setBounds(102, 279, 408, 259);
		 
		  resultText = new JTextArea();
		  scrollPaneResult.setViewportView(resultText);
		
		 commitButton = new JButton("commit");
		 commitButton.setBounds(197, 571, 213, 63);
		frame.getContentPane().add(commitButton, "cell 1 2");
		
		 xmlText = new JTextArea();
		 scrollPaneXML.setViewportView(xmlText);
		
		
		commitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				runFormat();
			}
		});
		
	}
	
	private void runFormat(){
		XmlDecodeWorker decodeWork=new XmlDecodeWorker(commitButton,resultText,xmlText.getText());
		decodeWork.run();
	}
}
