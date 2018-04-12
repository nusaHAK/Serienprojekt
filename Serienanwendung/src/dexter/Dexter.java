package dexter;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Dexter extends JFrame {

	
	private static final long serialVersionUID = 1L;
	//Erweiterungen für Fenster (Position, Größe)
	private Toolkit t;
	private int width = 400, height = 100; //für Position - Breite u. Höhe des Fensters
		

	private JPanel masterContainer;
	private JComboBox<String> comboBox;
	
	private JPanel container1;
	private JPanel container2;		
	private JPanel container3;
	private JPanel top;
	private JPanel left_container;
	private JButton btn_rot;
	private JButton btn_gruen;
	private JButton btn_blau;
	
	private JTextArea container1_textarea;
	private JLabel container1_label;
	private JTextArea container2_textarea;
	private JLabel container2_label;
	
	private JTextArea container3_textarea;
	private JLabel container3_label;
	
	
	public Dexter(){
			
	
		t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		setSize(d);
		Dimension dim = new Dimension(width,height);
		setMinimumSize(dim);
		
		setTitle("Dexter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		this.initComponents();
		MyListener mylistener = new MyListener();
		comboBox.addItemListener(mylistener);
		MyActionListener myListener = new MyActionListener();
	
		btn_rot.addActionListener(myListener);
		btn_gruen.addActionListener(myListener);
		btn_blau.addActionListener(myListener);
	
		setVisible(true);
	}
	
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()== btn_rot){
				container1_textarea.setForeground(Color.red);
				container2_textarea.setForeground(Color.red);
				container3_textarea.setForeground(Color.red);
			
		}else if (e.getSource()== btn_gruen){
			container1_textarea.setForeground(Color.green);
			container2_textarea.setForeground(Color.green);
			container3_textarea.setForeground(Color.green);
		}else if (e.getSource()== btn_blau){
			container1_textarea.setForeground(Color.blue);
			container2_textarea.setForeground(Color.blue);
			container3_textarea.setForeground(Color.blue);
		}
			}
		
	}

		private class MyListener implements ItemListener{
		
				public void itemStateChanged(ItemEvent e){
			
				    CardLayout cl = (CardLayout)masterContainer.getLayout();
				
				    cl.show(masterContainer,e.getItem().toString());
				}
			
		}
		
		private void initComponents() {

			this.getContentPane().setLayout(new BorderLayout());
			
			this.masterContainer = new JPanel(new CardLayout());
			masterContainer.setBackground(Color.red);
			
			this.comboBox = new JComboBox<String>(new String[] {"Inhalt", 
					"Darsteller", "Staffeln"});
			
			 btn_rot = new JButton("Rot");
			 btn_gruen = new JButton("Grün");
			 btn_blau = new JButton("Blau");
	
			this.comboBox.setEditable(false);
			
			this.container1 = new JPanel();
			this.container1.setLayout(new BoxLayout(this.container1,BoxLayout.Y_AXIS));
			this.container1.setBackground(Color.red);
			this.container1.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
			this.container2 = new JPanel();
			this.container2.setLayout(new BoxLayout(this.container2,BoxLayout.Y_AXIS));
			this.container2.setBackground(Color.red);
			this.container2.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
			this.container3 = new JPanel();
			this.container3.setLayout(new BoxLayout(this.container3,BoxLayout.Y_AXIS));
			this.container3.setBackground(Color.red);
			this.container3.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
			
			top = new JPanel();
			top.setBackground(Color.red);
			
			
			
			container1_label = new JLabel("Inhalt");
			this.container1_label.setHorizontalAlignment(JLabel.CENTER);
			Font schrift = container1_label.getFont().deriveFont(Font.BOLD,20);
			
				this.container1_label.setFont(schrift);
				container1_textarea = new JTextArea();
				this.container1_textarea.setText("Dexter ist eine US-amerikanische Krimi- bzw. Dramaserie "
				+"mit Elementen des schwarzen Humors. Michael C. Hall spielt den Serienmörder Dexter Morgan,"
				+"der beim Miami-Metro Police Department als Forensiker in der Blutspurenanalyse arbeitet "
				+"und in seiner Freizeit Selbstjustiz übt. Die Serie basiert auf den Büchern Darkly Dreaming Dexter"
				+" Dearly Devoted Dexter,Dexter in the Dark,Dexter By Design, Dexter is Delicious, Double Dexter und "
				+"Dexter's Final Cut von Jeff Lindsay."
				+ "Es gab acht Staffeln, die in den Vereinigten Staaten von 2006 bis 2013 ausgestrahlt"
				+"und mit dem Serienfinale am 22. September abgeschlossen wurden.");
				this.container1_textarea.setLineWrap(true);
				this.container1_textarea.setWrapStyleWord(true);
				this.container1_textarea.setEditable(false);
				this.container1.add(container1_label);
				this.container1.add(this.container1_textarea);
			
		
			container2_label = new JLabel("Darsteller");
			this.container2_label.setHorizontalAlignment(JLabel.CENTER);
			this.container2_label.setFont(schrift);
			container2_textarea= new JTextArea("Dexter Morgan "
					+ "Debra Morgan\n"
					+ "Harry Morgan\n"
					+ "Angelo Angel Batista\n"
					+ "Maria LaGuerta\n"
					+ "Vince Masuka\n"
					+ "Joseph Quinn\n"
					+ "Rita Bennett\n"
					+ "Hannah McKay\n"
					+ "James Doakes");
					
			this.container2_textarea.setLineWrap(true);
			this.container2_textarea.setWrapStyleWord(true);
			this.container2_textarea.setEditable(false);

			this.container2.add(this.container2_label);
			this.container2.add(this.container2_textarea);
			
			
		
			container3_label = new JLabel("Staffeln");
			this.container3_label.setHorizontalAlignment(JLabel.CENTER);
						
			this.container3_label.setFont(schrift);
			container3_textarea = new JTextArea("Staffel 1\n"
					+ "Staffel 2\n"
					+ "Staffel 3\n"					
					+ "Staffel 4\n"
					+ "Staffel 5\n"
					+ "Staffel 6\n"
					+ "Staffel 7\n"
					+ "Staffel 8");
			this.container3_textarea.setLineWrap(true);
			this.container3_textarea.setWrapStyleWord(true);
			this.container3_textarea.setEditable(false);
			this.container3.add(this.container3_label);
			this.container3.add(this.container3_textarea);
			
			
			
			
			top.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			
	
			this.masterContainer.add(this.container1, "Inhalt");
			this.masterContainer.add(this.container2, "Darsteller");
			this.masterContainer.add(this.container3, "Staffeln");
						
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			
			BufferedImage mypic;
			try {
				mypic = ImageIO.read(this.getClass().getResource("dexter.jpg"));
				JLabel lbl_icon = new JLabel(new ImageIcon(mypic));
				top.add(lbl_icon,c);
				c.anchor = GridBagConstraints.NORTHWEST;
				c.insets = new Insets(10,0,0,0);
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			
			top.add(comboBox,c);
			c.insets = new Insets(10,0,40,0);
			
			left_container = new JPanel();
			left_container.setLayout(new BoxLayout(left_container,BoxLayout.Y_AXIS));
			left_container.setBackground(Color.red);
			left_container.setBorder(BorderFactory.createEmptyBorder(20, 10, 40, 10));
			
			left_container.add(btn_rot);
			left_container.add(btn_gruen);
			left_container.add(btn_blau);
			
			BufferedImage pic_schild;
			try {
				pic_schild = ImageIO.read(this.getClass().getResource("dexter_1310284_616.jpg"));
				JLabel lbl_schild = new JLabel(new ImageIcon(pic_schild));
				left_container.add(lbl_schild);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			this.getContentPane().add(top, BorderLayout.PAGE_START);
			
			this.getContentPane().add(this.left_container, BorderLayout.LINE_START);
			this.getContentPane().add(this.masterContainer, BorderLayout.CENTER);
			
		}
		
}
