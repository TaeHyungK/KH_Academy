//��Ű���� ���
package com.packone;

import com.packtwo.PackSub;

public class PackMain {
	public static void main(String[] args) {
		com.packone.PackOne p1 = new com.packone.PackOne();
		
		//PackMain�� PackOne�� ���� ��Ű���� �����ϱ� ������ ��Ű���� �����ϰ� ȣ���� ����
		PackOne p2 = new PackOne();
		
		//�ٸ� ��Ű���� Ŭ������ ��ü ����
		//��Ű���� ������ �� ����.
		com.packtwo.PackSub ps = new com.packtwo.PackSub();
		
		//�ٸ� ��Ű���� Ŭ������ ȣ���� ���� import���� �̿��ؼ� Ŭ������ �̸� ����ϰ�
		//Ŭ������ ȣ��� ��Ű���� �����ϴ� ����� ����� �� ����.
		PackSub ps2 = new PackSub();
	}
}
