package gif_em_tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main {
    private List<gifAtivar> gifs = new ArrayList<>();
    private int velocidadeAtual = 10;

    public Main() {
        JFrame frame = new JFrame("Controle de Múltiplos GIFs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Controle os GIFs Flutuantes");
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        frame.add(Box.createVerticalStrut(15));
        frame.add(titleLabel);

        // Botão para abrir o seletor de arquivo e adicionar um novo GIF
        JButton openFileButton = new JButton("Adicionar Novo GIF");
        openFileButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                
                // Filtra para exibir apenas arquivos .gif
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File f) {
                        return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                    }
                    public String getDescription() {
                        return "Arquivos GIF (*.gif)";
                    }
                });

                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    gifAtivar novoGif = new gifAtivar(selectedFile.getAbsolutePath());
                    novoGif.ajustarVelocidade(velocidadeAtual);
                    gifs.add(novoGif);
                }
            }
        });

        // Botão para parar TODOS os GIFs
        JButton stopAllButton = new JButton("Parar Todos os GIFs");
        stopAllButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        stopAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (gifAtivar gif : gifs) {
                    gif.pararExecucao();
                }
                gifs.clear();
            }
        });
        
        // Botões de controle de velocidade
        JButton speedUpButton = new JButton("Aumentar Velocidade");
        speedUpButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        speedUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                velocidadeAtual = Math.max(1, velocidadeAtual - 5);
                for (gifAtivar gif : gifs) {
                    gif.ajustarVelocidade(velocidadeAtual);
                }
            }
        });

        JButton slowDownButton = new JButton("Diminuir Velocidade");
        slowDownButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        slowDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                velocidadeAtual += 5;
                for (gifAtivar gif : gifs) {
                    gif.ajustarVelocidade(velocidadeAtual);
                }
            }
        });
        
        JButton exitButton = new JButton("Fechar");
        exitButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (gifAtivar gif : gifs) {
                    gif.dispose();
                }
                frame.dispose();
            }
        });

        frame.add(Box.createVerticalStrut(10));
        frame.add(openFileButton);
        frame.add(Box.createVerticalStrut(10));
        frame.add(speedUpButton);
        frame.add(Box.createVerticalStrut(10));
        frame.add(slowDownButton);
        frame.add(Box.createVerticalStrut(10));
        frame.add(stopAllButton);
        frame.add(Box.createVerticalStrut(10));
        frame.add(exitButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}

