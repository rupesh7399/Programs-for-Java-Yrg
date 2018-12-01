/* Deadlock Demo */

class A
{
		B bb;
		public synchronized void print()
		{
			try{
			System.out.println("Start method class A");
			Thread.sleep(1000);
			bb.print();
			System.out.println("End method class A");
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
		}
}

class B
{
		A aa;
		public synchronized void print()
		{
			try{
			System.out.println("Start method class B");
			Thread.sleep(1000);
			aa.print();
			System.out.println("End method class B");
			}
			catch(InterruptedException e){
				System.out.println(e);
			}
		}
}

class T1 extends Thread
{
		A a1;
		T1(A a11)
		{
				a1=a11;
		}
		public void run()
		{
				a1.print();
		}
}

class T2 extends Thread
{
		B b1;
		T2(B b11)
		{
				b1=b11;
		}
		public void run()
		{
				b1.print();
		}
}

class ThreadDemo12
{
	public static void main(String args[])
	{
			A a=new A();
			B b=new B();
			a.bb=b;
			b.aa=a;
			T1 t1=new T1(a);
			T2 t2=new T2(b);
			t1.start();
			t2.start();
	}
}