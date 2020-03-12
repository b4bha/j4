/*Write a menu driven program to perform the following operations         
 *on a set of integers. The Load operation should load the numbers from a file to an array
 *and display the numbers in a panel. Use the file select dialog to choose the name of the      
 *   file. The save operation should save the contents of the array to the same file. The  
 *       Compute menu provides various menu options. The result should be displayed in a message     box.
 * The Search operation accepts a number from the user in an input dialog and displays     
 *  the search result in a message dialog. The sort operation sorts the numbers and displays       
 *  the sorted data 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class Slip4_1 extends JFrame implements ActionListener
{
	private JMenu m1,m2,m3,m4;
	private JMenuBar mb;
	private JMenuItem m[];
	//private JRadioButtonMenuItem r1,r2;
	//private ButtonGroup b;
	private JLabel l;
	private JTextField t;
	private JPanel p;
	StringBuffer ss=new StringBuffer();
	int sel,n;
	int arr[]=new int [20];
	double res;
	public Slip4_1(String s)
	{
		super(s);
		sel=1;
		res=0;
		p=new JPanel();
		mb=new JMenuBar();
		m1=new JMenu("Operation");
		m2=new JMenu("Compute");
		l=new JLabel("Numbers");
		t=new JTextField(20);
		//b=new ButtonGroup();
		//r1=new JRadioButtonMenuItem("Ascending");
		//r1.addItemListener(this);
		//r2=new JRadioButtonMenuItem("Descending");
		//r2.addItemListener(this);
		//b.add(r1);
		//b.add(r2);
		String str[]={"Load","Save","Exit","Sum","Average"};
		m=new JMenuItem[str.length];
		for(int i=0;i<str.length;i++)
		{
			m[i]=new JMenuItem(str[i]);
			m[i].addActionListener(this);
		}
		p.add(l);
		p.add(t);
		mb.add(m1);
		mb.add(m2);

		m1.add(m[0]);
		m1.add(m[1]);
		m1.addSeparator();
		m1.add(m[2]);
		m2.add(m[3]);
		m2.add(m[4]);
		setLayout(new BorderLayout());
		add(mb,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
		if(s.equals("Exit"))
		{
			System.exit(0);
		}
		else
		 if(s.equals("Load"))
		 {
	 		if(arr[0]==0)
			{
				int i=0;
				try
				{
					BufferedReader r=new BufferedReader(new FileReader("num.txt"));
			 		String s1=r.readLine();
			 		while(s1!=null)
			 		{
						ss.append(s1);
			 			ss.append(" ");
			 			arr[i]=Integer.parseInt(s1);
			 			n=++i;
			 			s1=r.readLine();
					}
				}
				catch(Exception eee){       }
				t.setText(new String(ss));
			}
		}
		else 
		if(s.equals("Sum"))
		{
			t.setText(new Integer(givesum()).toString());
		}
		else
		 if(s.equals("Average"))
		{
			t.setText(new Double(giveavg()).toString());
		}
		//	 		else
		/* if(s.equals("Maximum")){t.setText(new Integer(givemax()).toString());}else if(s.equals("Minimum")){t.setText(new Integer(givemin()).toString());}else if(s.equals("Median")){t.setText(new Integer(givemed()).toString());}*/
		else if(s.equals("Save"))
		{//if(arr[0]!=0)
		 	char ch;
		 	String sss = t.getText();
			try
			{
				FileOutputStream br1 = new  FileOutputStream("num.txt");
				for(int i=0;i<sss.length();i++)
				{
					ch=sss.charAt(i);
					if(ch == ' ')
						br1.write('\n');
					else
						br1.write(ch);
				}
				br1.close();
			}catch(Exception eee){ }
		}
		// else if(s.equals("Search")){int ser=Integer.parseInt(JOptionPane.showInputDialog("Enter Number To Search"));int a=0;for(int i=0;i<n;i++){if(arr[i]==ser){t.setText("Number Present");a=1;}if(a==0)t.setText("Number Not Present");
											 							//}}
	}
	
	public int givesum()
	{
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];
		}
		return sum;
	}
	public double giveavg()
	{
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];
		}
		return sum/n;
	}
	//public int givemax(){int sum=arr[0];for(int i=0;i<n;i++){if(arr[i] > sum)sum=arr[i];}return sum;}public int givemin(){int sum=arr[0];for(int i=0;i<n;i++){if(arr[i] < sum)sum=arr[i];}return sum;}public int givemed(){return arr[(n/2)];}}
																				 							
	public static void main(String arg[])
	{
		Slip4_1 c =new Slip4_1("My Computation");
		c.setSize(300,150);
		c.setVisible(true);
		c.setLocation(500,200);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}