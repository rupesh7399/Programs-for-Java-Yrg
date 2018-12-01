/* Producer Consumer Problem Resolved using wait-notify */

class Q {
		int n;
		boolean valueSet=false;
		synchronized int get() 
		{
			System.out.println("Get Again");
			if(!valueSet)
			{
					try
					{
						System.out.println("Wait in Get");
						wait();
					}
					catch(InterruptedException ie)
					{}
			}
			System.out.println("Got: " + n);
			valueSet=false;
			notify();
			return n;
		}

		synchronized void put(int n) 
		{
			System.out.println("Put Again");
			if(valueSet)
			{
					try
					{
						System.out.println("Wait in put");
						wait();
					}
					catch(InterruptedException ie)
					{}
			}
			this.n = n;
			valueSet=true;
			System.out.println("Put: " + n);
			notify();
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
				Thread.sleep((int)(Math.random()*5000));
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
				Thread.sleep((int)(Math.random()*1000));
			}
			catch (InterruptedException ie){}
		}
	}
}

class ThreadDemo17 {
	public static void main(String args[]) {
		Q q = new Q();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		p.start();
		c.start();
		System.out.println("Press Control-C to stop.");
	}
}
