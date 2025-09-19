package gif_em_tela;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SpringLayout;

public class painel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JLabel lblStatus;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    painel frame = new painel();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public painel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        SpringLayout sl_contentPane = new SpringLayout();
        contentPane.setLayout(sl_contentPane);

        JLabel lbl_nome = new JLabel("NOME:");
        sl_contentPane.putConstraint(SpringLayout.WEST, lbl_nome, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_nome, 50, SpringLayout.NORTH, contentPane);
        contentPane.add(lbl_nome);

        textFieldNome = new JTextField();
        sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldNome, 45, SpringLayout.NORTH, contentPane);
        sl_contentPane.putConstraint(SpringLayout.WEST, textFieldNome, 70, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.EAST, textFieldNome, -50, SpringLayout.EAST, contentPane);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        JLabel lbl_idade = new JLabel("IDADE:");
        sl_contentPane.putConstraint(SpringLayout.WEST, lbl_idade, 10, SpringLayout.WEST, contentPane);
        sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_idade, 15, SpringLayout.SOUTH, lbl_nome);
        contentPane.add(lbl_idade);

        textFieldIdade = new JTextField();
        sl_contentPane.putConstraint(SpringLayout.NORTH, textFieldIdade, 10, SpringLayout.SOUTH, textFieldNome);
        sl_contentPane.putConstraint(SpringLayout.WEST, textFieldIdade, 0, SpringLayout.WEST, textFieldNome);
        sl_contentPane.putConstraint(SpringLayout.EAST, textFieldIdade, 0, SpringLayout.EAST, textFieldNome);
        contentPane.add(textFieldIdade);
        textFieldIdade.setColumns(10);

        JButton btnEntrar = new JButton("ENTRAR");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double idade = Double.parseDouble(textFieldIdade.getText());
                    if (textFieldNome.getText().isEmpty() || idade < 18) {
                        lblStatus.setText("Acesso inválido: Nome vazio ou idade menor que 18.");
                    } else {
                        // Fecha a janela atual e abre a tela principal (Main)
                        dispose();
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                new Main();
                            }
                        });
                    }
                } catch (NumberFormatException ex) {
                    lblStatus.setText("Erro: Digite uma idade válida.");
                }
            }
        });
        sl_contentPane.putConstraint(SpringLayout.NORTH, btnEntrar, 30, SpringLayout.SOUTH, textFieldIdade);
        sl_contentPane.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnEntrar, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        contentPane.add(btnEntrar);

        lblStatus = new JLabel("");
        sl_contentPane.putConstraint(SpringLayout.NORTH, lblStatus, 15, SpringLayout.SOUTH, btnEntrar);
        sl_contentPane.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblStatus, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        contentPane.add(lblStatus);
    }
}