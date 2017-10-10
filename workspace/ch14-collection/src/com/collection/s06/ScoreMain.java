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

	//메뉴
	public void callMenu() throws IOException {

		while(true) {
			System.out.print("1.성적입력 2.성적출력 3.파일로 출력 4.종료>");
			try {
				int num = Integer.parseInt(br.readLine());

				if(num == 1) { // 입력
					Score score = new Score();

					System.out.print("이름> ");
					score.setName(br.readLine());

					//국어, 영어, 수학은 입력 체크
					score.setKor(parseInputData("국어> "));
					score.setEng(parseInputData("영어> "));
					score.setMath(parseInputData("수학> "));

					list.add(score);

					System.out.println("성적 입력 완료");

				}else if(num == 2) {

					System.out.println("성적 리스트 : 총 계좌수(" + list.size()+")");
					System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
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
					//FileOutputStream 객체 생성
					FileWriter fw = null;
					String str = "--------------------------------------------------"+System.getProperty("line.separator");
					str += "이름	     국어	     영어	     수학	     총점	     평균	     학점\n";
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

					//ArrayList로부터 Score를 반환받아서 Score의 메소드를 
					//호출해서 데이터를 반환받아 파일에 출력


					System.out.println("파일을 생성하고 성적정보를 저장했습니다.");

				}else if(num == 4) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}

			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}
		}
	}

	private int parseInputData(String cours) throws IOException{
		while(true) {
			System.out.print(cours);

			try {
				int num = Integer.parseInt(br.readLine());
				if(num<0 || num>100) {
					throw new ScoreValueException("[0~100 사이의 값만 인정!]");
				}

				return num;
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력하세요!]");

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
