package gif_em_tela;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class painel02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
    private List<gifAtivar> gifs = new ArrayList<>();
    private int velocidadeAtual = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					painel02 frame = new painel02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public painel02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar GIF");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 119, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -441, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String diretorio = textField.getText();
				SwingUtilities.invokeLater(()-> new gifAtivar(diretorio));
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Caminho do gif:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 27, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 269, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 48, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 44, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, btnNewButton);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Copie e cole o caminho do gif abaixo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -86, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Parar gif");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (gifAtivar gif : gifs) {
                    gif.pararExecucao();
                }
                gifs.clear();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Aumentar velocidade");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 9, SpringLayout.EAST, btnNewButton_1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velocidadeAtual = Math.max(1, velocidadeAtual - 5);
                for (gifAtivar gif : gifs) {
                    gif.ajustarVelocidade(velocidadeAtual);
                }
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Diminuir velocidade");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, -6, SpringLayout.WEST, btnNewButton_3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 389, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, contentPane);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velocidadeAtual += 5;
                for (gifAtivar gif : gifs) {
                    gif.ajustarVelocidade(velocidadeAtual);
                }
			}
		});
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Escolha um botão");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 1, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 246, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -149, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E inicie uma operação");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, -227, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_4 = new JButton("Voltar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (gifAtivar gif : gifs) {
                    gif.dispose();
                }
                dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_4, -22, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNewButton_4);
	}
}
