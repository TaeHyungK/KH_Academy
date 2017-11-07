package com.lang.s04;

public class NumberCheckMain {
	public static void main(String[] args) {
		/*
		 * [�ǽ�] ���ڿ� �����Ϳ� ���ڰ� ���ԵǾ��ִ��� ���� Ȯ��
		 */
		String str = "1321ty556";
		String result ="";
		
		//���ڰ� ���ԵǾ� ������ result="���� ����"
		//���ԵǾ� ���� ������ result="������"
		NumberCheckMain nc = new NumberCheckMain();
		
		//1��° ���
		try {
			nc.test(str);
			
			result = "������";
		}catch(NumberFormatException e) {
			result = "���� ����";
		}finally {
			System.out.println(result);
			System.out.println("-----------");
		}
		
		//2��° ���
		result = "������";
		for(char c : str.toCharArray()) {
			if(!Character.isDigit(c)) {//���ڰ� �ƴҰ��
				result = "���ڰ� ���Ե�";
				break;
			}
		}
		System.out.println(result);
		System.out.println("-----------");
		
		//3��° ���
		result = "������";
		for(int i=0;i<str.length();i++) {
			char c= str.charAt(i);
			if(c <48 || c>57) {
				result = "���ڰ� ���Ե�";
				break;
			}
		}
		System.out.println(result);
	}
	
	public void test(String str) throws NumberFormatException {
		Integer.parseInt(str);
	}
}
