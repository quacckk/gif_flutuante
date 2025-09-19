package gif_em_tela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class Main {

    private GifManager gifManager = new GifManager();

    public Main() {
        JFrame frame = new JFrame("Controle de Múltiplos GIFs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Controle os GIFs Flutuantes");
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        frame.add(Box.createVerticalStrut(15));
        frame.add(titleLabel);

        JButton openFileButton = new JButton("Adicionar Novo GIF");
        openFileButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
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
                    // Continua usando o método antigo para arquivos locais
                    gifManager.adicionarGif(selectedFile.getAbsolutePath());
                }
            }
        });

        JButton defaultGifButton = new JButton("Adicionar GIF Padrão");
        defaultGifButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        defaultGifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tenta carregar o recurso usando ClassLoader
                URL gifUrl = Main.class.getResource("/img/olha ali.gif");
                if (gifUrl != null) {
                    // Passa a URL diretamente para o GifManager
                    gifManager.adicionarGifPadrao(gifUrl);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: Arquivo padrão não encontrado. Verifique se ele está na pasta 'img' na raiz do seu projeto.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton stopAllButton = new JButton("Parar Todos os GIFs");
        stopAllButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        stopAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gifManager.pararTodos();
            }
        });

        JButton speedUpButton = new JButton("Aumentar Velocidade");
        speedUpButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        speedUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gifManager.aumentarVelocidade();
            }
        });

        JButton slowDownButton = new JButton("Diminuir Velocidade");
        slowDownButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        slowDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gifManager.diminuirVelocidade();
            }
        });

        JButton exitButton = new JButton("Fechar");
        exitButton.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gifManager.fecharTodosGifs();
                frame.dispose();
            }
        });

        frame.add(Box.createVerticalStrut(10));
        frame.add(openFileButton);
        frame.add(Box.createVerticalStrut(10));
        frame.add(defaultGifButton);
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
                new painel();
            }
        });
    }
}