package com.jdbc.s07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ScoreMain {
	public static void main(String[] args) {
		//DB�� �����͸� ó���ϴ� DAO(Data Access Object) ����
		ScoreDao dao = new ScoreDao();
		
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			while(true) {
				System.out.println("1.�����Է� 2.�������� 3.�������� 4.�������� 5.����");
				System.out.print("����> ");
				
				String num = br.readLine();
				
				if(num.equals("1")) {
					//�����Է�
					System.out.print("�̸�: ");
					String name = br.readLine();
					
					System.out.print("����: ");
					int kor = Integer.parseInt(br.readLine());
					
					System.out.print("����: ");
					int eng = Integer.parseInt(br.readLine());
					
					System.out.print("����: ");
					int math = Integer.parseInt(br.readLine());
					
					//�Է¹��� �����͸� ������ Score��ü ����
					Score sc = new Score();
					sc.setName(name);
					sc.setKor(kor);
					sc.setEng(eng);
					sc.setMath(math);
					
					//Score��ü�� ScoreDao�� insertInfo() �޼ҵ忡 �����ؼ� DB���� �۾��� �����ϸ� true, �����ϸ� false ��ȯ
					boolean f = dao.insertInfo(sc);
					if(f) {
						System.out.println("���� �Է��� �Ϸ�Ǿ����ϴ�.");
					}else {
						System.out.println("���� �Է¿� �����Ͽ����ϴ�.");
					}
					
				}else if(num.equals("2")) {
					System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���\t���\t��ϳ�¥");
					
					//��������
					ArrayList<Score> list = dao.selectInfo();
					
					//�ݺ����� �̿��� Score�� ArrayList�� ��ȯ�ް� Score�� �޼ҵ带 �̿��� Ⱦ������ ���
					for(Score sc : list) {
						System.out.print(sc.getNum()+"\t");
						System.out.print(sc.getName()+"\t");
						System.out.print(sc.getKor()+"\t");
						System.out.print(sc.getEng()+"\t");
						System.out.print(sc.getMath()+"\t");
						System.out.print(sc.getSum()+"\t");
						System.out.print(sc.getAvg()+"\t");
						System.out.print(sc.getGrade()+"\t");
						System.out.print(sc.getReg_date()+"\n");
					}
				}else if(num.equals("3")) {
					//����
					System.out.print("������ ���� ��ȣ �Է�> ");
					int sNum = Integer.parseInt(br.readLine());
					
					System.out.print("�̸�: ");
					String name = br.readLine();
					
					System.out.print("����: ");
					int kor = Integer.parseInt(br.readLine());
					
					System.out.print("����: ");
					int eng = Integer.parseInt(br.readLine());
					
					System.out.print("����: ");
					int math = Integer.parseInt(br.readLine());
					
					Score sc = new Score();
					sc.setNum(sNum);
					sc.setName(name);
					sc.setKor(kor);
					sc.setEng(eng);
					sc.setMath(math);
					
					//Score��ü�� updateInfo�� ����
					boolean f = dao.updateInfo(sc);
					
					if(f) {
						System.out.println("���� ������ �Ϸ��Ͽ����ϴ�.");
					}else {
						System.out.println("���� ������ �����߽��ϴ�.");
					}
					
					
				}else if(num.equals("4")) {
					//����
					System.out.print("���� ��ȣ �Է�> ");
					int sNum = Integer.parseInt(br.readLine());
					
					boolean f = dao.deleteInfo(sNum);
					
					if(f) {
						System.out.println("���� ������ �����Ǿ����ϴ�.");
					}else {
						System.out.println("���� ������ �����߽��ϴ�.");
					}
					
				}else if(num.equals("5")) {
					//����
					System.out.println("���� ���� ���α׷� ����!");
					break;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�.");
				}

			}
		}catch(Exception e) {

		}finally {
			if(br != null) try {br.close();} catch(Exception e) {}
		}
	}
}
