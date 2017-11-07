package com.algol;

import java.util.ArrayList;
import java.util.Scanner;

class Stack{
	ArrayList<Integer> mStack = new ArrayList<Integer>();

	public void push(int x) {
		mStack.add(x);
	}
	public void pop() {
		if(mStack.size()==0) System.out.println("-1");
		else {
			System.out.println(mStack.get(mStack.size()-1));
			mStack.remove(mStack.size()-1);
		}

	}
	public void size() {
		System.out.println(mStack.size());
	}
	public void empty() {
		if(mStack.size() == 0) System.out.println("1");
		else System.out.println("0");
	}
	public void top() {
		if(mStack.size()==0) System.out.println("-1");
		else {
			System.out.println(mStack.get(mStack.size()-1));
		}
	}
}

public class Algol10828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();

		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String command = sc.next();
			int x;
			switch(command) {
			case "push":
				x = sc.nextInt();
				s.push(x);
				break;
			case "pop":
				s.pop();
				break;
			case "size":
				s.size();
				break;
			case "empty":
				s.empty();
				break;
			case "top":
				s.top();
				break;
			}
		}

	}


}
