
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Tela de Login (exemplo da aula de Interfaces Gráficas)
 * 
 * @author Julio
 */
public class TelaLogin {
    // janela que representa a Tela de Login
    private JFrame janela;
    // caixa de texto para o login
    private JTextField caixaLogin;
    // caixa de texto para a senha
    private JPasswordField caixaSenha;
    // botão de Login
    private JButton botaoLogin;
    // botão de Ajuda
    private JButton botaoAjuda;
    // item de menu de ajuda
    private JMenuItem itemMenuAjuda;
    // áreas de texto usadas para testar eventos de mouse
    private JTextArea areaDesenho;
    private JTextArea areaTexto;
    
    /**
     * Cria a janela da Tela de Login
     */
    public TelaLogin() {
        // cria os componentes da janela
        criarComponentes();        

        // monta o menu da janela
        montarMenu();
        
        // trata a inscrição em eventos
        tratarEventos();
        
        // monta a janela
        montarJanela();
    }
    
    /**
     * Exibe a Tela de Login
     */
    public void exibir() {
        // exibe a janela
        janela.setVisible(true);
    }    

    /**
     * Cria os componentes da tela
     */
    private void criarComponentes() {
        // cria uma janela e define seu título
        janela = new JFrame("Tela de Login");
        // cria as caixas de texto de login e senha
        caixaLogin = new JTextField();
        caixaSenha = new JPasswordField();
        // cria os botões para efetuar o login e pedir ajuda
        botaoLogin = new JButton("Entrar");
        botaoAjuda = new JButton("Ajuda");
        areaDesenho = new JTextArea();
        areaTexto = new JTextArea();
    }
    
    /**
     * Monta o menu da Janela
     */
    private void montarMenu() {
        // cria a barra de menu, o menu e o item de menu
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuOpcoes = new JMenu("Opções");
        itemMenuAjuda = new JMenuItem("Ajuda");
        
        // adiciona o item de menu ao menu, e o menu à barra
        menuOpcoes.add(itemMenuAjuda);
        barraMenu.add(menuOpcoes);
        // define a barra de menu para a janela
        janela.setJMenuBar(barraMenu);
    }

    /**
     * Trata a inscrição nos eventos de clique e de mouse
     */
    private void tratarEventos() {
        // tratamento dos eventos sendo feitos através de classes anônimas
        
        // tratando clique do botão login
        botaoLogin.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        logar();
                    }
                });
        
        // tratando clique do botão ajuda
        botaoAjuda.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        exibirAjuda();
                    }
                });
        
        // tratando clique do item de menu ajuda
        itemMenuAjuda.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    exibirAjuda();
                }
            });
        
        // tratando eventos de mouse da área de desenho
        areaDesenho.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        areaTexto.append("clicou\n");
                    }
                    
                    @Override
                    public void mousePressed(MouseEvent e) {
                        areaTexto.append("começou clique\n");
                    }
                    
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        areaTexto.append("terminou clique\n");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        areaTexto.append("entrou\n");
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent e) {
                        areaTexto.append("saiu\n");
                    }
                });
    }
    
    /**
     * Monta a janela (define tamanho, layout, coloca os componentes, etc.)
     */
    private void montarJanela() {
        // define que ao fechar a janela, a aplicação será fechada
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // define o tamanho da janela (largura, altura)
        janela.setSize(300, 150);
        // define que a janela usará BoxLayout vertical
        // janela.setLayout(new BoxLayout(janela.getContentPane(), BoxLayout.Y_AXIS));        
        // define que a janela usará GridLayout com 3 linhas e 2 colunas
        janela.setLayout(new GridLayout(4,2));
        
        // cria e adiciona o rótulo de Login à janela
        janela.add(new JLabel("Login", new ImageIcon("usuario.png"),
                SwingConstants.LEFT));
        // adiciona a caixa de texto de login à janela
        janela.add(caixaLogin);
        
        // cria e adiciona o rótulo de senha à janela
        janela.add(new JLabel("Senha", new ImageIcon("chave.png"),
                SwingConstants.LEFT));
        // adiciona a caixa de texto de senha à janela
        janela.add(caixaSenha);
        
        // adiciona os botões à janela
        janela.add(botaoLogin);
        janela.add(botaoAjuda);
        
        // define a área de desenho com cor de fundo amarela
        areaDesenho.setBackground(Color.yellow);
        // adiciona as áreas de texto à janela
        janela.add(areaDesenho);
        janela.add(areaTexto);
    }
    
    /**
     * Trata o login
     */
    private void logar() {
        // recuperando o login e senha das caixas de texto
        String login = caixaLogin.getText();
        String senha = new String(caixaSenha.getPassword());

        // mostra uma caixa de mensagens na tela
        JOptionPane.showMessageDialog(janela, 
                "Usuario " + login + " e senha " + senha);
    }
    
    /**
     * Exibe a ajuda
     */
    private void exibirAjuda() {
        // obtém um dado do usuário
        String nome = JOptionPane.showInputDialog("Qual é seu nome?");

        // faz uma pergunta ao usuário (respostas: sim, não ou cancelar)
        int resposta = JOptionPane.showConfirmDialog(janela, 
                nome + ", você precisa mesmo de ajuda?");
        
        // trata se a resposta for sim
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(janela, "Não acredito " + nome + "!!!");
        }
    }
}
