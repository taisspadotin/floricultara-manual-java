package Visão;
import bancodedados.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import Classes.Plantas;
import java.sql.*;

public class FormRegistros extends JFrame
{
	private JLabel       lTitulo;
	private JTable       jTabela;
	private JButton      btExcluir;
	private JScrollPane  jScrollPane2;
	private JPanel       painelConteudo;
	
	public  FormRegistros()
	{
		super();
		iniciar();
		this.setVisible(true);
                this.getContentPane().setBackground(new Color(143, 188, 143 ));

	}
	
	private void iniciar()
	{
		Plantas plantas = new Plantas();
		lTitulo       = new JLabel("Registros das plantas");
		jScrollPane2   = new JScrollPane();
		
		lTitulo.setForeground(new Color(219, 112, 147 ));
	    lTitulo.setFont(new Font("Serif", Font.BOLD, 18));
	    
	    
	    String[] cabecalho = {"Código","Nome", "Especie", "Categoria", "Preço"};
	    int totalPlantas = plantas.numRegistro();
	    Object[][] data =new String [totalPlantas][5];
   
	    try
	    {
	    
	      ResultSet rs = plantas.getPlantas();
		  int i = 0;
		  while (rs.next())
		  {
		    data[i][0] = rs.getString("codigo");
		    data[i][1] = rs.getString("nome");
		    data[i][2] = rs.getString("especie");
			data[i][3] = rs.getString("categoria");
			data[i][4] = rs.getString("preco");
		    i++;
	      }
	    }
	    catch(SQLException ex)
	    {
			ex.printStackTrace();
	    }

	    jTabela     = new JTable(data, cabecalho);
	    btExcluir = new JButton();
	    painelConteudo = (JPanel) this.getContentPane();
	    jScrollPane2.setViewportView(jTabela);
	    		
	    btExcluir.setText("Excluir");
	    btExcluir.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		btExcluir_actionPerformed(e);}});	
	 		
	    
	    painelConteudo.setLayout(null);
	    painelConteudo.setBackground(new Color(255, 255, 255));
	    adicionarComponente(painelConteudo, lTitulo, 270, 2, 300, 84);
	    adicionarComponente(painelConteudo, jScrollPane2, 5, 60, 800, 300);
	    adicionarComponente(painelConteudo, btExcluir, 250, 400, 350, 30);
	    
	    this.setTitle("Registros da Floricultura - versão 1.0");
	    this.setLocation(new Point(17, 17));
	    this.setSize(new Dimension(850,500));
	    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
	}   
	
	private void adicionarComponente(Container container, Component c, int x, int y,int largura, int altura) {
		c.setBounds(x, y, largura, altura);
		container.add(c);
	}
	
	private void btExcluir_actionPerformed(ActionEvent e) 
	{
Plantas a = new Plantas();
          Object obj=(jTabela.getValueAt(jTabela.getSelectedRow(),0));
          String codigo=obj.toString();
          int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro do codigo: " +codigo+"?", "Confirmação", JOptionPane.YES_NO_OPTION);

if (resposta == JOptionPane.YES_OPTION) {
    boolean bPlanta = a.ExcluirPlanta(codigo);
           if (bPlanta)
		    {
			  JOptionPane.showMessageDialog(null,"Registros Removido com Sucesso!",
			                             "Remoção de Registros",JOptionPane.INFORMATION_MESSAGE);
		      setVisible(false);
		    
		    }
		    else
		    {
			  JOptionPane.showMessageDialog(null,"Erro ao Remover o Registro!",
			                             "Remoção de Registros", JOptionPane.ERROR_MESSAGE);
		    
		      setVisible(false);
		    }
          
                  /*String sopcao = JOptionPane.showInputDialog(null,"Código do Registro para Remover: ",
		                                           "Remover Registros",JOptionPane.QUESTION_MESSAGE);
		Plantas a = new Plantas();
		
		boolean bPlanta = a.ExcluirPlanta(sopcao);
		
		    if (bPlanta)
		    {
			  JOptionPane.showMessageDialog(null,"Registros Removido com Sucesso!",
			                             "Remoção de Registros",JOptionPane.INFORMATION_MESSAGE);
		      setVisible(false);
		    
		    }
		    else
		    {
			  JOptionPane.showMessageDialog(null,"Erro ao Remover o Registro!",
			                             "Remoção de Registros", JOptionPane.ERROR_MESSAGE);
		    
		      setVisible(false);
		    }*/
	   }
 else if (resposta == JOptionPane.NO_OPTION) {
   JOptionPane.showMessageDialog(null, "dados não removido");
}
        }
	
	
	public static void main(String[] args) {
		new FormRegistros();
	}
        
}
