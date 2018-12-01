import java.io.*;
import java.net.*;
import java.util.*;

class Prime{
	long pstart,pend,bunchsize;
	long exetime=0;
	public Prime(long s,long e,long bs){
		pstart=s;
		pend=e;
		bunchsize=bs;
	}
	public synchronized void addTime(long t){
		exetime=exetime+t;
		System.out.println("Time : " + exetime);
	}
	public synchronized long getTime(){
		return exetime;
	}
	public synchronized String getBunch(){
		String numberbunch="";
		if(pstart==pend)
			numberbunch="END";
		else{
			numberbunch=pstart+"";
			if((pstart+bunchsize-1) < pend){
				numberbunch=numberbunch+","+(pstart+bunchsize-1);
				pstart=pstart+bunchsize;
			}
			else{
				numberbunch=numberbunch+","+pend;
				pstart=pend;
			}
		}
		return numberbunch;
	}
}

class TCPClientThread extends Thread
{
	Socket socket;
	PrintWriter out;
	long snumber,enumber;
	boolean prime;
	Prime p;
	BufferedReader in;
	String result;
	public TCPClientThread(Prime pp,Socket s,BufferedReader br,PrintWriter pw){
		p=pp;
		socket=s;
		in=br;
		out=pw;
	}
	public void run(){
		long stime=System.currentTimeMillis();
		String bunch;
		while(true){
			bunch=p.getBunch();
			System.out.println(bunch);
			if(bunch.equals("END")==true){
				out.println("END");
				break;
			}
			else{
				out.println(bunch);
				System.out.println("Bunch send");
				try{
				result=in.readLine();
				}
				catch(IOException e){System.out.println("Error in read..");}
				if(result.equals("Next")==true)
					continue;
			}
		}
		long etime=System.currentTimeMillis();
		long exetime=etime-stime;
		p.addTime(exetime);	
	}
}	
	
public class PrimeTCPServer {
   public static void main(String args[]) {
		ServerSocket srvr;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Start : ");
		long start=input.nextLong();
		System.out.print("Enter End : ");
		long end=input.nextLong();
		System.out.print("Enter Number Bunch Size : ");
		long size=input.nextLong();
		
		Prime p=new Prime(start,end,size);
        try {
         srvr=new ServerSocket(1234);
         System.out.print("Server is ready...\n");
		 Socket skt=null;
		 PrintWriter out=null; 
		 BufferedReader in=null;
		 TCPClientThread thread=null;
		 while(true){
			skt = srvr.accept();
			out = new PrintWriter(skt.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.print("Client Connected..");
			thread=new TCPClientThread(p,skt,in,out);
			thread.start();
		}		
	  }
      catch(Exception e) {
		//srvr.close();
        System.out.print("Whoops! It didn't work!\n");
      }
   }
}