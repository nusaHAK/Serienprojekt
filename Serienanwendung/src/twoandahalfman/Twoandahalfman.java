package twoandahalfman;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Twoandahalfman extends JFrame{
	

	private static final long serialVersionUID = 1L;
	private JLabel lbl_name;
	private JComboBox<String> chk_serie;
	private JLabel lbl_status;
	private JLabel lbl_pic;

	public Twoandahalfman(){
		
		setTitle("Serie");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		initComponents();
		
		MyItemListener myitemlistener = new MyItemListener();
		chk_serie.addItemListener(myitemlistener);
		pack();
		setVisible(true);
	}
	private class MyItemListener implements ItemListener{

		public void itemStateChanged(ItemEvent state){
			// TODO Auto-generated method stub
			if (state.getSource()==chk_serie){
				if (chk_serie.getSelectedItem()=="Info zum Inhalt"){
					lbl_status.setText("Inhalt");
				}else if(chk_serie.getSelectedItem()=="Produktionsjahre"){
					lbl_status.setText("3");
				}else if(chk_serie.getSelectedItem()=="Hauptdarsteller"){
					lbl_status.setText("Charlie Harper");
				}else if(chk_serie.getSelectedItem()=="Genre"){
					lbl_status.setText("Komödie");
				}
				
				
			}
		}
		
	}
	

	
	
	private void initComponents() {
		
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel ueberschrift = new JLabel("Artikel erfassen");
		Font header = new Font("Sans Serif", Font.BOLD, 16);
		ueberschrift.setFont(header);
		ueberschrift.setAlignmentX(CENTER_ALIGNMENT);
		
		c.gridx = 0; //Spalte
		c.gridy = 0; //Zeile
		c.gridwidth = 3; //Breite über 2 Spalten
		c.gridheight = 2; //Höhe über 2 Zeilen
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0,5,0,5); //oben, links, unten, rechts
		add(ueberschrift, c); //fügt die Überschrift mit den gegebenen Einschränkungen ein
		
		BufferedImage mypic;
		try{
			mypic=ImageIO.read(this.getClass().getResource("twoandahalfmen.jpg"));
			lbl_pic = new JLabel(new ImageIcon(mypic));
			lbl_pic.setToolTipText("Bennos Pizza");
			c.gridx = 0; 
			c.gridy=3;
			c.gridwidth=1;
			c.gridheight=1;
			c.anchor=GridBagConstraints.CENTER;
			c.insets=new Insets(0,5,0,5);
			add(lbl_pic,c);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		Font schriftart = new Font("Sans Serif", Font.PLAIN, 12);
		lbl_name = new JLabel("Artikelname:");
		lbl_name.setFont(schriftart);
		c.gridx = 0; //Spalte
		c.gridy = 3; //Zeile
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor=GridBagConstraints.WEST;
		c.insets = new Insets(0,5,0,5);
		add(lbl_name,c);
		
		String comboBoxListe[] = {"Info zum Inhalt","Produktionsjahre","Hauptdarsteller","Genre"};
		chk_serie = new JComboBox<String>(comboBoxListe);
		chk_serie.setSelectedIndex(1);
		chk_serie.setFont(schriftart);
		c.gridx = 1; //Spalte
		c.insets = new Insets(5,5,5,5);
		add(chk_serie,c);
		
		lbl_status = new JLabel("Anzeige");
		lbl_status.setFont(schriftart);
		c.gridx = 0; //Spalte
		c.gridy = 4; //Zeile
		c.gridwidth = 3; //Breite über 2 Spalten
		c.gridheight = 1; //Höhe über 2 Zeilen
		c.anchor=GridBagConstraints.CENTER;
		c.insets = new Insets(0,5,0,5);
		add(lbl_status,c);
			
	}
	

	public static void main(String[] args) {
		Twoandahalfman fenster = new Twoandahalfman();

	}

}
