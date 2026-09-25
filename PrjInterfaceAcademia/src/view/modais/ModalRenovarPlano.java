package view.modais;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class ModalRenovarPlano extends JDialog {

    private static final Color CINZA_CLARO = new Color(238, 238, 238);

    public ModalRenovarPlano(JFrame parent, String nomeAluno) {
        super(parent, "Renovar plano - " + nomeAluno, true);

        setSize(680, 520);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        // Superior
        JLabel lblTitulo = new JLabel("Renovar plano", SwingConstants.CENTER);
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(CINZA_CLARO);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setPreferredSize(new Dimension(280, 50));

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

        painelEsquerda.add(criarBotaoOpcao("Op��o de pagamento 1"));
        painelEsquerda.add(Box.createVerticalStrut(15));
        painelEsquerda.add(criarBotaoOpcao("Op��o de pagamento 2"));
        painelEsquerda.add(Box.createVerticalStrut(35));
        painelEsquerda.add(criarBotaoOpcao("Validade"));

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 0.55; gbc.weighty = 1.0;
        painelCorpo.add(painelEsquerda, gbc);

        // Direita
        JPanel painelDireita = new JPanel();
        painelDireita.setBackground(CINZA_CLARO);
        painelDireita.setLayout(new BoxLayout(painelDireita, BoxLayout.Y_AXIS));
        painelDireita.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblValorTexto = new JLabel("Valor a pagar:");
        lblValorTexto.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblValorTexto.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblValor = new JLabel("R$ 250,55");
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblValor.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblParcelar = new JLabel("Parcelar em:");
        lblParcelar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblParcelar.setAlignmentX(Component.LEFT_ALIGNMENT);

        String[] parcelas = {"2 Vezes", "4 Vezes", "6 Vezes", "À vista"};
        JComboBox<String> comboParcelas = new JComboBox<>(parcelas);
        comboParcelas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        comboParcelas.setMaximumSize(new Dimension(180, 38));
        comboParcelas.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboParcelas.setBackground(Color.WHITE);

        painelDireita.add(lblValorTexto);
        painelDireita.add(Box.createVerticalStrut(5));
        painelDireita.add(lblValor);
        painelDireita.add(Box.createVerticalStrut(30));
        painelDireita.add(lblParcelar);
        painelDireita.add(Box.createVerticalStrut(8));
        painelDireita.add(comboParcelas);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 0.45; gbc.weighty = 1.0;
        painelCorpo.add(painelDireita, gbc);

        // Rodapé
        JButton btnFinalizar = new JButton("Finalizar renova��o");
        btnFinalizar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btnFinalizar.setBackground(CINZA_CLARO);
        btnFinalizar.setFocusPainted(false);
        btnFinalizar.setPreferredSize(new Dimension(240, 52));
        btnFinalizar.addActionListener(e -> dispose());

        JPanel painelRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelRodape.setBackground(Color.WHITE);
        painelRodape.add(btnFinalizar);

        mainPanel.add(painelTitulo, BorderLayout.NORTH);
        mainPanel.add(painelCorpo, BorderLayout.CENTER);
        mainPanel.add(painelRodape, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JButton criarBotaoOpcao(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn.setBackground(CINZA_CLARO);
        btn.setFocusPainted(false);
        btn.setMaximumSize(new Dimension(220, 50));
        btn.setPreferredSize(new Dimension(220, 50));
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        return btn;
    }
}