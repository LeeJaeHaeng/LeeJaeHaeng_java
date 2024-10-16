package java_study;

import java.util.Scanner;

public class _06_YardtoMeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final double ONE_YARD = 0.9144;
		
		System.out.print("야드 입력:");
		Scanner in = new Scanner(System.in);
		
		double yard = in.nextDouble();
		in.close();
		
		double meter = yard * ONE_YARD;
		System.out.println(yard + "yard 는 " + meter + "meter 입니다.");
		
	}

}
