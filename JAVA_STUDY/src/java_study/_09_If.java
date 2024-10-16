package java_study;
import java.util.Scanner;
public class _09_If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n1, n2;
		
		System.out.println("두 수 입력: ");
		n1 = in.nextInt();
		n2 = in.nextInt();
		
		int large;
		large = n1 > n2 ? n1 : n2; // 조건 연산자
		
		System.out.println("두 수 중 큰 수는 " +large + " 입니다.");
	}

}
