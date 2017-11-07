package com.iostream.s01;

import java.io.File;

public class FileMain05 {
   public static void main(String[] args) {
      String path = "D:"+File.separator+"javaWork"
                  +File.separator+"example.txt";
      File f = new File(path);
      System.out.println("===파일 삭제===");
      
      //delete() : 삭제할 수 있으면 삭제하고 true 반환
      //          삭제할 수 없으면 false 반환
      if(f.delete()) {
         System.out.println(f.getName()+" 파일 삭제");
      }else {
         System.out.println("파일이 존재하지 않습니다.");
      }
      
   }
}