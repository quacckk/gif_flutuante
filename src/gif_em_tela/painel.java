package gif_em_tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class painel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public painel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lbl_nome = new JLabel("NOME:");
		contentPane.add(lbl_nome);
		
		JLabel lbl_idade = new JLabel("IDADE:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_nome, 0, SpringLayout.WEST, lbl_idade);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_idade, 5, SpringLayout.WEST, contentPane);
		contentPane.add(lbl_idade);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_nome, 3, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_nome, -11, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 65, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -55, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -190, SpringLayout.SOUTH, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_idade, 3, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 14, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double idade = Double.parseDouble(textField_1.getText()) ;
				//quando ele está vazio ele entra nesse if, fazendo com que o usuário coloque o seu nome
				if(verificaNome(textField.getText()) || idade <18) {
					lblNewLabel.setText("Acesso inválido");
				}else {
					//cria um segunda tela
					painel02 frame = new painel02();
					frame.setVisible(true);
				}	
				
			}
		});

		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, -239, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -40, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -166, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 38, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -180, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel);
	}
	//um mêtodo que verifica que se o input está vazio
	private boolean verificaNome(String input) {
		return input.isEmpty();
	}
}
