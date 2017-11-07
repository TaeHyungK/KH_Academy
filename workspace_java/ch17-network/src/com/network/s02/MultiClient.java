package com.network.s02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame implements ActionListener{

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private JTextField jtf;
	private JTextArea jta;
	private JLabel jlb1,jlb2;
	private JPanel jp1, jp2;
	private String ip;
	private String id;
	private JButton jbtn;
	
	public MultiClient(String ip, String id) {
		//제목 지정
		super("Multi Chatting");
		
		this.ip = ip;
		this.id = id;
		
		jtf = new JTextField(30);
		jta = new JTextArea(10,50);
		jlb1 = new JLabel("ID:["+id+"] ");
		jlb2 = new JLabel("IP: " + ip);
		jbtn = new JButton("종료");
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jta.setBackground(Color.PINK);
		jp1.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());
		
		//JButton을 JPanel에 등록
		jp1.add(jbtn, BorderLayout.EAST);
		//JTextField를 JPanel에 등록
		jp1.add(jtf, BorderLayout.CENTER);
		//JLabel을 JPanel에 등록
		jp2.add(jlb1, BorderLayout.CENTER);
		jp2.add(jlb2, BorderLayout.EAST);
		
		//JPanel을 JFrame에 등록
		add(jp1, BorderLayout.SOUTH); 
		add(jp2, BorderLayout.NORTH);
		
		//JTextArea 스크롤 처리
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//JscrollPane을 JFrame에 등록
		add(jsp,BorderLayout.CENTER);
		
		//JTextArea 편집 불가능
		jta.setEditable(false);
		
		//이벤트 소스와 이벤트 리스너 연결
		jtf.addActionListener(this);
		jbtn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			//이벤트 핸들러
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					//서버에 종료 메시지 전송
					oos.writeObject(MultiClient.this.id+"#exit");
				}catch(IOException ie) {
					ie.printStackTrace();
				}
				//프로그램 종료
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				//프레임이 화면에 보여지면 포커스를 JTextField에 줌
				jtf.requestFocus();
			}
			
		});
		
		//스크린 정보를 구하기 위해 Toolkit객체 생성
		Toolkit tk = Toolkit.getDefaultToolkit();
		//스크린 크기를 읽어옴
		Dimension d = tk.getScreenSize();
		int screenWidth = d.width;
		int screenHeight = d.height;
		
		//JFrame 사이즈를 지정하지 않으면 컴포넌트의 크기를 계산해서 자동으로 넓이와 높이 지정해줌
		pack();
		
		//스크린 중앙에 윈도우창을 위치시킴
		setLocation((screenWidth - getWidth())/2, (screenHeight - getHeight())/2);
		//프레임 사이즈 변경 불가능
		setResizable(false);
		//프레임 노출여부 지정
		setVisible(true);
		
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);

		MultiClient cc = new MultiClient("192.168.10.3", "sdngoin");
		try {
			cc.init();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	//이벤트 핸들러 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 발생한 객체를 반환
		Object obj = e.getSource();
		
		if(obj==jtf) {
			//JtextField에서 입력한 데이터 읽기
			String msg = jtf.getText();
			if(msg==null || msg.length() == 0) {//데이터를 입력하지 않았을 경우
				JOptionPane.showMessageDialog(this, "글을 쓰세요!", "경고", JOptionPane.WARNING_MESSAGE);
				
			}else {//데이터를 입력했을 경우
				try {
					//데이터를 서버로 전송
					oos.writeObject(id+"#"+msg);
				}catch(IOException ie) {
					ie.printStackTrace();
				}
				//JTextField 초기화
				jtf.setText("");
			}
		}else if(obj == jbtn) {
			try {
				//서버에 종료 메시지 전송
				oos.writeObject(id+"#exit");
			}catch(IOException ie) {
				ie.printStackTrace();
			}
			//프로그램 종료
			System.exit(0);
		}

	}
	
	//종료처리
	public void exit() {
		System.exit(0);
	}
	
	//입력스트림 반환
	public ObjectInputStream getOis() {
		return ois;
	}
	
	//JTextArea 반환
	public JTextArea getJta() {
		return jta;
	}
	
	//id 반환
	public String getId() {
		return id;
	}

	public void init() throws IOException{
		socket = new Socket(ip,5000);
		System.out.println("connected...");
		//서버에 데이터를 전송할 객체 생성
		oos = new ObjectOutputStream(socket.getOutputStream());
		//서버로부터 전달 받은 데이터를 입력할 객체
		ois = new ObjectInputStream(socket.getInputStream());
		//데이터 처리를 위한 스레드 생성
		MultiClientThread ct = new MultiClientThread(this);
		ct.start();
		
	}
}
