class T1 extends Thread
{
		String threadname;
		T1(String tnm)
		{
			threadname=tnm;
		}
		public void run()
		{
				for(int i=1;i<=1000;i++)
				{
						System.out.println(threadname + " : " + i);
				}
		}
}

class ThreadDemo15
{
	public static void main(String args[])
	{
		T1 t1=new T1("thread 1");
		T1 t2=new T1("thread 2");
		T1 t3=new T1("thread 3");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
