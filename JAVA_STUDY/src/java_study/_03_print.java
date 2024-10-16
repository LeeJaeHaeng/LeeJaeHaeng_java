package java_study;

public class _03_print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("apple");
		System.out.print("banana");
		System.out.print("orange");
		System.out.println("\n");
		
		System.out.println("5"); //정수
		System.out.println("5.897"); // 실수
		System.out.println('A'); // 문자: 작은 따음표
		System.out.println(""); // 한칸띄기
		
		// 연산 결과 출력
		System.out.println(3+5);
		System.out.println(3.9 * 5.72);
		System.out.println(10 / 3); // 정수의 나눗셈의 결과는 몫
		System.out.println(10 / 3.0); 
		System.out.println("");
		
		// 문자열 상수와 다른 상수를 열결해서 출력
		System.out.println("덧셈 결과는" + (3 + 5));
		System.out.println("뺼셈 결과는" + (3 - 5));
		System.out.println("곱셈 결과는" + (3 * 5) + "입니다.");
		System.out.println("");
		
		//print(format)
		// %d : decimal : 10진 정수
		// %f : float : 실수(고정소수점 이하 6자리)
		// %c : character : 문자
		// %s : string : 문자열
		System.out.printf("덧셈 결과는 %d 입니다.\n", 7 + 1234);
		System.out.printf("%d + %d = %d\n", 3, 5, 3 + 5);
		System.out.printf("실수는 %f입니다.\n", 3.4198);
		System.out.printf("실수는 %.2f입니다.\n", 3.4198); //반올림
		System.out.printf("실수는 %.1f입니다.\n", 3.4198); //반올림
		System.out.printf("문자 : %c\n", 'T');
		System.out.printf("문자열 : %s\n", "Write once");
	}

}
