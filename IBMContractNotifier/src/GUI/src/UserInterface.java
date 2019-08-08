package GUI.src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.rpc.ServiceException;

import com.ibm.contracts.client.ClientApplication;

import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class UserInterface {

	private JFrame frame;
	private JPanel backgroundPanel;
	
	private JPanel navPanel;
	private JLabel titleLabel;
	private JEditorPane hostEdittext;
	
	private JPanel bodyPanel;
	
	private JPanel forecastPanel;
	private JLabel forecastLabel;
	private static JTextField forecastTextField;
	private JButton forecastButton;
	
	private JPanel feedbackPanel;
	private JLabel feedbackLabel;
	private static JTextField feedbackTextField;
	private JButton feedbackButton;
	
	private JPanel outputPanel;
	private JLabel outputLabel;
	private static JTextField outputTextField;
	private JButton outputButton;
	
	private JPanel controlPanel;
	private static JProgressBar progressBar;
	private JButton runButton;
	
	private JFileChooser fileChooser;
	private FileNameExtensionFilter excelFilter = new FileNameExtensionFilter("XLS files", "xls", "xlsx");
	private int returnValue;
	private File selectedFile;
	private  ClientApplication client =new ClientApplication();

	private FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text files", "txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
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
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("IBM CONTRACTS");
		frame.setBounds(100, 100, 500, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		backgroundPanel = new JPanel();
		backgroundPanel.setBackground(new Color(0, 128, 128));
		backgroundPanel.setBounds(0, 0, 486, 393);
		frame.getContentPane().add(backgroundPanel);
		backgroundPanel.setLayout(null);

		navPanel = new JPanel();
		navPanel.setBackground(new Color(0, 102, 204));
		navPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		navPanel.setBounds(0, 0, 486, 38);
		backgroundPanel.add(navPanel);
		navPanel.setLayout(null);

		titleLabel = new JLabel("IBM Contracts");
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titleLabel.setBounds(10, 12, 141, 15);
		navPanel.add(titleLabel);

		hostEdittext = new JEditorPane();
		String serverAddress = client.readServerURL();
		
		if(serverAddress == null) {
			serverAddress = "http://localhost:9090";
		}
		else {
			if(serverAddress.equals("")) {
				serverAddress = "http://localhost:9090";
			}
			
		}
		
		hostEdittext.setText(serverAddress);
		hostEdittext.setBounds(150, 9, 326, 21);
		navPanel.add(hostEdittext);

		bodyPanel = new JPanel();
		bodyPanel.setBackground(new Color(51, 102, 255));
		bodyPanel.setBounds(0, 39, 486, 354);
		backgroundPanel.add(bodyPanel);
		bodyPanel.setLayout(null);

		forecastPanel = new JPanel();
		forecastPanel.setBackground(new Color(0, 102, 204));
		forecastPanel.setForeground(new Color(255, 255, 255));
		forecastPanel.setBounds(10, 10, 466, 71);
		bodyPanel.add(forecastPanel);
		forecastPanel.setLayout(null);

		forecastLabel = new JLabel("Forecast Excel File Path");
		forecastLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		forecastLabel.setForeground(new Color(255, 255, 255));
		forecastLabel.setBounds(10, 9, 254, 13);
		forecastPanel.add(forecastLabel);

		forecastButton = new JButton("Upload");
		forecastButton.setBounds(330, 36, 124, 24);
		forecastPanel.add(forecastButton);
		forecastButton.setForeground(Color.white);
		forecastButton.setBorderPainted(false);
		forecastButton.setFocusPainted(false);
		forecastButton.setContentAreaFilled(false);
		forecastButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(excelFilter);
				returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getPath());
					forecastTextField.setText(selectedFile.getPath());
					progressBar.setValue(10);
					 client.setFcPath(selectedFile.getPath());
				}
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				forecastButton.setForeground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				forecastButton.setForeground(Color.white);
			}
		});

		forecastTextField = new JTextField();
		forecastTextField.setEditable(false);
		forecastTextField.setBounds(10, 41, 310, 19);
		forecastPanel.add(forecastTextField);
		forecastTextField.setColumns(10);

		feedbackPanel = new JPanel();
		feedbackPanel.setLayout(null);
		feedbackPanel.setForeground(Color.WHITE);
		feedbackPanel.setBackground(new Color(0, 102, 204));
		feedbackPanel.setBounds(10, 91, 466, 71);
		bodyPanel.add(feedbackPanel);

		feedbackLabel = new JLabel("Feedback Excel File Path");
		feedbackLabel.setForeground(Color.WHITE);
		feedbackLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		feedbackLabel.setBounds(10, 9, 236, 13);
		feedbackPanel.add(feedbackLabel);

		feedbackButton = new JButton("Upload");
		feedbackButton.setBounds(330, 36, 124, 24);
		feedbackPanel.add(feedbackButton);
		feedbackButton.setForeground(Color.white);
		feedbackButton.setBorderPainted(false);
		feedbackButton.setFocusPainted(false);
		feedbackButton.setContentAreaFilled(false);
		feedbackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(excelFilter);
				returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getPath());
					feedbackTextField.setText(selectedFile.getPath());
					progressBar.setValue(20);
					 client.setFeedbackPath(selectedFile.getPath());
				}
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				feedbackButton.setForeground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				feedbackButton.setForeground(Color.white);
			}
		});

		feedbackTextField = new JTextField();
		feedbackTextField.setEditable(false);
		feedbackTextField.setColumns(10);
		feedbackTextField.setBounds(10, 41, 310, 19);
		feedbackPanel.add(feedbackTextField);
		
		outputPanel = new JPanel();
		outputPanel.setLayout(null);
		outputPanel.setForeground(Color.WHITE);
		outputPanel.setBackground(new Color(0, 102, 204));
		outputPanel.setBounds(10, 172, 466, 71);
		bodyPanel.add(outputPanel);
		
		outputLabel = new JLabel("Output File Path");
		outputLabel.setForeground(Color.WHITE);
		outputLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		outputLabel.setBounds(10, 9, 236, 13);
		outputPanel.add(outputLabel);
		
		outputTextField = new JTextField();
		outputTextField.setEditable(false);
		outputTextField.setColumns(10);
		outputTextField.setBounds(10, 41, 310, 19);
		outputPanel.add(outputTextField);
		
		outputButton = new JButton("Select");
		outputButton.setForeground(Color.WHITE);
		outputButton.setFocusPainted(false);
		outputButton.setContentAreaFilled(false);
		outputButton.setBorderPainted(false);
		outputButton.setBounds(330, 36, 124, 24);
		outputPanel.add(outputButton);
		outputButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(txtFilter);
				returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					System.out.println(selectedFile.getPath());
					outputTextField.setText(selectedFile.getPath());
					progressBar.setValue(30);
				 client.setOutPutFilePath(selectedFile.getPath());
				}
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				outputButton.setForeground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				outputButton.setForeground(Color.white);
			}
		});

		controlPanel = new JPanel();
		controlPanel.setForeground(Color.WHITE);
		controlPanel.setBackground(new Color(0, 102, 204));
		controlPanel.setBounds(10, 253, 466, 80);
		bodyPanel.add(controlPanel);
		controlPanel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("ProgressBar\r\n");
		progressBar.setForeground(new Color(0, 204, 255));
		progressBar.setBounds(10, 10, 446, 21);
		controlPanel.add(progressBar);

		runButton = new JButton("Generate");
		runButton.setIcon(null);
		runButton.setBounds(150, 40, 170, 32);
		controlPanel.add(runButton);
		runButton.setFont(new Font("Dialog", Font.BOLD, 18));
		runButton.setForeground(Color.white);
		runButton.setBorderPainted(false);
		runButton.setFocusPainted(false);
		runButton.setContentAreaFilled(false);
		runButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(hostEdittext.getText());
				
				if(checkValidity()) {
					progressBar.setValue(70);
					writeServerURL(hostEdittext.getText());
	            	try {
						client.invoqueRequest();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ServiceException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					progressBar.setValue(100);
				}
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				runButton.setForeground(Color.lightGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				runButton.setForeground(Color.white);
			}
		});
	}
	
	private static boolean checkValidity() {
		if(forecastTextField.getText().equals("")
				|| forecastTextField.getText().isEmpty()
				|| forecastTextField.getText() == null) {
			JOptionPane.showMessageDialog(null, "Not a valid Forecast Excel File Path!");
			return false;
		}
		
		if(feedbackTextField.getText().equals("")
				|| feedbackTextField.getText().isEmpty()
				|| feedbackTextField.getText() == null) {
			JOptionPane.showMessageDialog(null, "Not a valid Feedback Excel File Path!");
			return false;
		}
		
		if((outputTextField.getText().equals("")
				|| outputTextField.getText().isEmpty()
				|| outputTextField.getText() == null)) {
			JOptionPane.showMessageDialog(null, "Not a valid Output Text File Path!");
			return false;
		}
		
		return true;
	}

	public static void writeServerURL(String address) {

		Writer writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("config.txt"), "utf-8"));
			writer.write(address);

		} catch (IOException ex) {

		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}
	}
}
