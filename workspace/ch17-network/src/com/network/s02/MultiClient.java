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
		//���� ����
		super("Multi Chatting");
		
		this.ip = ip;
		this.id = id;
		
		jtf = new JTextField(30);
		jta = new JTextArea(10,50);
		jlb1 = new JLabel("ID:["+id+"] ");
		jlb2 = new JLabel("IP: " + ip);
		jbtn = new JButton("����");
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jta.setBackground(Color.PINK);
		jp1.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());
		
		//JButton�� JPanel�� ���
		jp1.add(jbtn, BorderLayout.EAST);
		//JTextField�� JPanel�� ���
		jp1.add(jtf, BorderLayout.CENTER);
		//JLabel�� JPanel�� ���
		jp2.add(jlb1, BorderLayout.CENTER);
		jp2.add(jlb2, BorderLayout.EAST);
		
		//JPanel�� JFrame�� ���
		add(jp1, BorderLayout.SOUTH); 
		add(jp2, BorderLayout.NORTH);
		
		//JTextArea ��ũ�� ó��
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//JscrollPane�� JFrame�� ���
		add(jsp,BorderLayout.CENTER);
		
		//JTextArea ���� �Ұ���
		jta.setEditable(false);
		
		//�̺�Ʈ �ҽ��� �̺�Ʈ ������ ����
		jtf.addActionListener(this);
		jbtn.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			//�̺�Ʈ �ڵ鷯
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					//������ ���� �޽��� ����
					oos.writeObject(MultiClient.this.id+"#exit");
				}catch(IOException ie) {
					ie.printStackTrace();
				}
				//���α׷� ����
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				//�������� ȭ�鿡 �������� ��Ŀ���� JTextField�� ��
				jtf.requestFocus();
			}
			
		});
		
		//��ũ�� ������ ���ϱ� ���� Toolkit��ü ����
		Toolkit tk = Toolkit.getDefaultToolkit();
		//��ũ�� ũ�⸦ �о��
		Dimension d = tk.getScreenSize();
		int screenWidth = d.width;
		int screenHeight = d.height;
		
		//JFrame ����� �������� ������ ������Ʈ�� ũ�⸦ ����ؼ� �ڵ����� ���̿� ���� ��������
		pack();
		
		//��ũ�� �߾ӿ� ������â�� ��ġ��Ŵ
		setLocation((screenWidth - getWidth())/2, (screenHeight - getHeight())/2);
		//������ ������ ���� �Ұ���
		setResizable(false);
		//������ ���⿩�� ����
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

	//�̺�Ʈ �ڵ鷯 ����
	@Override
	public void actionPerformed(ActionEvent e) {
		//�̺�Ʈ�� �߻��� ��ü�� ��ȯ
		Object obj = e.getSource();
		
		if(obj==jtf) {
			//JtextField���� �Է��� ������ �б�
			String msg = jtf.getText();
			if(msg==null || msg.length() == 0) {//�����͸� �Է����� �ʾ��� ���
				JOptionPane.showMessageDialog(this, "���� ������!", "���", JOptionPane.WARNING_MESSAGE);
				
			}else {//�����͸� �Է����� ���
				try {
					//�����͸� ������ ����
					oos.writeObject(id+"#"+msg);
				}catch(IOException ie) {
					ie.printStackTrace();
				}
				//JTextField �ʱ�ȭ
				jtf.setText("");
			}
		}else if(obj == jbtn) {
			try {
				//������ ���� �޽��� ����
				oos.writeObject(id+"#exit");
			}catch(IOException ie) {
				ie.printStackTrace();
			}
			//���α׷� ����
			System.exit(0);
		}

	}
	
	//����ó��
	public void exit() {
		System.exit(0);
	}
	
	//�Է½�Ʈ�� ��ȯ
	public ObjectInputStream getOis() {
		return ois;
	}
	
	//JTextArea ��ȯ
	public JTextArea getJta() {
		return jta;
	}
	
	//id ��ȯ
	public String getId() {
		return id;
	}

	public void init() throws IOException{
		socket = new Socket(ip,5000);
		System.out.println("connected...");
		//������ �����͸� ������ ��ü ����
		oos = new ObjectOutputStream(socket.getOutputStream());
		//�����κ��� ���� ���� �����͸� �Է��� ��ü
		ois = new ObjectInputStream(socket.getInputStream());
		//������ ó���� ���� ������ ����
		MultiClientThread ct = new MultiClientThread(this);
		ct.start();
		
	}
}
