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

class ThreadDemo1 
{
	public static void main(String args[])
	{
		T1 t1=new T1();
		t1.start();
	}
}
