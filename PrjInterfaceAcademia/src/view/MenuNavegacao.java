package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class MenuNavegacao extends JMenuBar {

    public enum Pagina {
        LOGIN, ALUNOS, REGISTRAR_ALUNO, FUNCIONARIOS, DESENVOLVEDORES
    }

    // Interface funcional simples usada para "fabricar" a tela de destino
    // somente no momento do clique (evita criar todas as telas de uma vez).
    private interface FabricaTela {
        JFrame criar();
    }

    public MenuNavegacao(JFrame frameAtual, Pagina paginaAtual) {

        JMenu menuNavegar = new JMenu("Navegar");

        JMenuItem itemAlunos = new JMenuItem("Lista de Alunos");
        itemAlunos.setEnabled(paginaAtual != Pagina.ALUNOS);
        itemAlunos.addActionListener(e -> irPara(frameAtual, () -> new ListaAlunos()));

        JMenuItem itemRegistrarAluno = new JMenuItem("Registrar Aluno");
        itemRegistrarAluno.setEnabled(paginaAtual != Pagina.REGISTRAR_ALUNO);
        itemRegistrarAluno.addActionListener(e -> irPara(frameAtual, () -> new RegistrarAluno()));

        JMenuItem itemFuncionarios = new JMenuItem("Lista de Funcionários");
        itemFuncionarios.setEnabled(paginaAtual != Pagina.FUNCIONARIOS);
        itemFuncionarios.addActionListener(e -> irPara(frameAtual, () -> new ListaFuncionarios()));

        JMenuItem itemDesenvolvedores = new JMenuItem("Desenvolvedores");
        itemDesenvolvedores.setEnabled(paginaAtual != Pagina.DESENVOLVEDORES);
        itemDesenvolvedores.addActionListener(e -> irPara(frameAtual, () -> new Desenvolvedores()));

        menuNavegar.add(itemAlunos);
        menuNavegar.add(itemRegistrarAluno);
        menuNavegar.add(itemFuncionarios);
        menuNavegar.add(itemDesenvolvedores);
        menuNavegar.addSeparator();

        JMenuItem itemLogout = new JMenuItem("Sair (voltar ao Login)");
        itemLogout.setEnabled(paginaAtual != Pagina.LOGIN);
        itemLogout.addActionListener(e -> irPara(frameAtual, () -> new Login()));
        menuNavegar.add(itemLogout);

        JMenuItem itemFechar = new JMenuItem("Fechar sistema");
        itemFechar.addActionListener(e -> {
            int opcao = JOptionPane.showConfirmDialog(
                    frameAtual,
                    "Deseja realmente fechar o sistema?",
                    "Fechar sistema",
                    JOptionPane.YES_NO_OPTION
            );
            if (opcao == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        menuNavegar.add(itemFechar);

        add(menuNavegar);
    }

    private void irPara(JFrame frameAtual, FabricaTela fabrica) {
        frameAtual.dispose();
        fabrica.criar();
    }
}
