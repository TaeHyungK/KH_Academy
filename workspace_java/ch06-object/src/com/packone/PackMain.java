//패키지명 명시
package com.packone;

import com.packtwo.PackSub;

public class PackMain {
	public static void main(String[] args) {
		com.packone.PackOne p1 = new com.packone.PackOne();
		
		//PackMain과 PackOne이 같은 패키지에 존재하기 때문에 패키지를 생략하고 호출이 가능
		PackOne p2 = new PackOne();
		
		//다른 패키지의 클래스를 객체 생성
		//패키지를 생략할 수 없음.
		com.packtwo.PackSub ps = new com.packtwo.PackSub();
		
		//다른 패키지의 클래스를 호출할 때는 import문을 이용해서 클래스를 미리 등록하고
		//클래스를 호출시 패키지를 생략하는 방법을 사용할 수 있음.
		PackSub ps2 = new PackSub();
	}
}
