package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	private JLabel lbUsuario, lbSenha, lbTitulo;
	private JTextField txUsuario, txSenha;
	private JButton btProsseguir;
	
	public Login() {

		setTitle("Login");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setResizable(false);

		setLayout(null);

		// Menu de navegação (permite ir direto para qualquer tela do sistema)
		setJMenuBar(new MenuNavegacao(this, MenuNavegacao.Pagina.LOGIN));

		//Título
		lbTitulo = new JLabel();
		lbTitulo.setText("Academia Angry Birds");
		lbTitulo.setBounds(280, 80, 300, 30);
		add(lbTitulo);

		//Usuário
		lbUsuario = new JLabel();
		lbUsuario.setText("Usuário:");
		lbUsuario.setBounds(280, 160, 80, 25);
		add(lbUsuario);

		txUsuario = new JTextField();
		txUsuario.setBounds(370, 160, 200, 25);
		add(txUsuario);

		//Senha
		lbSenha = new JLabel();
		lbSenha.setText("Senha:");
		lbSenha.setBounds(280, 200, 80, 25);
		add(lbSenha);

		txSenha = new JTextField();
		txSenha.setBounds(370, 200, 200, 25);
		add(txSenha);

		//Botão
		btProsseguir = new JButton();
		btProsseguir.setText("Prosseguir");
		btProsseguir.setBounds(320, 260, 130, 35);
		btProsseguir.addActionListener(e -> {
			// (validação de usuário/senha pode ser adicionada aqui futuramente)
			dispose();
			new ListaAlunos();
		});
		add(btProsseguir);

		setVisible(true);
	}
	
}