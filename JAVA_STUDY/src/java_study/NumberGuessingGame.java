package java_study;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int randomNumber = random.nextInt(100) + 1; // 1부터 100 사이의 랜덤 숫자
        int guess = 0; // 사용자의 추측
        int attempts = 0; // 시도 횟수

        System.out.println("1부터 100 사이의 숫자를 맞춰보세요!");

        while (guess != randomNumber) {
            System.out.print("숫자를 입력하세요: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("더 큰 숫자를 시도해 보세요.");
            } else if (guess > randomNumber) {
                System.out.println("더 작은 숫자를 시도해 보세요.");
            } else {
                System.out.println("정답입니다! " + attempts + "번 만에 맞췄습니다.");
            }
        }

        scanner.close();
    }
}
