package com.network.s02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class EchoClient {
	private String ip;
	private int port;
	private String str;
	BufferedReader file;
	
	//생성자
	public EchoClient(String ip, int port) throws IOException {
		this.ip = ip;
		this.port = port;
		
		//Socket생성
		Socket tcpSocket = getSocket();
		//출력스트림
		OutputStream os_socket = tcpSocket.getOutputStream();
		//입력스트림
		InputStream is_socket = tcpSocket.getInputStream();
		//바이트스트림 -> 문자스트림
		//문자출력스트림 (클라이언트가 서버에 전송)
		BufferedWriter bufferW = new BufferedWriter(new OutputStreamWriter(os_socket));
		//문자입력스트림 (서버가 클라이언트에 전송)
		BufferedReader bufferR = new BufferedReader(new InputStreamReader(is_socket));
		
		//콘솔에 입력하는 입력스트림 생성
		file = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력> ");
		str = file.readLine();
		str += System.getProperty("line.separator");
		
		//서버에 데이터 전송
		bufferW.write(str);
		bufferW.flush();
		
		//서버에서 클라이언트로 전송된 데이터를 입력 받음
		str = bufferR.readLine();
		
		System.out.println("Echo Result: " + str);
		
		file.close();
		bufferW.close();
		bufferR.close();
		tcpSocket.close();
		
	}
	
	//서버의 ip와 port 정보를 전달하고 Socket을 생성하는 작업
	public Socket getSocket() {
		Socket tcpSocket = null;
		
		try {
			tcpSocket = new Socket(ip,port);
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		return tcpSocket;
	}
	
	public static void main(String[] args) {
		try {
			new EchoClient("192.168.10.35", 3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}