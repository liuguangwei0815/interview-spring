/**
 * 
 */
package com.my.interview.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @author liuwei socket 客户端
 */
public class SockeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OutputStream out = null;
		InputStream in = null;
		try {
			Socket sock = new Socket("127.0.0.1", 65000);
			out = sock.getOutputStream();
			in = sock.getInputStream();
			out.write("hello word".getBytes());
			byte[] buffer = new byte[1024];
			int ch = in.read(buffer);
			String context = new String(buffer,ch);
			System.out.println(zcontext);
			sock.close();
			HashMap<String,String> map = new HashMap<String, String>();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
