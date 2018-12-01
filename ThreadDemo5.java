class ThreadDemo5
{
	public static void main(String args[])
	{
		for(int i=1;i<=100;i++)
		{
				System.out.println(i);
				try{
						Thread.sleep(200);
				}
				catch(InterruptedException e){
						System.out.println(e);
				}
		}

	}
}
