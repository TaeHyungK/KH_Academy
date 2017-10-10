package com.collection.s06;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ScoreMain {
	BufferedReader br;
	ArrayList<Score> list;

	int input_kor;
	int input_eng;
	int input_math;

	public ScoreMain() {
		br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<Score>();


	}

	//�޴�
	public void callMenu() throws IOException {

		while(true) {
			System.out.print("1.�����Է� 2.������� 3.���Ϸ� ��� 4.����>");
			try {
				int num = Integer.parseInt(br.readLine());

				if(num == 1) { // �Է�
					Score score = new Score();

					System.out.print("�̸�> ");
					score.setName(br.readLine());

					//����, ����, ������ �Է� üũ
					score.setKor(parseInputData("����> "));
					score.setEng(parseInputData("����> "));
					score.setMath(parseInputData("����> "));

					list.add(score);

					System.out.println("���� �Է� �Ϸ�");

				}else if(num == 2) {

					System.out.println("���� ����Ʈ : �� ���¼�(" + list.size()+")");
					System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
					System.out.println("-------------------------------------");

					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i).getName() + "\t"
								+list.get(i).getKor() + "\t"
								+list.get(i).getEng() + "\t"
								+list.get(i).getMath() + "\t"
								+list.get(i).makeSum() + "\t");
						System.out.printf("%.2f\t", list.get(i).makeAvg());
						System.out.println(list.get(i).makeGrade());
					}

					System.out.println("-------------------------------------");
				}else if(num ==3) {
					//FileOutputStream ��ü ����
					FileWriter fw = null;
					String str = "--------------------------------------------------"+System.getProperty("line.separator");
					str += "�̸�	     ����	     ����	     ����	     ����	     ���	     ����\n";
					str += "--------------------------------------------------"+System.getProperty("line.separator");
					try {
						fw = new FileWriter("score.txt");

						for(Score s : list) {
							str += s.toString() +System.getProperty("line.separator");
						}
						
						fw.write(str);
						
					}catch(IOException e) {
						e.printStackTrace();
					}finally {
						if (fw!=null) try {fw.close();} catch(IOException e) {}
					}

					//ArrayList�κ��� Score�� ��ȯ�޾Ƽ� Score�� �޼ҵ带 
					//ȣ���ؼ� �����͸� ��ȯ�޾� ���Ͽ� ���


					System.out.println("������ �����ϰ� ���������� �����߽��ϴ�.");

				}else if(num == 4) {
					System.out.println("���α׷� ����");
					break;
				}else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}

			}catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է� ����");
			}
		}
	}

	private int parseInputData(String cours) throws IOException{
		while(true) {
			System.out.print(cours);

			try {
				int num = Integer.parseInt(br.readLine());
				if(num<0 || num>100) {
					throw new ScoreValueException("[0~100 ������ ���� ����!]");
				}

				return num;
			}catch(NumberFormatException e) {
				System.out.println("[���ڸ� �Է��ϼ���!]");

			}catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {

		ScoreMain sm = new ScoreMain();
		try {
			sm.callMenu();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
}
