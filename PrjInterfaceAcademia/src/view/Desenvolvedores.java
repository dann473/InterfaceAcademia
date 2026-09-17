package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Desenvolvedores extends JFrame {

    // Pasta onde ficam as fotos
    private static final String PASTA_FOTOS = "resources/";

    public Desenvolvedores() {

        

        // Configurações da janela
        setSize(700, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Menu de navegação
        setJMenuBar(new MenuNavegacao(this, MenuNavegacao.Pagina.DESENVOLVEDORES));

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBackground(Color.WHITE);

        painelPrincipal.setBorder(
            BorderFactory.createLineBorder(
                new Color(30, 136, 199), 
                6
            )
        );

        setContentPane(painelPrincipal);

        //título

        JLabel lbTitulo = new JLabel("Desenvolvedores");

        lbTitulo.setFont(
            new Font("Serif", Font.PLAIN, 26)
        );

        lbTitulo.setOpaque(true);

        lbTitulo.setBackground(
            new Color(220, 220, 220)
        );

        lbTitulo.setBorder(
            BorderFactory.createEmptyBorder(
                0, 25, 0, 0
            )
        );

        lbTitulo.setBounds(
            175, 45, 350, 70
        );

        painelPrincipal.add(lbTitulo);

       //nomes
        String[] nomes = {
            "Enzo Henrique",
            "Gabriel Santos",
            "João V. Meneghetti",
            "Lucas Daniel",
            "Raul Barbosa"
        };

      //fotos

        String[] fotos = {
            "azul.jpg",
            "bomba.jpg",
            "porco.jpg",
            "red.jpg",
            "amarelo.jpg"
        };

       //avatares das respectivas fotos

        int tamanhoCirculo = 90;
        int margemLateral = 40;
        int quantidade = nomes.length;

        int espacoDisponivel =
            700
            - (2 * margemLateral)
            - (quantidade * tamanhoCirculo);

        int gap =
            espacoDisponivel / (quantidade - 1);

        int y = 160;

      //criando avatares

        for (int i = 0; i < quantidade; i++) {

            int x =
                margemLateral
                + i * (tamanhoCirculo + gap);

            // Carrega a imagem
            BufferedImage imagem =
                carregarImagem(
                    PASTA_FOTOS + fotos[i]
                );

            // Avatar (imagem em círculo) fica acima do nome
            AvatarCircular avatar =
                new AvatarCircular(imagem);

            avatar.setBounds(
                x,
                y,
                tamanhoCirculo,
                tamanhoCirculo
            );

            painelPrincipal.add(avatar);

            // Nome do desenvolvedor
            JLabel lbNome =
                new JLabel(
                    nomes[i],
                    SwingConstants.CENTER
                );

            lbNome.setFont(
                new Font(
                    "Serif",
                    Font.PLAIN,
                    13
                )
            );

            lbNome.setBounds(
                x - 20,
                y + tamanhoCirculo + 10,
                tamanhoCirculo + 40,
                20
            );

            painelPrincipal.add(lbNome);
            setVisible(true);
        }
    }

   //método para carregamento das imagens

    private BufferedImage carregarImagem(String caminho) {

        try {

            return ImageIO.read(
                new File(caminho)
            );

        } catch (IOException e) {

            System.out.println(
                "Não foi possível carregar a imagem: "
                + caminho
            );

            return null;
        }
    }


    // Desenha a imagem recortada em formato de círculo.
    // Se a imagem não for encontrada  desenha um círculo cinza no lugar, para não quebrar o layout.
    private static class AvatarCircular extends JComponent {

        private final BufferedImage imagem;

        AvatarCircular(BufferedImage imagem) {
            this.imagem = imagem;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            int diametro = Math.min(getWidth(), getHeight());
            Ellipse2D.Double circulo =
                new Ellipse2D.Double(0, 0, diametro, diametro);

            g2.setClip(circulo);

            if (imagem != null) {
                // Desenha a imagem preenchendo todo o círculo
                g2.drawImage(imagem, 0, 0, diametro, diametro, this);
            } else {
                g2.setColor(new Color(216, 216, 216));
                g2.fill(circulo);
            }

            g2.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(90, 90);
            
            
            
        }
        
        
    }
    
}
    

   

               
    
