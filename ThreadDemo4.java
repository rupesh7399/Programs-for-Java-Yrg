class T1 implements Runnable
{
		public void run()
		{
				for(int i=1;i<=100;i++)
				{
						System.out.println(i);
				}
		}
}

class ThreadDemo4 
{
	public static void main(String args[])
	{
		T1 t1=new T1();
		Thread thread=new Thread(t1);
		thread.start();
	}
}
