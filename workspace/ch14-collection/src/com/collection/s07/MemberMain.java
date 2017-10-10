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
			System.out.print("1.회원가입 2.회원로그인 3.목록보기 4.파일로 저장 5.종료>");

			try {
				int num = Integer.parseInt(br.readLine());
				Member m = new Member();

				if(num==1) {//회원가입(아이디 중복체크 안해도 됨)

					System.out.print("ID> ");
					String id = br.readLine();

					if(checkSameId(id)) {
						System.out.println("아이디가 중복되었습니다.");
					}else {
						m.setId(id);
						System.out.print("Password> ");
						m.setPassword(br.readLine());

						System.out.print("이름> ");
						m.setName(br.readLine());

						list.add(m);
						System.out.println("회원가입 완료");
					}


				}else if(num==2) {//회원로그인
					int readChar;
					//아이디 입력, 비밀번호 입력
					//아이디가 존재하는 여부를 검색
					//아이디 포함된 객체 저장된 비밀번호와 대조
					String mId;
					String mPwd;

					System.out.println("-------로그인------");
					try {
						fr = new FileReader("member.txt");

						System.out.print("ID입력> ");
						mId = br.readLine();

						System.out.print("비밀번호입력> ");
						mPwd = br.readLine();

						Member member = null;

						for(int i=0;i<list.size();i++) {
							if(mId.equals(list.get(i).getId()) && mPwd.equals(list.get(i).getPassword())) {

//								member = m;
								System.out.println("-----로그인 성공-----");
								System.out.println("ID\t비밀번호\t이름");
								System.out.print(list.get(i).getId() + "\t" 
										+ list.get(i).getPassword() +"\t"
										+ list.get(i).getName()+ "\n");
								break;
							}else {
								System.out.println("로그인 실패");
								break;
							}
						}


					}catch(IOException e) {
						e.printStackTrace();
					}finally {
						if(fr!=null) try {fr.close();} catch(IOException e) {}
					}


				}else if(num==3) {//목록보기
					System.out.println("-------------------------------------");
					System.out.println("ID\t비밀번호\t이름");
					System.out.println("-------------------------------------");

					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i).getId() 
								+ "\t" + list.get(i).getPassword()
								+"\t" + list.get(i).getName()+"\n");
					}

					System.out.println("--------------------------------");
				}else if(num==4) {//파일로 저장
					String str = "";

					try {
						fw = new FileWriter("member.txt");
						//							os에 맞는 엔터 문자를 가져옴
						str += "ID\t비밀번호\t이름"+System.getProperty("line.separator");
						str += "--------------------------------"+System.getProperty("line.separator");

						for(Member temp : list) {
							str += temp.getId() + "   "
									+ temp.getPassword() + "   "
									+ temp.getName()+System.getProperty("line.separator");
						}

						fw.write(str);

						System.out.println("파일을 생성하였습니다. ");
					}catch(IOException e) {
						e.printStackTrace();
					}finally {
						if(fw!=null) try { fw.close();} catch(IOException e) {}
					}

				}else if(num==5) {//종료
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}catch(NumberFormatException e) {
				System.out.println("숫자만 입력가능!");
			}
		}
	}

	//아이디 중복 확인
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
