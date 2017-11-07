package com.jdbc.s07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ScoreMain {
	public static void main(String[] args) {
		//DB의 데이터를 처리하는 DAO(Data Access Object) 생성
		ScoreDao dao = new ScoreDao();
		
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			while(true) {
				System.out.println("1.성적입력 2.성적보기 3.성적수정 4.성적삭제 5.종료");
				System.out.print("선택> ");
				
				String num = br.readLine();
				
				if(num.equals("1")) {
					//성적입력
					System.out.print("이름: ");
					String name = br.readLine();
					
					System.out.print("국어: ");
					int kor = Integer.parseInt(br.readLine());
					
					System.out.print("영어: ");
					int eng = Integer.parseInt(br.readLine());
					
					System.out.print("수학: ");
					int math = Integer.parseInt(br.readLine());
					
					//입력받은 데이터를 저장할 Score객체 생성
					Score sc = new Score();
					sc.setName(name);
					sc.setKor(kor);
					sc.setEng(eng);
					sc.setMath(math);
					
					//Score객체를 ScoreDao의 insertInfo() 메소드에 전달해서 DB연동 작업이 성공하면 true, 실패하면 false 반환
					boolean f = dao.insertInfo(sc);
					if(f) {
						System.out.println("성적 입력이 완료되었습니다.");
					}else {
						System.out.println("성적 입력에 실패하였습니다.");
					}
					
				}else if(num.equals("2")) {
					System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급\t등록날짜");
					
					//정보보기
					ArrayList<Score> list = dao.selectInfo();
					
					//반복문을 이용해 Score를 ArrayList에 반환받고 Score의 메소드를 이용해 횡단위로 출력
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
					//수정
					System.out.print("수정할 성적 번호 입력> ");
					int sNum = Integer.parseInt(br.readLine());
					
					System.out.print("이름: ");
					String name = br.readLine();
					
					System.out.print("국어: ");
					int kor = Integer.parseInt(br.readLine());
					
					System.out.print("영어: ");
					int eng = Integer.parseInt(br.readLine());
					
					System.out.print("수학: ");
					int math = Integer.parseInt(br.readLine());
					
					Score sc = new Score();
					sc.setNum(sNum);
					sc.setName(name);
					sc.setKor(kor);
					sc.setEng(eng);
					sc.setMath(math);
					
					//Score객체를 updateInfo에 전달
					boolean f = dao.updateInfo(sc);
					
					if(f) {
						System.out.println("성적 수정을 완료하였습니다.");
					}else {
						System.out.println("성적 수정에 실패했습니다.");
					}
					
					
				}else if(num.equals("4")) {
					//삭제
					System.out.print("성적 번호 입력> ");
					int sNum = Integer.parseInt(br.readLine());
					
					boolean f = dao.deleteInfo(sNum);
					
					if(f) {
						System.out.println("성적 정보가 삭제되었습니다.");
					}else {
						System.out.println("성적 삭제에 실패했습니다.");
					}
					
				}else if(num.equals("5")) {
					//종료
					System.out.println("성적 관리 프로그램 종료!");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}

			}
		}catch(Exception e) {

		}finally {
			if(br != null) try {br.close();} catch(Exception e) {}
		}
	}
}
