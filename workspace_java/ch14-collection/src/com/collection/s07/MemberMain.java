package com.collection.s07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MemberMain {
	ArrayList<Member> list;
	BufferedReader br;
	FileWriter fw;
	FileReader fr;

	public MemberMain() {
		list = new ArrayList<Member>();
		br = new BufferedReader(new InputStreamReader(System.in));


	}

	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1.ȸ������ 2.ȸ���α��� 3.��Ϻ��� 4.���Ϸ� ���� 5.����>");

			try {
				int num = Integer.parseInt(br.readLine());
				Member m = new Member();

				if(num==1) {//ȸ������(���̵� �ߺ�üũ ���ص� ��)

					System.out.print("ID> ");
					String id = br.readLine();

					if(checkSameId(id)) {
						System.out.println("���̵� �ߺ��Ǿ����ϴ�.");
					}else {
						m.setId(id);
						System.out.print("Password> ");
						m.setPassword(br.readLine());

						System.out.print("�̸�> ");
						m.setName(br.readLine());

						list.add(m);
						System.out.println("ȸ������ �Ϸ�");
					}


				}else if(num==2) {//ȸ���α���
					int readChar;
					//���̵� �Է�, ��й�ȣ �Է�
					//���̵� �����ϴ� ���θ� �˻�
					//���̵� ���Ե� ��ü ����� ��й�ȣ�� ����
					String mId;
					String mPwd;

					System.out.println("-------�α���------");
					try {
						fr = new FileReader("member.txt");

						System.out.print("ID�Է�> ");
						mId = br.readLine();

						System.out.print("��й�ȣ�Է�> ");
						mPwd = br.readLine();

						Member member = null;

						for(int i=0;i<list.size();i++) {
							if(mId.equals(list.get(i).getId()) && mPwd.equals(list.get(i).getPassword())) {

//								member = m;
								System.out.println("-----�α��� ����-----");
								System.out.println("ID\t��й�ȣ\t�̸�");
								System.out.print(list.get(i).getId() + "\t" 
										+ list.get(i).getPassword() +"\t"
										+ list.get(i).getName()+ "\n");
								break;
							}else {
								System.out.println("�α��� ����");
								break;
							}
						}


					}catch(IOException e) {
						e.printStackTrace();
					}finally {
						if(fr!=null) try {fr.close();} catch(IOException e) {}
					}


				}else if(num==3) {//��Ϻ���
					System.out.println("-------------------------------------");
					System.out.println("ID\t��й�ȣ\t�̸�");
					System.out.println("-------------------------------------");

					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i).getId() 
								+ "\t" + list.get(i).getPassword()
								+"\t" + list.get(i).getName()+"\n");
					}

					System.out.println("--------------------------------");
				}else if(num==4) {//���Ϸ� ����
					String str = "";

					try {
						fw = new FileWriter("member.txt");
						//							os�� �´� ���� ���ڸ� ������
						str += "ID\t��й�ȣ\t�̸�"+System.getProperty("line.separator");
						str += "--------------------------------"+System.getProperty("line.separator");

						for(Member temp : list) {
							str += temp.getId() + "   "
									+ temp.getPassword() + "   "
									+ temp.getName()+System.getProperty("line.separator");
						}

						fw.write(str);

						System.out.println("������ �����Ͽ����ϴ�. ");
					}catch(IOException e) {
						e.printStackTrace();
					}finally {
						if(fw!=null) try { fw.close();} catch(IOException e) {}
					}

				}else if(num==5) {//����
					System.out.println("���α׷� ����");
					break;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�.");
				}
			}catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է°���!");
			}
		}
	}

	//���̵� �ߺ� Ȯ��
	private boolean checkSameId(String id) throws IOException{
		if(list.size() == 0) {
			return false;
		}

		for(Member m : list) {
			if(m.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		MemberMain m = new MemberMain();
		try {
			m.callMenu();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
