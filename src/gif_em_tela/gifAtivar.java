package gif_em_tela;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class gifAtivar extends JWindow{
	private int velx = 3, vely = 3;
	private int altura = 170, largura = 170;
	private JLabel gif_flutua;
	private final int VELOCIDADE_MINIMA = 1;
    private Timer timer;

	public gifAtivar(String diretorio) {
		
		ImageIcon Icon;
		
		if (getClass().getResource(diretorio) != null) {
		    // Caso o gif esteja dentro do projeto (classpath)
		    Icon = new ImageIcon(getClass().getResource(diretorio));
		} else {
		    // Caso seja um caminho externo digitado pelo usuário
		    Icon = new ImageIcon(diretorio);
		}
		
		gif_flutua = new JLabel(Icon);
		add(gif_flutua);
		
		setSize(altura,largura);
		setBackground(new Color(0,0,0,0));
		setAlwaysOnTop(true);
		setVisible(true);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		Timer colisao = new Timer(20, e ->{
			Point position = getLocation();
			int x = position.x + velx;
            int y = position.y + vely;

            // colisão horizontal
            if (x < 0 || x + largura > screen.width) {
            	velx = (int)(Math.random() * 6 + 2);
                if (x < 0) velx = Math.abs(velx);
                else velx = -Math.abs(velx);
            }

            // colisão vertical
            if (y < 0 || y + altura > screen.height) {
            	vely = (int)(Math.random() * 6 + 2);
                if (y < 0) vely = Math.abs(vely);
                else vely = -Math.abs(vely);
            }

            setLocation(x, y);
        });
        colisao.start();
		
        
	}
    public void novoGif(String caminhoDoGif) {
        File file = new File(caminhoDoGif);
        if (file.exists()) {
            ImageIcon gifIcon = new ImageIcon(caminhoDoGif);
            gif_flutua.setIcon(gifIcon);
            setSize(gifIcon.getIconWidth(), gifIcon.getIconHeight());
            revalidate();
            repaint();
            
            setVisible(true);
            timer.start();
        } else {
            System.err.println("Erro: Arquivo GIF não encontrado: " + caminhoDoGif);
            JOptionPane.showMessageDialog(null, "Caminho do GIF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void ajustarVelocidade(int delay) {
        if (delay >= VELOCIDADE_MINIMA) {
            timer.setDelay(delay);
        }
    }

    public void pararExecucao() {
        if (timer.isRunning()) {
            timer.stop();
        }
        dispose();
    }
	

}
