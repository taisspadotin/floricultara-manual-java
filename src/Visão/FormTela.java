package Visão;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FormTela extends JFrame 
{ 
    
        JMenuBar  menuBar;
	JMenu     menuPlanta, menuSair;
	JMenuItem menuItemPlanta, menuItemSair;
	String novaLinha;  
        Container container = this.getContentPane();
        
        
FormTela()
	{
            this.getContentPane().setBackground(new Color(143, 188, 143 ));
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
		setSize(800,500 );
		setTitle("Floricultura");
		novaLinha = System.getProperty("line.separator");
		
		menuBar = new JMenuBar();
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
		container.add(menuBar,BorderLayout.NORTH);
		
		
		menuPlanta = new JMenu("Arquivo");
		menuPlanta.setMnemonic('A');//CTRL+A
		menuBar.add(menuPlanta);
		
		menuItemPlanta = new JMenuItem("Cadastrar Planta");
		menuItemPlanta.setMnemonic('C');
		menuItemPlanta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				FormPlanta fa = new FormPlanta();
				fa.setVisible(true);
		    }
	    });
		menuPlanta.add(menuItemPlanta);
		
		menuSair = new JMenu("Sair");
	    menuBar.add(menuSair);
	    menuItemSair = new JMenuItem("Sair do Sistema");
	    menuItemSair.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		setVisible(false);
	    	}
	    });
	    menuSair.add(menuItemSair);
		
	}
	
	public static void main(String[] args)
	{
		FormTela ft = new FormTela ();
		ft.setVisible(true);
    }
		
}
