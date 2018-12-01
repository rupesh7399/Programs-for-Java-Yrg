/* Thread with synchronized method */

class Bracket
{
		public synchronized void print()
		{
			try{
			System.out.print("[");
			Thread.sleep(1000);
			System.out.print("Hello Java");
			Thread.sleep(1000);
			System.out.println("]");
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
		}
}

class T1 extends Thread
{
		Bracket bt;
		T1(Bracket b)
		{
				bt=b;
		}
		public void run()
		{
				bt.print();
		}
}
class ThreadDemo11
{
	public static void main(String args[])
	{
			Bracket b1=new Bracket();
			T1 t1=new T1(b1);
			T1 t2=new T1(b1);
			T1 t3=new T1(b1);
			t1.start();
			t2.start();
			t3.start();
	}
}
