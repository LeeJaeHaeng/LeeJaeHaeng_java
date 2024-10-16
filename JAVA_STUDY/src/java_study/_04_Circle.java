package java_study;

public class _04_Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double PI = 3.141592; // 변수 선언하면서 초기화, final은 상수선언(수정불가)
		double area, circumference; // 같은 타입의 변수를 연속으로 선언 가능 
		int radius = 5;
		area = PI * radius * radius; // pi *r ^ 2
		circumference = 2 * PI * radius; // 2 * pi * r
		
		System.out.println("원의 넓이는 " + area + "입니다.");
		System.out.println("원의 둘레는 " + circumference + "입니다.");

	}

}
