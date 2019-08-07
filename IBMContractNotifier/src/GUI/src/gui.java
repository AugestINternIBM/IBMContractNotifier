package GUI.src;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.rpc.ServiceException;

import com.ibm.contracts.client.ClientApplication;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Font;

public class gui {

	private JFrame frame;
	private  ClientApplication client =new ClientApplication();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
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
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 465, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 205, 50));
		panel.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 0));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(0, 0, 450, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IBM Contracts");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 12, 140, 15);
		panel_1.add(lblNewLabel);
		
		JEditorPane dtrpnHttplocalhostres = new JEditorPane();
		dtrpnHttplocalhostres.setText("http://localhost:9090");
		dtrpnHttplocalhostres.setBounds(150, 7, 200, 21);
		panel_1.add(dtrpnHttplocalhostres);
		
		JButton btnNewButton = new JButton("âœ”â€�");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(390, 8, 50, 20);
		btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	String textFieldValue = dtrpnHttplocalhostres.getText();
            	System.out.println(textFieldValue);
            	writeServerURL(textFieldValue);
            	//TODO check excel file paths 
            	try {
					client.invoqueRequest();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServiceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	btnNewButton.setForeground(Color.lightGray);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	btnNewButton.setForeground(Color.white);
            }
        });
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 139, 34));
		panel_2.setBounds(0, 39, 450, 261);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("src/data/ibm.png"));
		lblNewLabel_1.setBounds(17, 30, 426, 221);
		panel_2.add(lblNewLabel_1);
		
		JButton btnLoadFcFile = new JButton("Load FC File");
		btnLoadFcFile.setForeground(Color.white);
		btnLoadFcFile.setBorderPainted(false);
		btnLoadFcFile.setFocusPainted(false);
		btnLoadFcFile.setContentAreaFilled(false);
		btnLoadFcFile.setBounds(33, 10, 150, 25);
		btnLoadFcFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	JFileChooser fileChooser = new JFileChooser();
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls" , "xlsx");
            	fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) 
                {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println(selectedFile.getPath());
                client.setFcPath(selectedFile.getPath());
            }
            }
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	btnLoadFcFile.setForeground(Color.lightGray);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	btnLoadFcFile.setForeground(Color.white);
            }
        });
		panel_2.add(btnLoadFcFile);
		
		JButton btnLoadExportFile = new JButton("Load Export File");
		btnLoadExportFile.setForeground(Color.white);
		btnLoadExportFile.setBorderPainted(false);
		btnLoadExportFile.setFocusPainted(false);
		btnLoadExportFile.setContentAreaFilled(false);
		btnLoadExportFile.setBounds(260, 10, 150, 25);
		btnLoadExportFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	JFileChooser fileChooser = new JFileChooser();
            	FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls" , "xlsx");
            	fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) 
                {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println(selectedFile.getPath());
                client.setFeedbackPath(selectedFile.getPath());
            }
            }
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	btnLoadExportFile.setForeground(Color.lightGray);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	btnLoadExportFile.setForeground(Color.white);
            }
        });
		panel_2.add(btnLoadExportFile);
	}
	public static void writeServerURL(String address) 	{	
		
		Writer writer = null;

	try {
	    writer = new BufferedWriter(new OutputStreamWriter(
	          new FileOutputStream("config.txt"), "utf-8"));
				writer.write(address);
			
		} catch (IOException ex) {
	  
		} finally {
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}	
}
