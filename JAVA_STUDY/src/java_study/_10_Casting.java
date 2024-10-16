package java_study;

public class _10_Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10;
		int b =3;
		double re = (double)(a / b);
		
		System.out.println("re = "+ re);
		
		double d = 3.92;
		int deci = (int)d; // 버림
		System.out.println("정수부: " + deci);
	}

}
