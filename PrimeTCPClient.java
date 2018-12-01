import java.io.*;
import java.net.*;

class PrimeTCPClient {
   public static void main(String args[]){
      boolean prime=true;
	  int port=Integer.parseInt(args[1]);
	  try {
        Socket skt = new Socket(args[0],port);
		String bunch=null;
        BufferedReader in = new BufferedReader(new
        InputStreamReader(skt.getInputStream()));
		PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
		System.out.print("Received string: ");
		while(true){
			bunch=in.readLine();
			System.out.println(bunch);
			if(bunch.equals("END")!=true){
				String limit[]=bunch.split(",");
				long snumber=Long.parseLong(limit[0]);
				long enumber=Long.parseLong(limit[1]);
				for(long no=snumber;no<=enumber;no++){
					prime=true;
					for(long i=2;i<no;i++){
						if(no%i==0){
							prime=false;break;
						}
					}
					if(prime==true)
						System.out.println(no);
				}
				out.println("Next");	
			}
		}
        //in.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}