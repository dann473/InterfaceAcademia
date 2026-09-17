package view;

import javax.swing.JFrame;          
import javax.swing.JPanel;          
import javax.swing.JLabel;         
import javax.swing.JTextField;     
import javax.swing.JComboBox;       
import javax.swing.BoxLayout;      
import javax.swing.Box;           
import javax.swing.BorderFactory;   
import javax.swing.SwingConstants;  
import javax.swing.SwingUtilities;  
import java.awt.BorderLayout; 
import java.awt.FlowLayout;    
import java.awt.GridLayout;    
import java.awt.Color;         
import java.awt.Font;          
import java.awt.Dimension;     
import java.awt.Component;     

public class RegistrarAluno extends JFrame {
 
    private static final Color CINZA_CLARO  = new Color(235, 235, 235);
    private static final Color CINZA_MEDIO  = new Color(210, 210, 210);
    private static final Color CINZA_ESCURO = new Color(190, 190, 190);
 
    public RegistrarAluno() {
        super("Registrar Aluno");
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 430);                       
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);

        // Menu de navegação
        setJMenuBar(new MenuNavegacao(this, MenuNavegacao.Pagina.REGISTRAR_ALUNO));

        setLayout(new BorderLayout(10, 15));
        getContentPane().setBackground(Color.WHITE);
 
        add(criarTitulo(), BorderLayout.NORTH);
        add(criarPainelPrincipal(), BorderLayout.CENTER);
        setVisible(true);
    }
 
    private JPanel criarTitulo() {
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
        container.setBackground(Color.WHITE);
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
 
        JLabel titulo = new JLabel("Registrar Aluno", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(CINZA_CLARO);
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setPreferredSize(new Dimension(220, 40));
 
        container.add(titulo);
        return container;
    }
 
    private JPanel criarPainelPrincipal() {
        JPanel painel = new JPanel(new BorderLayout(25, 0));
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
 
        painel.add(criarFormularioAluno(), BorderLayout.WEST);
        painel.add(criarPainelPlanos(), BorderLayout.CENTER);
 
        return painel;
    }
 
    private JPanel criarFormularioAluno() {
        JPanel form = new JPanel();
        form.setBackground(Color.WHITE);
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
 
        form.add(criarCampo("Nome do  Aluno"));
        form.add(Box.createVerticalStrut(12));
        form.add(criarCampo("CPF do aluno"));
        form.add(Box.createVerticalStrut(12));
        form.add(criarCampo("CEP"));
        form.add(Box.createVerticalStrut(12));
        form.add(criarCampo("Data Nasc."));
        form.add(Box.createVerticalGlue());
        return form;
    }
 

    private JPanel criarCampo(String rotulo) {
        JPanel painel = new JPanel();
        painel.setBackground(Color.WHITE);
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setAlignmentX(Component.LEFT_ALIGNMENT);
 
        JLabel label = new JLabel(rotulo);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
 
        JTextField campo = new JTextField();
        campo.setBackground(CINZA_CLARO);
        campo.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        campo.setMaximumSize(new Dimension(220, 30));
        campo.setPreferredSize(new Dimension(220, 30));
 
        painel.add(label);
        painel.add(Box.createVerticalStrut(5));
        painel.add(campo);
 
        return painel;
    }
 
    private JPanel criarPainelPlanos() {
        JPanel painel = new JPanel(new BorderLayout(15, 15));
        painel.setBackground(CINZA_CLARO);
        painel.setBorder(BorderFactory.createEmptyBorder(15, 20, 20, 20));
 
        JLabel titulo = new JLabel("Escolha De Planos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(titulo, BorderLayout.NORTH);
 
        JPanel conteudo = new JPanel(new BorderLayout(20, 0));
        conteudo.setOpaque(false);
 
        conteudo.add(criarListaDeCombos(), BorderLayout.WEST);
        conteudo.add(criarInformacoesDoPlano(), BorderLayout.CENTER);
 
        painel.add(conteudo, BorderLayout.CENTER);
        return painel;
    }
 
    private JPanel criarListaDeCombos() {
        JPanel lista = new JPanel(new GridLayout(4, 1, 20, 20));
        lista.setOpaque(false);
 
        String[] opcoes = {"Plano 1", "Plano 2", "Plano 3", "Plano 4"};
        for (int i = 0; i < 4; i++) {
            JComboBox<String> combo = new JComboBox<>(opcoes);
            combo.setBackground(CINZA_MEDIO);
            lista.add(combo);
        }
        return lista;
    }
 
    private JPanel criarInformacoesDoPlano() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBackground(CINZA_MEDIO);
        painel.setBorder(BorderFactory.createEmptyBorder(12, 15, 15, 15));
 
        JLabel titulo = new JLabel("Informações do Plano", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 13));
        painel.add(titulo, BorderLayout.NORTH);
 
        JPanel grade = new JPanel(new GridLayout(2, 2, 50, 30));
        grade.setOpaque(false);
        grade.add(criarCelulaInfo("R$XXX"));
        grade.add(criarCelulaInfo("X"));
        grade.add(criarCelulaInfo("X"));
        grade.add(criarCelulaInfo("X"));
 
        painel.add(grade, BorderLayout.CENTER);
        return painel;
    }
 
    private JLabel criarCelulaInfo(String texto) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(CINZA_ESCURO);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        return label;
    }

}
 