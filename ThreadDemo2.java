class T1 extends Thread
{
		public void run()
		{
				for(int i=1;i<=100;i++)
				{
						System.out.println(i);
				}
		}
}

class ThreadDemo2
{
	public static void main(String args[])
	{
		T1 t1=new T1();
		T1 t2=new T1();
		T1 t3=new T1();
		t1.start();
		t2.start();
		t3.start();
	}
}
