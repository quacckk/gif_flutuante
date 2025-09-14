package gif_em_tela;

import java.awt.*;
import javax.swing.*;

public class gif extends JWindow{
	private int velx = 3, vely = 3;
	private int altura = 170, largura = 170;
	private JLabel gif_flutua;

	public gif(String diretorio) {
		
		ImageIcon Icon = new ImageIcon(getClass().getResource(diretorio));
		
		gif_flutua = new JLabel();
		add(gif_flutua);
		
		setSize(altura,largura);
		setBackground(new Color(0,0,0,0));
		setAlwaysOnTop(true);
		setVisible(true);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		Timer colisão = new Timer(20 e ->{
			Point position = getLocation()
		
	});
	

}
