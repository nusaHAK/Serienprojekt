package ModernFamily;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class ModernFamily {

	private JFrame frame;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModernFamily window = new ModernFamily();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ModernFamily() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modern Family");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 414, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenre.setBounds(36, 142, 46, 14);
		frame.getContentPane().add(lblGenre);
		
		JLabel lblHandlung = new JLabel("Handlung:");
		lblHandlung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHandlung.setBounds(20, 167, 65, 14);
		frame.getContentPane().add(lblHandlung);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModernFamily.class.getResource("geilslogo.PNG")));
		label.setBounds(20, 75, 423, 56);
		frame.getContentPane().add(label);
		
		JLabel lblSitcom = new JLabel("Sitcom");
		lblSitcom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSitcom.setBounds(92, 142, 46, 14);
		frame.getContentPane().add(lblSitcom);
		
		JTextPane txtpnToldFromThe = new JTextPane();
		txtpnToldFromThe.setBackground(Color.WHITE);
		txtpnToldFromThe.setText("Told from the perspective of an unseen documentary filmmaker, the series offers an honest, often-hilarious perspective of family life. Parents Phil and Claire yearn for an honest, open relationship with their three kids. But a daughter who is trying to grow up too fast, another who is too smart for her own good, and a rambunctious young son make it challenging. Claire's dad, Jay, and his Latina wife, Gloria, are raising two sons together, but people sometimes believe Jay to be Gloria's father. Jay's gay son, Mitchell, and his partner, Cameron, have adopted a little Asian girl, completing one big -- straight, gay, multicultural, traditional -- happy family.");
		txtpnToldFromThe.setBounds(92, 167, 248, 215);
		txtpnToldFromThe.setOpaque(false);
		frame.getContentPane().add(txtpnToldFromThe);
		

	}
}
