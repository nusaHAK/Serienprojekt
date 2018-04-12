package bspFenster_aus_Fenster_oeffnen;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import ModernFamily.ModernFamily;
import the100.The100;
import twoandahalfman.Twoandahalfman;
import dexter.Dexter;


public class Startfenster extends JFrame {
 
	private static final long serialVersionUID = 1L;
	JLabel lbl_ueberschrift;
	JList<String> lst_serien;
	JLabel lbl_serien;
	
	JButton btn_anzeigen;
	
	DefaultListModel<String> listenModell;
	String[] serien = {"Two and a half man", "The 100", "Dexter", "ModernFamily"};
	
	public Startfenster(){
			setTitle("Serienübersicht");
			Dimension d = new Dimension(400,300);
			this.setSize(d);
			this.setMinimumSize(d);
 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			initComponents();
			MyActionListener myActionListener = new MyActionListener();
			btn_anzeigen.addActionListener(myActionListener);
			
			pack();
			setVisible(true);
			
		}
		
		private class MyActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn_anzeigen){
					
					if (lst_serien.getSelectedIndex() == -1){
						JOptionPane.showMessageDialog(null, "Bitte treffen Sie eine Auswahl!");
					}
					else{
						if (lst_serien.getSelectedValue().equals("The 100")){
							new The100();
						}
						else if (lst_serien.getSelectedValue().equals("Two and a half")){
							new Twoandahalfman();
						}
						else if (lst_serien.getSelectedValue().equals("Dexter")){
							new Dexter();
						}
						else if (lst_serien.getSelectedValue().equals("ModernFamily")) {
							new ModernFamily();
						}
					}				    
				}
			}	
		}
		
		private void initComponents(){
			
			getContentPane().setLayout(new GridBagLayout());
			
			lbl_ueberschrift = new JLabel("Meine Lieblingsserien");
			lbl_ueberschrift.setHorizontalAlignment(JLabel.CENTER);
			Font schrift = lbl_ueberschrift.getFont().deriveFont(Font.BOLD + Font.ITALIC,18);
			lbl_ueberschrift.setFont(schrift);			
			lbl_serien = new JLabel("Liste meiner Serien");

			listenModell = new DefaultListModel<String>();
			 
	        //JList mit Einträgen wird erstellt
	        lst_serien= new JList<String>(listenModell);
	        for(int i=0; i<serien.length; i++){
	        	listenModell.addElement(serien[i]);
	        }
	 		
			JScrollPane listScroller = new JScrollPane(lst_serien);
											
			btn_anzeigen = new JButton("Anzeigen");
			
			GridBagConstraints c = new GridBagConstraints();
			
			c = definiereZelle(3,1,0,0);
			c.fill = GridBagConstraints.HORIZONTAL; 
			//c.anchor = GridBagConstraints.SOUTH;	
			c.insets =new Insets(15,10,10,10);
			this.getContentPane().add(lbl_ueberschrift, c);
			
			c = definiereZelle(1,1,1,1);
			//zweite Spalte
			c.insets =new Insets(0,10,0,10);
			this.getContentPane().add(lbl_serien, c);

			c = definiereZelle(1,2,1,2);
			c.ipady=30;
			c.ipadx = 20;
			c.insets =new Insets(5,10,10,10);
			this.getContentPane().add(listScroller, c);
			
			//dritte Spalte
			c = definiereZelle(1,1,2,2);
			c.ipady=0;
			c.ipadx = 0;
			c.insets =new Insets(20,10,0,20);
			this.getContentPane().add(btn_anzeigen, c);
		}
		
		private GridBagConstraints definiereZelle (int breite, int hoehe, int xpos, int ypos){
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridwidth = breite;
			gbc.gridheight = hoehe;
			gbc.gridx = xpos;
			gbc.gridy = ypos;
			return gbc;
		}
	}
