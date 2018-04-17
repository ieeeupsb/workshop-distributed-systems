import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender {
	public static void main(String[] args) {
		
		if(args.length < 2){
			System.out.println("Need an address and a port number, in that order");
			return;
		}

		DatagramSocket dSock = null;
		MulticastSocket mSock = null;

		try {
			mSock = new MulticastSocket(Integer.parseInt(args[1]));
			mSock.joinGroup(InetAddress.getByName(args[0]));
		} catch (SocketException e) {
			System.out.println("CLIENT: Could not create socket, exiting now");
			return;
		} catch (NumberFormatException e) {
			System.out.println("CLIENT: Port argument does not appear to be a number");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		//byte[] mbuf = new byte[256];
		
		try {
			DatagramPacket mPack = new DatagramPacket("testing".getBytes(), 7, InetAddress.getByName(args[0]), Integer.parseInt(args[1]));
			mSock.send(mPack);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}