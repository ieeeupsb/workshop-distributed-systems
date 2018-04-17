import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;


public class Listener {
	public static void main(String[] args){

		if(args.length < 2){
			System.out.println("Need an address and a port number, in that order");
			return;
		}
		
        MulticastSocket mSock = null;
        
		try {	
			mSock = new MulticastSocket(Integer.parseInt(args[1]));
			mSock.joinGroup(InetAddress.getByName(args[0]));
		} catch (SocketException e) {
			System.out.println("SERVER: Could not create sockets, exiting now.");
			return;
		}
		catch(NumberFormatException e){
			System.out.println("SERVER: Argument for port number is not a number");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Server is running");
		while(true){
			byte[] mbuf = new byte[256];
			DatagramPacket mPack = new DatagramPacket(mbuf, mbuf.length);

			try{
				mSock.receive(mPack);
			} catch (IOException e){
				e.printStackTrace();
			}
			

			String mReceived = null;
			try {
				mReceived = new String(mbuf, "UTF-8").trim();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			System.out.println(mReceived);

        }
    }
}