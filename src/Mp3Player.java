import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class Mp3Player extends JFrame {

	private JPanel contentPane;
	


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mp3Player frame = new Mp3Player();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param player obejto que reproduz a musica.
	 * @throws FileNotFoundException 
	 * @throws JavaLayerException 
	 * @throws IOException 
	 */
	public Mp3Player(Player player)  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 253, 88);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		/**
		 * Botao que reproduz a musica.
		 */
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
		            player.play();
		        } catch (Exception error) {
		            System.out.println("Erro!");
		            error.printStackTrace();
		        }
			}
			
		});
		contentPane.add(btnPlay);
		
		/**
		 * Botao que para a musica.
		 */
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		          player.close();
		        } catch (Exception error) {
		            System.out.println("Erro!");
		            error.printStackTrace();
		        }
			}
		});
		contentPane.add(btnStop);
		
		
	} 
	
}
	
	
	
	
	