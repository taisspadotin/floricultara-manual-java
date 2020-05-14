
package Visão;
import bancodedados.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import Classes.Plantas;
import java.sql.*;

public class FormPlanta extends JFrame
{
	//declarando as Laabel
        private JLabel     lTitulo;
	private JLabel     lCodigo_Planta;
	private JLabel     lNome;
	private JLabel 	   lEspecie;
	private JLabel     lCategoria;
	private JLabel     lPreco;
        
        //declarando os textfield
	private JTextField tCodigo_Planta;
	private JTextField tNome;
        private JTextField tEspecie;
        private JTextField tCategoria;
        private JTextField tPreco;

        //declarando os botões
        private JButton    btCadastrar;
        private JButton    btAlterar;
        private JButton    btConfirmar;
	private JButton    btRegistros;
        
        //declarando o painel
	private JPanel     painelConteudo;
     
    public FormPlanta()
    {
      super();
      iniciar();
      this.setVisible(true);
      this.getContentPane().setBackground(new Color(143, 188, 143 ));
    	
    } 
    
    private void iniciar()
    {
    	//Plantas planta  = new Plantas();//instancia
        
        //Faezndo as label receber esse texto
    	lTitulo        = new JLabel("Cadastro:");
    	lCodigo_Planta = new JLabel("Código:");
    	lNome          = new JLabel("Nome:");
    	lEspecie     = new JLabel("Especie:");
    	lCategoria        = new JLabel("Categoria:");
    	lPreco           = new JLabel("Preço:");
    	
        //instanciando os campos
        tCodigo_Planta= new JTextField("00000");
    	tNome          = new JTextField();
    	tEspecie     = new JTextField();
    	tCategoria       = new JTextField();
    	tPreco           = new JTextField();
	
        //alterando o titulo da fonte
	lTitulo.setForeground(new Color(176, 48, 96 ));
	lTitulo.setFont(new Font("Serif", Font.BOLD, 18));
	    
           //instanciando os botões
	    btCadastrar = new JButton();
	    btAlterar   = new JButton();
	    btConfirmar = new JButton();
            btRegistros = new JButton();
            
	    btConfirmar.setEnabled(false);
	    
            //instanciando o painel
	    painelConteudo = (JPanel) this.getContentPane();
	    
            //mudando o texto da variavel
	    btCadastrar.setText("Cadastrar");
            //adicionando um action listener
	    btCadastrar.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		btCadastrar_actionPerformed(e);}});
	    		
	    btAlterar.setText("Alterar");
	    btAlterar.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		btAlterar_actionPerformed(e);}});
	    
	    btConfirmar.setText("Confirmar Alteração");
	    btConfirmar.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		btConfirmar_actionPerformed(e);}});
	    		
	    btRegistros.setText("Registros");
	    btRegistros.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		btRegistros_actionPerformed(e);}});	
	    
	    painelConteudo.setLayout(null);
	    painelConteudo.setBackground(new Color(255, 255, 255));
            
            //adicionando ao painel
	    adicionarComponente(painelConteudo, lTitulo, 270, 2, 145, 84);
            
	    adicionarComponente(painelConteudo, lCodigo_Planta, 50, 40, 145, 84);
	    adicionarComponente(painelConteudo, tCodigo_Planta, 112, 73, 75, 20);
	    adicionarComponente(painelConteudo, lNome, 50, 100, 70, 18);
	    adicionarComponente(painelConteudo, tNome, 112, 100, 200, 22);
	    adicionarComponente(painelConteudo, lEspecie, 50, 100, 150, 74);
	    adicionarComponente(painelConteudo, tEspecie, 112, 130, 360, 22);
	    adicionarComponente(painelConteudo, lCategoria, 50, 157, 100, 28);
	    adicionarComponente(painelConteudo, tCategoria, 112, 160, 250, 22);
	    adicionarComponente(painelConteudo, lPreco, 50, 187, 100, 22);
	    adicionarComponente(painelConteudo, tPreco, 112, 190, 100, 22);
	    
                //botões
            adicionarComponente(painelConteudo, btCadastrar, 10, 360,150, 30);  
            adicionarComponente(painelConteudo, btAlterar, 180, 360,150, 30); 
            adicionarComponente(painelConteudo, btConfirmar, 350, 360,150, 30); 
            adicionarComponente(painelConteudo, btRegistros, 530, 360,150, 30); 
		
		
	    this.setTitle("Floricultura - versão 1.0");
	    this.setLocation(new Point(17, 17));
	    this.setSize(new Dimension(800,550));
	    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
	}

	private void adicionarComponente(Container container, Component c, int x, int y,int largura, int altura) {
		c.setBounds(x, y, largura, altura);
		container.add(c);
	}

	private void btCadastrar_actionPerformed(ActionEvent e) 
	{
		System.out.println("Botão Cadastrar pressionado");
		
		String sCodigo_Planta = "";
		String sNome = "";
		String sEspecie = "";
		String sCategoria = "";
		String sPreco = "";

		sCodigo_Planta		  = tCodigo_Planta.getText();
		sNome 		          = tNome.getText();
		sEspecie    		  = tEspecie.getText();
		sCategoria        		  = tCategoria.getText();
		sPreco           		  = tPreco.getText();
		
		Plantas a = new Plantas();
		if(sCodigo_Planta != "")
		{
			boolean bPlanta = a.novaPlantas(sCodigo_Planta, sNome, sEspecie,
		                               sCategoria, sPreco);
		
		    if (bPlanta)
		    {
			  JOptionPane.showMessageDialog(null,"Registros Cadastrados com Sucesso!",
			                             "Gravação de Registros",JOptionPane.INFORMATION_MESSAGE);
		    }
		    else
		    {
			  System.out.println("Erro no cadastro da Agenda");
		    }
		 }
		 
		 tCodigo_Planta.setText("00000");
		 tNome.setText("");
		 tEspecie.setText("");
		 tCategoria.setText("");
		 tPreco.setText("");
		 
	}

	private void btRegistros_actionPerformed(ActionEvent e) 
	{
		FormRegistros fr = new FormRegistros();
		fr.setVisible(true);
		
	}
	
	private void btAlterar_actionPerformed(ActionEvent e) 
	{
	
		Plantas a = new Plantas();
		String opcao;
		btConfirmar.setEnabled(true);
	    
	    String sCodigo_Planta = "";
		String sNome= "";
		String sEspecie= "";
		String sCategoria= "";
	    String sPreco= "";
	   
        opcao = JOptionPane.showInputDialog(null,"Código Registro a Alterar:",
                               "Alteração de Registros",JOptionPane.QUESTION_MESSAGE);	   
	   
	    try
	    {
	    	ResultSet rs = a.obterRegistro(opcao);
	    	while(rs.next())
	    	{
	    		sCodigo_Planta = rs.getString("codigo");
				sNome = rs.getString("nome");
				sEspecie = rs.getString("especie");
				sCategoria = rs.getString("categoria");
				sPreco = rs.getString("preco");
	    	  
	    	    tCodigo_Planta.setText(sCodigo_Planta);
	    		tNome.setText(sNome);
	    		tEspecie.setText(sEspecie);
	    		tCategoria.setText(sCategoria);
	    		tPreco.setText(sPreco);
	    	
	    	}
	    	
	    	   
	    }
	    
	    catch(SQLException ex)
	    {
			
			ex.printStackTrace();
	    }
	
	}
	
	private void btConfirmar_actionPerformed(ActionEvent e) 
	{
	  	
		String sCodigo_Planta = "";
		String sNome= "";
		String sEspecie= "";
		String sCategoria= "";
	        String sPreco= "";
                
		sCodigo_Planta		  = tCodigo_Planta.getText();
		sNome 		   		  = tNome.getText();
		sEspecie     		  = tEspecie.getText();
		sCategoria        		  = tCategoria.getText();
		sPreco           		  = tPreco.getText();
                
		Plantas a = new Plantas();
		if(sCodigo_Planta != "")
		{
			boolean bPlanta = a.AtualizaPlanta(sCodigo_Planta, sNome, sEspecie,
		                               sCategoria, sPreco);
		
		    if (bPlanta)
		    {
			  JOptionPane.showMessageDialog(null,"Registros Atualizados com Sucesso!",
			                             "Atualização de Registros",JOptionPane.INFORMATION_MESSAGE);
		    }
		    else
		    {
			  System.out.println("Erro no cadastro da Agenda");
		    }
		 }
		 
		 tCodigo_Planta.setText("00000");
		 tNome.setText("");
		 tEspecie.setText("");
		 tCategoria.setText("");
		 tPreco.setText("");
		 
	}
	
	
	
	public static void main(String[] args) {
		new FormPlanta();
	}
        
         
}