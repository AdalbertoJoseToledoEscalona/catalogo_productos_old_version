/**
 * 
 */
package modelo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author adalberto
 *
 */
public class Mac {

	/**
	 * 
	 */
	public Mac() {
		// TODO Auto-generated constructor stub
	}
	
	public void imprimirMacMetodoJava() {
		try {
		    InetAddress ip = InetAddress.getLocalHost();
		    System.out.println("Current IP address : " + ip.getHostAddress());

		    Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
		    while(networks.hasMoreElements()) {
		      NetworkInterface network = networks.nextElement();
		      byte[] mac = network.getHardwareAddress();

		      if(mac != null) {
		        System.out.print("Current MAC address : ");

		        StringBuilder sb = new StringBuilder();
		        for (int i = 0; i < mac.length; i++) {
		          sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		        }
		        System.out.println(sb.toString());
		      }
		    }
		  } catch (UnknownHostException e) {
		    e.printStackTrace();
		  } catch (SocketException e){
		    e.printStackTrace();
		  }
	}
	
	public void imprimirMacMetodoJava2() throws UnknownHostException, SocketException {
//		System.out.println("Current HostName : " + InetAddress.getLocalHost().getHostName());
//		System.out.println("Current HostName : " + InetAddress.getLocalHost().isLoopbackAddress());
//		System.out.println("Current IP address : " + InetAddress.getLocalHost().getHostAddress());
		
		
//		System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
//		System.out.println(InetAddress.getLocalHost().getHostAddress());
//		System.out.println(InetAddress.getLocalHost().getHostName());
//		System.out.println(InetAddress.getLocalHost().isAnyLocalAddress());
//		System.out.println(InetAddress.getLocalHost().isLinkLocalAddress());
//		System.out.println(InetAddress.getLocalHost().isLoopbackAddress());
//		System.out.println(InetAddress.getLocalHost().isMCGlobal());
//		System.out.println(InetAddress.getLocalHost().isMCLinkLocal());
//		System.out.println(InetAddress.getLocalHost().isMCNodeLocal());
//		System.out.println(InetAddress.getLocalHost().isMCOrgLocal());
//		System.out.println(InetAddress.getLocalHost().isMCSiteLocal());
//		System.out.println(InetAddress.getLocalHost().isMulticastAddress());
//		System.out.println(InetAddress.getLocalHost().isSiteLocalAddress());
//		System.out.println(InetAddress.getLocalHost().getClass());
		
		
		  for(NetworkInterface network : IterableEnumeration.make(NetworkInterface.getNetworkInterfaces())) {
			  
			  
			  
		    byte[] mac = network.getHardwareAddress();
		    if(mac != null) {
		    	
		    	System.out.println(network.getDisplayName());
				  System.out.println(network.getIndex());
				  System.out.println(network.getMTU());
				  System.out.println(network.getName());
				  System.out.println(network.isLoopback());
				  System.out.println(network.isPointToPoint());
				  System.out.println(network.isUp());
				  System.out.println(network.isVirtual());
				  System.out.println(network.supportsMulticast());
				  System.out.println(network.getClass());
		    	
		      System.out.print("Current MAC address : ");
		      StringBuilder sb = new StringBuilder();
		      for (int i = 0; i < mac.length; i++) {
		        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		      }
		      System.out.println(sb.toString() + " "+network.getDisplayName());
		      //Bound InetAddress for interface
		      for(InetAddress address : IterableEnumeration.make(network.getInetAddresses())) {
		        System.out.println("\tBound to:"+address.getHostAddress() + " ipv4 = "+(address instanceof Inet4Address) + " ipv6 = "+(address instanceof Inet6Address) + " hostname = " + address.getHostName());
		        //System.out.println(address.getCanonicalHostName());
		      }
		    }
		  }
	}
	
	public void imprimirMacMetodoWindows() throws IOException {
		String command = "ipconfig /all";
	       Process p = Runtime.getRuntime().exec(command);
	 
	       BufferedReader inn = new BufferedReader(new InputStreamReader(p.getInputStream()));
	       Pattern pattern = Pattern.compile(".*Physical Addres.*: (.*)");
	 
	       while (true) {
	            String line = inn.readLine();
	 
		    if (line == null)
		        break;
	 
		    Matcher mm = pattern.matcher(line);
		    if (mm.matches()) {
		        System.out.println(mm.group(1));
		    }
		}
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		new Mac().imprimirMacMetodoJava2();
		
		//00:25:11:f1:8f:41 
//		Date date = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime();
//	    
//	    System.out.println(date.getT);
//	    System.out.println(new Date().toGMTString());
		
//		Date d1 = Calendar.
//		System.out.println(d1.getTime());
//		Date d2 = new Date();
//		System.out.println(d2.getTime());
		
		
		
		
	}

}
