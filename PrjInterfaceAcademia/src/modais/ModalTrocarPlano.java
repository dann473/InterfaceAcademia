package modais;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.io.File;

public class ModalTrocarPlano extends JDialog {

	private static final Color CINZA_CLARO = new Color(238, 238, 238);

	public ModalTrocarPlano(JFrame parent, String nomeAluno) {
		super(parent, "Trocar plano - " + nomeAluno, true);

		setSize(700, 530);
		setLocationRelativeTo(parent);
		setResizable(false);

		JPanel mainPanel = new JPanel(new BorderLayout(20, 15));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

		// Superior
		JLabel lblTitulo = new JLabel("Escolher plano novo", SwingConstants.CENTER);
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(CINZA_CLARO);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTitulo.setPreferredSize(new Dimension(320, 50));

		JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.add(lblTitulo);

		// Conteúdo Central
		JPanel painelCorpo = new JPanel(new GridBagLayout());
		painelCorpo.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;

		// Esquerda
		JPanel painelEsquerda = new JPanel();
		painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
		painelEsquerda.setBackground(Color.WHITE);

		JButton btnPlano1 = criarBotaoPlano("Opção plano 1");
		JButton btnPlano2 = criarBotaoPlano("Opção plano 2");

		// Bloco esquerdo Inferior
		JPanel painelPlanoAtual = new JPanel(new BorderLayout(10, 0));
		painelPlanoAtual.setBackground(CINZA_CLARO);
		painelPlanoAtual.setMaximumSize(new Dimension(300, 48));
		painelPlanoAtual.setPreferredSize(new Dimension(300, 48));
		painelPlanoAtual.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
		painelPlanoAtual.setAlignmentX(Component.LEFT_ALIGNMENT);

		JLabel lblPlanoAtual = new JLabel("Plano atual");
		lblPlanoAtual.setFont(new Font("Segoe UI", Font.BOLD, 16));

		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setFont(new Font("Segoe UI", Font.PLAIN, 13));

		painelPlanoAtual.add(lblPlanoAtual, BorderLayout.WEST);
		painelPlanoAtual.add(lblValidade, BorderLayout.EAST);

		painelEsquerda.add(btnPlano1);
		painelEsquerda.add(Box.createVerticalStrut(15));
		painelEsquerda.add(btnPlano2);
		painelEsquerda.add(Box.createVerticalStrut(40));
		painelEsquerda.add(painelPlanoAtual);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.55;
		gbc.weighty = 1.0;
		painelCorpo.add(painelEsquerda, gbc);

		// Direita
		JPanel painelDireita = new JPanel();
		painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
		painelDireita.setBackground(Color.WHITE);

		// conexão com pasta resources
		PainelCirculoImagem painelImagem = new PainelCirculoImagem("resources/ma dim.jpeg");
		painelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Botão prosseguir
		JButton btnProsseguir = new JButton("<html><center>Prosseguir para<br>pagamento</center></html>");
		btnProsseguir.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnProsseguir.setBackground(CINZA_CLARO);
		btnProsseguir.setFocusPainted(false);
		btnProsseguir.setBorder(BorderFactory.createEmptyBorder());
		btnProsseguir.setMaximumSize(new Dimension(220, 52));
		btnProsseguir.setPreferredSize(new Dimension(220, 52));
		btnProsseguir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnProsseguir.addActionListener(e -> dispose());

		painelDireita.add(painelImagem);
		painelDireita.add(Box.createVerticalStrut(20));
		painelDireita.add(btnProsseguir);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.45;
		gbc.weighty = 1.0;
		painelCorpo.add(painelDireita, gbc);

		mainPanel.add(painelTitulo, BorderLayout.NORTH);
		mainPanel.add(painelCorpo, BorderLayout.CENTER);

		add(mainPanel);
	}

	private JButton criarBotaoPlano(String texto) {
		JButton btn = new JButton(texto);
		btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn.setBackground(CINZA_CLARO);
		btn.setFocusPainted(false);
		btn.setMaximumSize(new Dimension(300, 50));
		btn.setPreferredSize(new Dimension(300, 50));
		btn.setAlignmentX(Component.LEFT_ALIGNMENT);
		return btn;
	}

	// Recorta a imagem em formato circular
    private static class PainelCirculoImagem extends JPanel {
        private Image imagem;

        public PainelCirculoImagem(String caminhoImagem) {
            setPreferredSize(new Dimension(180, 180));
            setMaximumSize(new Dimension(180, 180));
            setOpaque(false);

            // Carregar pela pasta de recursos
            java.net.URL url = getClass().getClassLoader().getResource(caminhoImagem);
            
            if (url != null) {
                this.imagem = new ImageIcon(url).getImage();
            } else {
                this.imagem = new ImageIcon("src/" + caminhoImagem).getImage();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int size = getWidth();

            // Recorta a área em círculo e desenha a imagem
            g2.setClip(new Ellipse2D.Float(0, 0, size, size));
            
            if (imagem != null) {
                g2.drawImage(imagem, 0, 0, size, size, this);
            }

            g2.dispose();
        }
    }
}