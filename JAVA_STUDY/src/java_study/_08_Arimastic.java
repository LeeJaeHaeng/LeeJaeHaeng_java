package java_study;
import java.util.Scanner;
public class _08_Arimastic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("분 입력: ");
		int inMin = in.nextInt();
		int hour = inMin / 60; // 정수 연산의 결과는 정수(정수 나눗셈의 결과는 몫)
		int minute = inMin % 60; // 나머지
		
		System.out.printf("%d분은 %d시간 %d분 입니다. \n", inMin, hour, minute);
		
		in.close();
	}

}
