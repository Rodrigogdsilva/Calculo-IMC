package CalculoIMC;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(31, 45, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 91, 199, 71);
		panel.add(textArea);
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(335, 227, 89, 23);
		btnNewButton.addActionListener(event -> {

			List<Boolean> validacoes = new ArrayList<Boolean>();

			validacoes.add(!textField.getText().isEmpty());
			validacoes.add(textField.getText() != null);
			validacoes.add(!textField_1.getText().isEmpty());
			validacoes.add(textField_1.getText() != null);

			if (validacoes.stream().allMatch(v -> v == true)) {
				try {
					String text = TabelaIMC.calcularIMC(Double.parseDouble(textField.getText()),
							Double.parseDouble(textField_1.getText()));
					textArea.setText(text);

				} catch (NumberFormatException e) {
					textArea.setText("Digite valores válidos");
				}

			} else {
				textArea.setText("Preencha todos os campos!");

			}

		});

		panel.add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setBounds(127, 45, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Peso");
		lblNewLabel.setBounds(30, 31, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setBounds(127, 31, 46, 14);
		panel.add(lblNewLabel_1);
	}

}
