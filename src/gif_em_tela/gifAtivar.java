package gif_em_tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class gifAtivar extends JFrame {

    private JLabel gifLabel;
    private Timer timer;
    private int x = 0, y = 0;
    private int dx = 1, dy = 1;
    private final int VELOCIDADE_MINIMA = 1;

    // Construtor para arquivos locais (usado pelo FileChooser)
    public gifAtivar(String caminhoDoGif) {
        configurarFrame();
        File file = new File(caminhoDoGif);
        if (file.exists()) {
            novoGif(new ImageIcon(caminhoDoGif));
        } else {
            System.err.println("Erro: Arquivo não encontrado: " + caminhoDoGif);
            JOptionPane.showMessageDialog(null, "Caminho do GIF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    // NOVO CONSTRUTOR: para URLs (usado pelo botão padrão)
    public gifAtivar(URL gifUrl) {
        configurarFrame();
        if (gifUrl != null) {
            novoGif(new ImageIcon(gifUrl));
        } else {
            System.err.println("Erro: URL do GIF é nula.");
            JOptionPane.showMessageDialog(null, "Caminho do GIF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

    private void configurarFrame() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setAlwaysOnTop(true);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
            }
        });

        gifLabel = new JLabel();
        add(gifLabel);

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentX = getLocation().x;
                int currentY = getLocation().y;

                if (currentX + dx < 0 || currentX + dx > Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) {
                    dx = -dx;
                }
                if (currentY + dy < 0 || currentY + dy > Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) {
                    dy = -dy;
                }
                setLocation(currentX + dx, currentY + dy);
            }
        });
    }

    private void novoGif(ImageIcon gifIcon) {
        gifLabel.setIcon(gifIcon);
        setSize(gifIcon.getIconWidth(), gifIcon.getIconHeight());
        revalidate();
        repaint();

        setVisible(true);
        timer.start();
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