/* Producer Consumer Problem */

class Q {
		int n;
		
		synchronized int get() 
		{
		System.out.println("Got: " + n);
		return n;
		}

		synchronized void put(int n) 
		{
		this.n = n;
		System.out.println("Put: " + n);
		}
}

class Producer extends Thread {
		Q q;
		Producer(Q q) 
		{
			this.q = q;
		}
		public void run() 
		{
			int i = 0;
			while(true) 
			{
				q.put(i++);
			try
			{
				Thread.sleep((int)(Math.random()*2000));
			}
			catch (InterruptedException ie){}
			}
		}
}

class Consumer extends Thread 
{
	Q q;
	Consumer(Q q) 
	{
		this.q = q;
	}
	public void run() 
	{
		while(true) 
		{
			q.get();
			try
			{
				Thread.sleep((int)(Math.random()*2000));
			}
			catch (InterruptedException ie){}
		}
	}
}

class ThreadDemo13 {
	public static void main(String args[]) {
		Q q = new Q();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		p.start();
		c.start();
		System.out.println("Press Control-C to stop.");
	}
}
