/* Thread with join method */

class T1 extends Thread
{
		public void run()
		{
				for(int i=1;i<=10;i++)
				{
					System.out.println(i);
					try{
						Thread.sleep(500);
					}
					catch(InterruptedException e){
						System.out.println(e);
					}
				}
		}
}
class ThreadDemo9
{
	public static void main(String args[])
	{
			T1 t1=new T1();
			T1 t2=new T1();
			T1 t3=new T1();
			System.out.println("First line");
			System.out.println("Second line");
			t1.start();
			t2.start();
			t3.start();
			
			try{
			t1.join();
			t2.join();
			t3.join();
			}
			catch(InterruptedException ie){}
			
			System.out.println("Last line");
			System.out.println("End of the main program");
	}
}
