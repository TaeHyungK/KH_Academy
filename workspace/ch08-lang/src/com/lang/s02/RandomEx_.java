package com.lang.s02;

public class RandomEx_ {
   public static void main(String[] args) {
      int lotto[] = new int[7];
      int myLotto[] = new int[6];

      int num = 0;

      int g1 = 0, g2 = 0, g3 = 0, g4 = 0, g5 = 0, g6 = 0;

      for (int i = 0; i < lotto.length; i++) {
         lotto[i] = (int) (Math.random() * 45) + 1;
         for (int j = 0; j < i; j++) {
            if (lotto[i] == lotto[j]) {
               i--;
               break;
            }
         }
      }

      a: 
      while (true) {
         num++;
         int bonus = 0;
         int count = 0;
         System.out.print("����� " + num + " ��° ���� �ζ� ��ȣ�� ");

         for (int i = 0; i < myLotto.length; i++) {
            myLotto[i] = (int) (Math.random() * 45) + 1;
            for (int j = 0; j < i; j++) {
               if (myLotto[i] == myLotto[j]) {
                  i--;
                  break;
               }
            }

            System.out.print(myLotto[i] + " ");
         }
         System.out.print(" �Դϴ�  >    ");
         
         System.out.println();
         for(int i=0;i<lotto.length;i++) {
        	 System.out.print(lotto[i]+ " ");
         }
         System.out.println();

         
         
         for (int i = 0; i < myLotto.length; i++) {
            if (lotto[6] == myLotto[i])
               bonus++;
            for (int j = 0; j < myLotto.length; j++) {
               if (lotto[i] == myLotto[j])
                  count++;
            }
         }

         if (count == 6) {
            System.out.println("1�� ��÷�Ǿ����ϴ�. ���ϵ帳�ϴ�.");
            g1++;
            break a;
         } else if (count == 3) {
            System.out.println("5�� ��÷�Ǿ����ϴ�.");
            g5++;
         } else if (count == 4) {
            System.out.println("4�� ��÷�Ǿ����ϴ�.");
            g4++;
         } else if (count == 5) {
            if (bonus == 0) {
               System.out.println("3�� ��÷�Ǿ����ϴ�.");
               g3++;
            } else {
               System.out.println("2�� ��÷�Ǿ����ϴ�.");
               g2++;
            }
         } else {
            System.out.println("��÷�����ʾҽ��ϴ�.");
            g6++;
         }

      }
      System.out.println("=========================================");
      System.out.print("�ζ� ��÷ ��ȣ : ");

      for (int i = 0; i < 6; i++) {
         System.out.print("[" + lotto[i] + "] ");
      }
      System.out.println("+ [" + lotto[6] + "] ");

      System.out.println();

      System.out.println("��÷���� ���� Ƚ���� " + g6 + "�� �Դϴ�.");
      System.out.println("5���� " + g5 + "�� ��÷�Ǽ̽��ϴ�.");
      System.out.println("4���� " + g4 + "�� ��÷�Ǽ̽��ϴ�.");
      System.out.println("3���� " + g3 + "�� ��÷�Ǽ̽��ϴ�.");
      System.out.println("2���� " + g2 + "�� ��÷�Ǽ̽��ϴ�.");
      System.out.println("1�� ��÷���� " + num + "�� �õ��ϼ̽��ϴ�.");
      System.out.println("�� �����Ͻ� �� : " + (num * 1000) + "��");
      System.out.printf("1�� ��÷ Ȯ���� %.8f �Դϴ�.\n", ((double) 1 / num) * 100);
   }
}