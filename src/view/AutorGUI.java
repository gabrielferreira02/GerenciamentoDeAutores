package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.AutorController;
import model.Autor;

/**
 * Classe responsavel pela interface grafica para cadastro de autores
 * Inclui campos de texto, um combo box, botoes para limpar e enviar dados,
 * e uma tabela para exibir os autores cadastrados
 */
public class AutorGUI extends JFrame {
    private JTextField txtCodigo, txtNome, txtEmail;
    private JComboBox<String> cbTipoEscrita;
    private JButton btnLimpar, btnEnviar;
    private JTable tabela;
    private DefaultTableModel modelo;
    
    // Declaração da variável do controller
    private AutorController autorController;

    /**
     * Construtor da classe AutorGUI.
     * Inicializa os componentes da interface gráfica e organiza os elementos na janela.
     */
    public AutorGUI() {
        // Instância do controller do autor
        autorController = new AutorController(new ArrayList<Autor>());
    	
        setTitle("Cadastro de Autores");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        // Configuração do campo de código
        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(30, 30, 80, 20);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(100, 30, 150, 20);
        add(txtCodigo);

        // Configuração do campo de nome
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(30, 60, 80, 20);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 60, 150, 20);
        add(txtNome);

        // Configuração do campo de email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 90, 80, 20);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(100, 90, 150, 20);
        add(txtEmail);
	    
        // Configuração do tipo de escrita
        JLabel lblTipo = new JLabel("Tipo de Escrita:");
        lblTipo.setBounds(30, 120, 100, 20);
        add(lblTipo);

        cbTipoEscrita = new JComboBox<>(new String[]{"Literatura Infantil", "Literatura Juvenil", "Literatura Adulta"});
        cbTipoEscrita.setBounds(150, 120, 150, 20);
        add(cbTipoEscrita);

        // Configuração do botão "LIMPAR"
        btnLimpar = new JButton("LIMPAR");
        // Funcionalidade para limpar os campos
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autorController.limpar(txtCodigo, txtNome, txtEmail);
            }
        });
        btnLimpar.setBounds(50, 170, 100, 30);
        add(btnLimpar);

        // Configuração do botão "ENVIAR"
        btnEnviar = new JButton("ENVIAR");
        // Funcionalidade para enviar os dados do formulario
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autorController.adicionarAutor(txtCodigo, txtNome, txtEmail, cbTipoEscrita, modelo, getContentPane());
            }
        });
        btnEnviar.setBounds(200, 170, 100, 30);
        add(btnEnviar);

        // Configuração da tabela para exibir os autores cadastrados
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        modelo.addColumn("Tipo de Escrita");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(30, 220, 400, 120);
        add(scrollPane);

        // Configuração básica da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
