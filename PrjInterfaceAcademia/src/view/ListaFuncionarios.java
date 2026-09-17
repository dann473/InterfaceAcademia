package view;

import javax.swing.*;
import java.awt.*;

public class ListaFuncionarios extends JFrame {

    private JPanel painelFuncionarios;

    public ListaFuncionarios () {

        setTitle("Lista de Funcionários");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu de navegação
        setJMenuBar(new MenuNavegacao(this, MenuNavegacao.Pagina.FUNCIONARIOS));

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(Color.WHITE);

        JPanel painelTopo = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        painelTopo.setBackground(Color.WHITE);

        JButton btnInformacoes = new JButton("📄  mais informações");
        JButton btnLista = new JButton("Lista De funcionários");

        btnInformacoes.setFont(new Font("Arial", Font.BOLD, 20));
        btnLista.setFont(new Font("Arial", Font.BOLD, 20));

        btnLista.setBackground(new Color(220, 220, 220));

        painelTopo.add(btnInformacoes);
        painelTopo.add(btnLista);

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);


        painelFuncionarios = new JPanel();
        painelFuncionarios.setLayout(new BoxLayout(painelFuncionarios, BoxLayout.Y_AXIS));
        painelFuncionarios.setBackground(Color.WHITE);

        adicionarFuncionario("Funcionario1");
        adicionarFuncionario("Funcionario2");
        adicionarFuncionario("Funcionario3");
        adicionarFuncionario("Funcionario4");
        adicionarFuncionario("Funcionario5");
        adicionarFuncionario("Funcionario6");

        JScrollPane scroll = new JScrollPane(painelFuncionarios);
        scroll.setBorder(null);

        painelPrincipal.add(scroll, BorderLayout.CENTER);


        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBackground(Color.WHITE);

        JButton btnAdicionar = new JButton(
                "<html><center>Adicionar novo<br>funcionario</center></html>"
        );


        btnAdicionar.setFont(new Font("Arial", Font.BOLD, 20));

        btnAdicionar.setPreferredSize(new Dimension(320, 70));

        btnAdicionar.setMaximumSize(new Dimension(320, 70));

        btnAdicionar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnAdicionar.setBackground(new Color(220, 220, 220));

        painelBotoes.add(Box.createVerticalGlue());
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(Box.createVerticalStrut(25));
        painelBotoes.add(Box.createVerticalGlue());

        painelPrincipal.add(painelBotoes, BorderLayout.EAST);


        btnAdicionar.addActionListener(e -> adicionarNovoFuncionario());


        btnInformacoes.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Sistema de gerenciamento de funcionários"
                )
        );

        add(painelPrincipal);
        setVisible(true);
    }


    private void adicionarFuncionario(String nome) {

        JPanel funcionario = new JPanel(new BorderLayout());
        funcionario.setBackground(new Color(220, 220, 220));

        funcionario.setMaximumSize(new Dimension(500, 55));
        funcionario.setPreferredSize(new Dimension(500, 55));

        JLabel labelNome = new JLabel(nome);
        labelNome.setFont(new Font("Arial", Font.BOLD, 20));

        JButton btnDetalhes = new JButton("📄");
        btnDetalhes.setFont(new Font("Arial", Font.PLAIN, 20));

        funcionario.add(labelNome, BorderLayout.WEST);
        funcionario.add(btnDetalhes, BorderLayout.EAST);

        funcionario.setBorder(
                BorderFactory.createEmptyBorder(5, 15, 5, 5)
        );

        painelFuncionarios.add(funcionario);
        painelFuncionarios.add(Box.createVerticalStrut(10));

        painelFuncionarios.revalidate();
        painelFuncionarios.repaint();
    }


    private void adicionarNovoFuncionario() {

        String nome = JOptionPane.showInputDialog(
                this,
                "Digite o nome do funcionário:"
        );

        if (nome != null && !nome.trim().isEmpty()) {
            adicionarFuncionario(nome);
        }
    }
}
