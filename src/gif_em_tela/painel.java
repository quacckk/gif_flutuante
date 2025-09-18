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
import javax.swing.JScrollBar;

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
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_nome, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbl_nome, -143, SpringLayout.SOUTH, contentPane);
		contentPane.add(lbl_nome);
		
		JLabel lbl_idade = new JLabel("IDADE:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbl_idade, 138, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbl_idade, 5, SpringLayout.WEST, contentPane);
		contentPane.add(lbl_idade);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 91, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbl_nome, -11, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 65, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 135, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 25, SpringLayout.EAST, lbl_idade);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -55, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textField_1);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTRAR");
		
				sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, -260, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -161, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double idade = Double.parseDouble(textField_1.getText()) ;
					//quando ele está vazio ele entra nesse if, fazendo com que o usuário coloque o seu nome
					if(textField.getText().isEmpty() || idade <18) {
						lblNewLabel.setText("Acesso inválido");
					}else {
						//cria um segunda tela
						painel02 frame = new painel02();
						frame.setVisible(true);
						
					}	
				}catch (NumberFormatException ex) {
                    lblNewLabel.setText("Erro: Digite uma idade válida.");
                }
				
			}
		});
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 13, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 74, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -69, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -55, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 11, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bem vindo ao gif creator");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, -144, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Primeiro faça o login para depois acessar o painel de controle ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, textField);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 13, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 188, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);
	}
	//um mêtodo que verifica que se o input está vazio
}
