/**
 * 
 */
package com.my.interview.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuwei socket 服务端
 */
public class SocketService {

	public static void main(String[] args) {
		// 建立socket监听端口
		try {
			ServerSocket server = new ServerSocket(65000);

			while (true) {
				// 线程柱塞等待客户端连接
				Socket sock = server.accept();

				new ThreadSocket(sock).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static class ThreadSocket extends Thread {

		private Socket sock;

		public ThreadSocket(Socket sock) {
			super();
			this.sock = sock;
		}

		@Override
		public void run() {
			try (OutputStream out = sock.getOutputStream(); InputStream in = sock.getInputStream();) {
				byte[] buffer = new byte[1024];
				// ii 返回的内容长度
				int ii = in.read(buffer);
				String content = new String(buffer, ii);
				System.out.println("获取到客户内容为：" + content);
				// 返回长度
				out.write(String.valueOf(content.length()).getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
