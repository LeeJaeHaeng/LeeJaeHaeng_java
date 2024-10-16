package java_study;

import java.util.Scanner;

public class _05_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		System.out.print("정수 입력 :");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		
		System.out.println("입력받은 정수는 " + n + ("입니다."));
	}

}
