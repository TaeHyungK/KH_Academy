package com.iostream.s01;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMain02 {
	public static void main(String[] args) {
		String path = "C:\\";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");
		
		File f = new File(path);
		
		//지정한 디렉토리의 하위 디렉토리와 파일 정보 반환
		File[] files = f.listFiles();
		
		String attribute = "";
		String size = "";
		String name = "";
		
		
		for(int i=0;i<files.length;i++) {
			File f2= files[i];
			name = f2.getName();
			
			if(f2.isDirectory()) {//디렉토리
				size = "0";
				attribute = "DIR";
			}else {//파일
				size = f2.length()+"";
				attribute = f.canRead() ? "R" : "";
				attribute += f.canWrite() ? "W" : "";
				attribute += f.isHidden() ? "H" : "";
				
			}
			
			System.out.printf("%s %3s %10s %s\n", 
					df.format(new Date(f2.lastModified())), attribute, size, name);
			
		}
	}
}
