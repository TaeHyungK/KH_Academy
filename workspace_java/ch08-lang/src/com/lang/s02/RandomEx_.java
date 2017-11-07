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
         System.out.print("당신이 " + num + " 번째 뽑은 로또 번호는 ");

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
         System.out.print(" 입니다  >    ");
         
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
            System.out.println("1등 당첨되었습니다. 축하드립니다.");
            g1++;
            break a;
         } else if (count == 3) {
            System.out.println("5등 당첨되었습니다.");
            g5++;
         } else if (count == 4) {
            System.out.println("4등 당첨되었습니다.");
            g4++;
         } else if (count == 5) {
            if (bonus == 0) {
               System.out.println("3등 당첨되었습니다.");
               g3++;
            } else {
               System.out.println("2등 당첨되었습니다.");
               g2++;
            }
         } else {
            System.out.println("당첨되지않았습니다.");
            g6++;
         }

      }
      System.out.println("=========================================");
      System.out.print("로또 당첨 번호 : ");

      for (int i = 0; i < 6; i++) {
         System.out.print("[" + lotto[i] + "] ");
      }
      System.out.println("+ [" + lotto[6] + "] ");

      System.out.println();

      System.out.println("당첨되지 않은 횟수는 " + g6 + "번 입니다.");
      System.out.println("5등은 " + g5 + "번 당첨되셨습니다.");
      System.out.println("4등은 " + g4 + "번 당첨되셨습니다.");
      System.out.println("3등은 " + g3 + "번 당첨되셨습니다.");
      System.out.println("2등은 " + g2 + "번 당첨되셨습니다.");
      System.out.println("1등 당첨까지 " + num + "번 시도하셨습니다.");
      System.out.println("총 구매하신 돈 : " + (num * 1000) + "원");
      System.out.printf("1등 당첨 확률은 %.8f 입니다.\n", ((double) 1 / num) * 100);
   }
}