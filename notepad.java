package notepadproj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;




public class notepad implements ActionListener{
   JFrame f,j;
   String text;
  JTextArea ta;
   JButton b;
   JMenu m1,m2;
   JMenuBar mb;
   JMenuItem mi11,mi12,mi13,mi21,mi22,mi23;
   JFileChooser fc,a;
	public notepad() {
		f=new JFrame("UNTITLED");
		f.setSize(600, 700);
		f.setLayout(null);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		ta=new JTextArea();
		ta.setBounds(10,30, 600, 600);
		//f.add(ta);
		
		 mb= new JMenuBar();
		 m1 = new JMenu("File");
		 m2 = new JMenu("Edit"); 
		 mb.add(m1);
		 mb.add(m2);
		fc=new JFileChooser();
	   
	     mi11 = new JMenuItem("New");
	     mi11.addActionListener(this);
         mi12 = new JMenuItem("Open");	
         mi12.addActionListener(this);
         mi13 = new JMenuItem("Save");
         mi13.addActionListener(this);
		 m1.add(mi11);
		 m1.add(mi12);
		 m1.add(mi13);
		
		 mi21=new JMenuItem("Cut");
		 mi21.addActionListener(this);
		 mi22=new JMenuItem("Copy");
		 mi22.addActionListener(this);
		 mi23=new JMenuItem("Paste");
		 mi23.addActionListener(this);
		 m2.add(mi21);
		 m2.add(mi22);
		 m2.add(mi23);
		f.add(ta);
		 
		
		f.setJMenuBar(mb);
		f.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new notepad();
		// TODO Auto-generated method stub

	}

	
	public void actionPerformed(ActionEvent e) {
		//fc = new JFileChooser();
	 if(e.getSource()==mi11)
	 { 
          new notepad();
	 
	 }
		 if(e.getSource()==mi12)
		 {	int ret=fc.showOpenDialog(mi12);
		 
	           if(ret==JFileChooser.APPROVE_OPTION)
	           {
	        	    try {File f1=fc.getSelectedFile();
	        
	            {ta.setText("");
					FileReader fin=new FileReader(f1);
					BufferedReader br=new BufferedReader(fin);
					
					while(br.readLine()!=null)
					  {text = br.readLine();
					ta.append(text+"\n");
				} 
			  }}
					catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }
		 
		 }	
		 if(e.getSource()==mi13)
			{	
			int ret2=fc.showSaveDialog(mi13);
			   if(ret2==JFileChooser.APPROVE_OPTION)
			   {
		          File f2=fc.getSelectedFile();
			      String loc=f2.getPath();
			      
				try {
					FileWriter fout;
					fout = new FileWriter(f2);
					BufferedWriter br=new BufferedWriter(fout);
					String text2=ta.getText();
					char temp[]=new char[text2.length()];
					text2.getChars(0, text2.length(), temp, 0);
					for(int i=0;i<text2.length();i++)
					      br.write(temp[i]);
					
					br.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			    	  }
			      }
	
			
		if(e.getSource()==mi21)
			ta.cut();
		
			if(e.getSource()==mi22)
				ta.copy();
			if(e.getSource()==mi23)
				ta.paste();
	           }
		
	

	private void append(String string) {
		// TODO Auto-generated method stub
		
	}


		
	}

	
		

