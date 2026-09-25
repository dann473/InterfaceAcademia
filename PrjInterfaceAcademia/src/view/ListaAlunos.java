package view;

import view.modais.ModalRenovarPlano;
import view.modais.ModalTrocarPlano;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Image;

public class ListaAlunos extends JFrame {

    private static final Color CINZA_CLARO = new Color(238, 238, 238);
    private static final Color CINZA_MEDIO = new Color(215, 215, 215);

    // Carregar arquivos PNG da pasta resources
    private Icon iconTrocar    = carregarIcone("icone_trocar.png");
    private Icon iconRenovar   = carregarIcone("icone_renovar.png");
    private Icon iconBloqueado = carregarIcone("icone_bloqueado.png");

    public ListaAlunos() {
        super("Lista de alunos");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1024, 600));

        // Menu de navegação
        setJMenuBar(new MenuNavegacao(this, MenuNavegacao.Pagina.ALUNOS));

        setLayout(new BorderLayout(20, 20));
        getContentPane().setBackground(Color.WHITE);

        add(criarTopo(), BorderLayout.NORTH);
        add(criarPainelCentral(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel criarTopo() {
        JPanel topo = new JPanel(new BorderLayout());
        topo.setBackground(Color.WHITE);
        topo.setBorder(BorderFactory.createEmptyBorder(20, 50, 10, 50));

        // Legenda de Ícones
        JPanel legenda = new JPanel();
        legenda.setLayout(new BoxLayout(legenda, BoxLayout.Y_AXIS));
        legenda.setBackground(Color.WHITE);

        legenda.add(criarItemLegenda(iconTrocar, "Trocar plano"));
        legenda.add(Box.createVerticalStrut(8));
        legenda.add(criarItemLegenda(iconRenovar, "Renovar plano"));
        legenda.add(Box.createVerticalStrut(8));
        legenda.add(criarItemLegenda(iconBloqueado, "Aluno bloqueado por pendecia"));

        // Título Centralizado
        JLabel titulo = new JLabel("Lista De alunos", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(CINZA_CLARO);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setPreferredSize(new Dimension(320, 55));

        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        painelTitulo.setBackground(Color.WHITE);
        painelTitulo.add(titulo);

        topo.add(legenda, BorderLayout.WEST);
        topo.add(painelTitulo, BorderLayout.CENTER);

        return topo;
    }

    private JPanel criarItemLegenda(Icon icone, String texto) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        item.setBackground(Color.WHITE);

        JLabel lblIcone = new JLabel(icone);
        JLabel lblTexto = new JLabel(texto);
        lblTexto.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        item.add(lblIcone);
        item.add(lblTexto);
        return item;
    }

    private JPanel criarPainelCentral() {
        JPanel containerGeral = new JPanel(new GridBagLayout());
        containerGeral.setBackground(Color.WHITE);

        JPanel painelConteudo = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 20));
        painelConteudo.setBackground(Color.WHITE);

        painelConteudo.add(criarListaAlunosContainer());
        painelConteudo.add(criarPainelBotoesAcao());

        containerGeral.add(painelConteudo);
        return containerGeral;
    }

    private JScrollPane criarListaAlunosContainer() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.WHITE);

        boolean[] possuiPendencia = {true, false, false, false, false, false, false, false};

        for (int i = 0; i < possuiPendencia.length; i++) {
            container.add(criarLinhaAluno("Aluno " + (i + 1), possuiPendencia[i]));
            container.add(Box.createVerticalStrut(12));
        }

        JScrollPane scroll = new JScrollPane(container);
        scroll.setBorder(null);
        scroll.setBackground(Color.WHITE);
        scroll.setPreferredSize(new Dimension(650, 520));

        return scroll;
    }

    private JPanel criarLinhaAluno(String nomeAluno, boolean bloqueado) {
        JPanel linha = new JPanel(new BorderLayout(15, 0));
        linha.setBackground(CINZA_CLARO);
        linha.setMaximumSize(new Dimension(620, 52));
        linha.setPreferredSize(new Dimension(620, 52));
        linha.setAlignmentX(Component.LEFT_ALIGNMENT);
        linha.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 10));

        JLabel lblNome = new JLabel(nomeAluno);
        lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JPanel painelIcones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 6));
        painelIcones.setOpaque(false);

        if (bloqueado) {
            JButton btnBloqueado = criarBotaoIcone(iconBloqueado);
            painelIcones.add(btnBloqueado);
        }

        // Botão renovar (Abre ModalRenovarPlano)
        JButton btnRenovar = criarBotaoIcone(iconRenovar);
        btnRenovar.addActionListener(e -> {
            ModalRenovarPlano modal = new ModalRenovarPlano(this, nomeAluno);
            modal.setVisible(true);
        });

        // Botão trocar (Abre ModalTrocarPlano)
        JButton btnTrocar = criarBotaoIcone(iconTrocar);
        btnTrocar.addActionListener(e -> {
            ModalTrocarPlano modal = new ModalTrocarPlano(this, nomeAluno);
            modal.setVisible(true);
        });

        painelIcones.add(btnRenovar);
        painelIcones.add(btnTrocar);

        linha.add(lblNome, BorderLayout.WEST);
        linha.add(painelIcones, BorderLayout.EAST);

        return linha;
    }

    private JButton criarBotaoIcone(Icon icone) {
        JButton btn = new JButton(icone);
        btn.setPreferredSize(new Dimension(40, 38));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setBackground(CINZA_MEDIO);
        return btn;
    }

    private JPanel criarPainelBotoesAcao() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(Color.WHITE);

        JButton btAdicionar = criarBotaoAcao("<html><center>Adicionar novo<br>aluno</center></html>");
        btAdicionar.addActionListener(e -> {
            dispose();
            new RegistrarAluno();
        });

        JButton btExcluir = criarBotaoAcao("Excluir aluno");

        painel.add(btAdicionar);
        painel.add(Box.createVerticalStrut(25));
        painel.add(btExcluir);

        return painel;
    }

    private JButton criarBotaoAcao(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        btn.setBackground(CINZA_CLARO);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(260, 68));
        btn.setPreferredSize(new Dimension(260, 68));
        return btn;
    }

    // Carregar e redimensionar os ícones PNG
    private Icon carregarIcone(String nomeArquivo) {
        String caminho = "resources/" + nomeArquivo;
        java.net.URL url = getClass().getClassLoader().getResource(caminho);
        
        if (url == null) {
            url = getClass().getResource("/" + caminho);
        }

        if (url != null) {
            ImageIcon iconOriginal = new ImageIcon(url);
            Image imgRedimensionada = iconOriginal.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
            return new ImageIcon(imgRedimensionada);
        }

        System.err.println("Erro ao carregar ícone: " + nomeArquivo);
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListaAlunos();
        });
    }
}