import javax.swing.*;
import java.awt.*;

class TT extends Thread
{
		JButton jbutton;
		TT(JButton jb)
		{
				jbutton=jb;
		}
		public void run()
		{
				int r=0,g=0,b=0;
				while(true)
				{
						r=((int)(Math.random()*255));
						g=((int)(Math.random()*255));
						b=((int)(Math.random()*255));
						Color c=new Color(r,g,b);
						jbutton.setBackground(c);
						try{
								sleep(1000);
						}
						catch(InterruptedException ie){}
				}
		}
}

class MyFrame extends JFrame {
	JButton jb1=new JButton("1");
	JButton jb2=new JButton("2");
	JButton jb3=new JButton("3");
	JButton jb4=new JButton("4");
	TT t1=new TT(jb1);
	TT t2=new TT(jb2);
	TT t3=new TT(jb3);
	TT t4=new TT(jb4);
		
	public MyFrame(){
		super("Thread Application");
		getContentPane().setLayout(new GridLayout(2,2));
		getContentPane().add(jb1);
		getContentPane().add(jb2);
		getContentPane().add(jb3);
		getContentPane().add(jb4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}


public class ThreadDemo7
{
	public static void main(String[] args) 
	{
			MyFrame mf=new MyFrame();
			mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mf.setSize(400,600);
			mf.setVisible(true);
	}
}
