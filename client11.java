// Java program to illustrate Client side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.Arrays;

public class client11
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// Step 1:Create the socket object for
		// carrying the data. z
		DatagramSocket ds = new DatagramSocket();

		InetAddress ip =InetAddress.getByName("157.49.218.163");
		byte buf[] = null;

		// loop while user not enters "bye"
		while (true)
		{
			String inp = sc.nextLine();

			// convert the String input into the byte array.
			buf = inp.getBytes();

			// Step 2 : Create the datagramPacket for sending
			// the data.
			DatagramPacket DpSend =
				new DatagramPacket(buf, buf.length, ip, 1234);

			// Step 3 : invoke the send call to actually send
			// the data.
			ds.send(DpSend);


			if (inp.equals("over")){

				DatagramSocket ds1 = new DatagramSocket(1234);
				byte[] receive = new byte[65535];

				DatagramPacket DpReceive = null;
				DpReceive = new DatagramPacket(receive, receive.length);

			// Step 3 : revieve the data in byte buffer.
				ds1.receive(DpReceive);

				System.out.println(data(receive));

				receive = new byte[65535];
			}

			// break the loop if user enters "bye"
			if (inp.equals("bye"))
				break;
		}
	}

		public static StringBuilder data(byte[] a)
	{
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}
