package the100;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class The100 extends JFrame {


	private static final long serialVersionUID = 1L;
	//Erweiterungen für Fenster (Position, Größe)
	private Toolkit t;
	private int x = 0, y= 0, width = 1150, height = 750; //für Position - Breite u. Höhe des Fensters
		
	//Komponenten
	//umschließenden Container, der alle Untercontainer beinhaltet
	private JPanel masterContainer;
	private JComboBox<String> comboBox;
	
	private JPanel container1;
	private JPanel container2;		
	private JPanel container3;
	private JPanel container4;
	private JPanel container5;
	
	private JPanel header;
	private JPanel right_container;
	
	private JTextArea container1_textarea;
	private JLabel container1_label;
	private JTextArea container2_textarea;
	private JLabel container2_label;
	private JTextArea container3_textarea;
	private JLabel container3_label;
	private JTextArea container4_textarea;
	private JLabel container4_label;
	private JTextArea container5_textarea;
	private JLabel container5_label;
	

	public The100(){
				//Auflösung des Bildschirms holen
				t = Toolkit.getDefaultToolkit();
					
				//Position berechnen
				Dimension d = t.getScreenSize();
					
				//mittig anzeigen
				//gesamte Bildschirmbreite - Fensterbreite / 2 
				x = (int)(d.getWidth() - width) / 2;
				y = (int)(d.getHeight() - height) /2;
							
				//Titel,Größe u. Position, Schließen definieren
				setTitle("Mein Formular mit CardLayout");
				setBounds(x,y,width, height);
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				//init aufrufen
				this.initComponents();
				MyListener mylistener = new MyListener();
				comboBox.addItemListener(mylistener);
						
				setVisible(true);
	}
	
	private class MyListener implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			CardLayout cl = (CardLayout)masterContainer.getLayout();
		    //Elternseite u. die Seite die angezeigt werden soll angeben
		    cl.show(masterContainer,e.getItem().toString());
		}
	}
	
	private void initComponents(){
		this.getContentPane().setLayout(new BorderLayout());
		
		this.masterContainer = new JPanel(new CardLayout());
		masterContainer.setBackground(Color.LIGHT_GRAY);
		
		this.comboBox = new JComboBox<String>(new String[] {"Allgemeines","Handlung", 
				"Schauspieler", "Episodenguide - Staffel 1", 
				"Episodenguide - Staffel 2"});
		
		this.comboBox.setEditable(false);
		
		this.container1 = new JPanel();
		this.container1.setLayout(new BoxLayout(this.container1,BoxLayout.Y_AXIS));
		this.container1.setBackground(Color.LIGHT_GRAY);
		this.container1.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
		this.container2 = new JPanel();
		this.container2.setLayout(new BoxLayout(this.container2,BoxLayout.Y_AXIS));
		this.container2.setBackground(Color.LIGHT_GRAY);
		this.container2.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
		this.container3 = new JPanel();
		this.container3.setLayout(new BoxLayout(this.container3,BoxLayout.Y_AXIS));
		this.container3.setBackground(Color.LIGHT_GRAY);
		this.container3.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
		this.container4 = new JPanel();
		this.container4.setLayout(new BoxLayout(this.container4,BoxLayout.Y_AXIS));
		this.container4.setBackground(Color.LIGHT_GRAY);
		this.container4.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
		this.container5 = new JPanel();
		this.container5.setLayout(new BoxLayout(this.container5,BoxLayout.Y_AXIS));
		this.container5.setBackground(Color.LIGHT_GRAY);
		this.container5.setBorder(BorderFactory.createEmptyBorder(40, 20, 80, 40));
	
		this.header = new JPanel();
		header.setBackground(Color.LIGHT_GRAY);
		
		//Container 1
		this.container1_label = new JLabel("Allgemeines");
		this.container1_label.setHorizontalAlignment(JLabel.RIGHT);
		Font schrift = container1_label.getFont().deriveFont(Font.BOLD,20);
		this.container1_label.setFont(schrift);
		this.container1_textarea = new JTextArea();
		this.container1_textarea.setText("The 100 ist eine US-amerikanische"
				+ " Science-Fiction-Fernsehserie mit Eliza Taylor"
				+ " in der Hauptrolle. Produziert wird die Serie"
				+ " seit 2013 von Alloy Entertainment, CBS Television"
				+ " Studios und Warner Bros. Television für den"
				+ " Fernsehsender The CW. Die Idee der Fernsehserie"
				+ " basiert auf der gleichnamigen Buchreihe The 100"
				+ " von Kass Morgan." );
		
		this.container1_textarea.setLineWrap(true);
		this.container1_textarea.setWrapStyleWord(true);
		this.container1_textarea.setEditable(false);
		this.container1.add(container1_label);
		this.container1.add(container1_textarea);
		
		//Container 2
		this.container2_label = new JLabel("Handlung");
		this.container2_label.setHorizontalAlignment(JLabel.RIGHT);
		this.container2_label.setFont(schrift);
		this.container2_textarea= new JTextArea("Die Radioaktivität eines Atomkrieges" +
				" machte die Erde vor 97 Jahren unbewohnbar. Überlebende kamen auf" +
				" einer Raumstation, der Ark, zusammen. Aufgrund begrenzter" +
				" Ressourcen herrschen auf der Station strenge Regeln und " +
				"eine Ein-Kind-Politik. Jede von einem Erwachsenen verübte" +
				" Straftat wird mit dem Tode bestraft. Als feststeht, dass " +
				"der Ark nur wenige Monate bleiben, bis der Sauerstoff " +
				"aufgebraucht ist, werden 100 jugendliche Straftäter mit" +
				" einem Raumschiff auf die Erde entsandt, um mithilfe von " +
				"Armbändern, die Lebenszeichen an die Ark senden, herauszufinden," +
				" ob man auf der Erde wieder leben kann. Dort beginnt" +
				" für die Jugendlichen der Kampf ums überleben!");
		this.container2_textarea.setLineWrap(true);
		this.container2_textarea.setWrapStyleWord(true);
		this.container2_textarea.setEditable(false);

		this.container2.add(container2_label);
		this.container2.add(container2_textarea);
		
		//Container 3
	
		this.container3_label = new JLabel("Schauspieler");
		this.container3_label.setHorizontalAlignment(JLabel.RIGHT);
					
		this.container3_label.setFont(schrift);
		this.container3_textarea = new JTextArea("Die Darstellerin: Eliza Taylor \n" +
				"*24. Oktober 1989 in Melbourne, Victoria Australien\n" +
				"Ihre erste Rolle spielte sie in der australischen" +
				" Kinderserie Die Pirateninsel als Sarah Redding." +
				" 2003 bekam sie die Hauptrolle in der ersten Staffel" +
				" der Kinder- und Jugendserie Der Sleepover Club als" +
				" Rosie Cartwright. Von 2005 bis 2008 spielte sie in" +
				" der australischen Seifenoper Nachbarn die Janae " +
				"Timmins. Im November 2007 flog sie ins englische " +
				"Weymouth und spielte dort am Theater die Hauptrolle " +
				"der Schneewittchen. Seit 2014 verkörpert sie die" +
				" Hauptrolle Clarke Griffin in der Serie The 100. \n\n" +
				"Der Darsteller: Bob Morley \n" +
				"* 20. Dezember 1984 in Kyneton, Victoria, Australien\n" +
				"Morley begann seine Karriere in verschiedenen" +
				" Hochschultheaterstücken und Kurzfilmen. Für seine" +
				" Rolle in der australischen Soap Home and Away wurde" +
				" Morley für einen australischen Filmpreis, den Logie" +
				" Award, in der Kategorie Most Popular New Male Talent, " +
				"nominiert. 2008 wurde er für die australische Crimeserie " +
				"The Strip engagiert. Im Juni 2011 übernahm er eine Rolle" +
				" in der australischen Fernsehserie Nachbarn als Aidan " +
				"Foster, einem schwulen Krankenpfleger. Am 21. Februar" +
				" 2013 wurde bekannt, dass Morley eine Rolle in der CW" +
				" Serie The 100 annehmen wird, was seinen internationalen" +
				" Durchbruch bedeutete.");
		this.container3_textarea.setLineWrap(true);
		this.container3_textarea.setWrapStyleWord(true);
		this.container3_textarea.setEditable(false);
		JScrollPane textScroller = new JScrollPane(container3_textarea);
		this.container3.add(container3_label);
		//this.container3.add(container3_textarea);
		this.container3.add(textScroller);
		//Container4
		this.container4_label = new JLabel("Episodenguide - Staffel 1");
		this.container4_label.setHorizontalAlignment(JLabel.RIGHT);

		this.container4_label.setFont(schrift);
		this.container4_textarea = new JTextArea();
		this.container4_textarea.setText("01 Die Landung\n" +
				"02 Wir sind nicht allein\n " +
				"03 Wozu hat man Freunde\n" +
				"04 Murphys Gesetz\n" +
				"05 Ein Licht am Horizont\n" +
				"06 Ein Sturm zieht auf\n " +
				"07 Der Druck steigt\n" +
				"08 Konfrontationen\n" +
				"09 Der Anschlag\n" +
				"10 Nun bin ich der Tod geworden\n" +
				"11 Funkstille\n" +
				"12 Aufbruch\n " +
				"13 Der Feind meines Feindes" );
		
		this.container4_textarea.setLineWrap(true);
		this.container4_textarea.setWrapStyleWord(true);
		this.container4_textarea.setEditable(false);
		this.container4.add(container4_label);
		this.container4.add(container4_textarea);
		
		//Container5
		this.container5_label = new JLabel("Episodenguide - Staffel 2");
		this.container5_label.setHorizontalAlignment(JLabel.RIGHT);

		this.container5_label.setFont(schrift);
		this.container5_textarea = new JTextArea();
		this.container5_textarea.setText("01 Die 38\n" +
						"02 Uruhe im Berg\n " +
						"03 Bluternte\n" +
						"04 Neue Freunde\n" +
						"05 Menschenversuche\n" +
						"06 Ein Krieg zieht auf\n " +
						"07 Der Weg in die Freiheit\n" +
						"08 Spacewalker\n" +
						"09 Abschied\n" +
						"10 Monster\n" +
						"11 Machtkampf\n" +
						"12 Schwer wiegt die Krone\n " +
						"13 Der Weg zum Sieg\n" +
						"14 Vertrauen\n" +
						"15 Verrat\n" +
						"16 Das gelobte Land" );
				
		this.container5_textarea.setLineWrap(true);
		this.container5_textarea.setWrapStyleWord(true);
		this.container5_textarea.setEditable(false);
		this.container5.add(container5_label);
		this.container5.add(container5_textarea);
		
		//HEADER
		header.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//jetzt die einzelnen Container zum Masercontainer hinzufügen
		this.masterContainer.add(this.container1, "Allgemeines");
		this.masterContainer.add(this.container2, "Handlung");
		this.masterContainer.add(this.container3, "Schauspieler");
		this.masterContainer.add(this.container4, "Episodenguide - Staffel 1");
		this.masterContainer.add(this.container5, "Episodenguide - Staffel 2");
					
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		BufferedImage mypic;
		try {
			mypic = ImageIO.read(this.getClass().getResource("header.png"));
			JLabel lbl_icon = new JLabel(new ImageIcon(mypic));
			header.add(lbl_icon,c);
			c.anchor = GridBagConstraints.NORTHWEST;
			c.insets = new Insets(10,0,0,0);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		
		header.add(comboBox,c);
		c.insets = new Insets(10,0,40,0);
		
		//rightContainer
		right_container = new JPanel();
		right_container.setLayout(new BoxLayout(right_container,BoxLayout.Y_AXIS));
		right_container.setBackground(Color.LIGHT_GRAY);
		right_container.setBorder(BorderFactory.createEmptyBorder(20, 10, 40, 10));
		
		BufferedImage pic_the100;
		try {
			pic_the100 = ImageIO.read(this.getClass().getResource("the100.jpg"));
			JLabel lbl_the100 = new JLabel(new ImageIcon(pic_the100));
			right_container.add(lbl_the100);
			right_container.add(Box.createRigidArea(new Dimension(10,10)));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		this.getContentPane().add(this.header, BorderLayout.PAGE_START);
		this.getContentPane().add(this.masterContainer, BorderLayout.LINE_START);
		this.getContentPane().add(this.right_container, BorderLayout.CENTER);
	}

}
