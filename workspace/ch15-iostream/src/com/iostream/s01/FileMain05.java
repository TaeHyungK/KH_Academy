package com.iostream.s01;

import java.io.File;

public class FileMain05 {
   public static void main(String[] args) {
      String path = "D:"+File.separator+"javaWork"
                  +File.separator+"example.txt";
      File f = new File(path);
      System.out.println("===���� ����===");
      
      //delete() : ������ �� ������ �����ϰ� true ��ȯ
      //          ������ �� ������ false ��ȯ
      if(f.delete()) {
         System.out.println(f.getName()+" ���� ����");
      }else {
         System.out.println("������ �������� �ʽ��ϴ�.");
      }
      
   }
}