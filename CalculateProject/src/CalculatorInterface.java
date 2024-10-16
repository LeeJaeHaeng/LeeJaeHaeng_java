import java.awt.*;
import javax.swing.*;

public class CalculatorInterface extends JFrame{
	JTextField tf = new JTextField();
	JButton[] numberBnts = new JButton[10];
	JButton clearBnt;
	JButton enterBnt;
	JButton dotBnt; // . 버튼
	JButton rootBnt; // 루트 버튼
	JButton addBnt; // + 버튼
	JButton subBnt; // - 버튼
	JButton mulBnt; // * 버튼
	JButton divBnt; // 나누기 버튼
	Container firstContainer;
	JPanel secondContainer;
	JPanel thirdContainer;
	
	CalculatorInterface(){
		CreateButtons();  //사용되는 버튼들의 생성 담당
		setContainer();  //컨테이너들의 배치 및 배치관리자 추가 작업 담당
		setComponents();  //컴퍼넌트들을 컨테이너에 올려주는 작업, 기타 세부 세팅
		
		setTitle("이재행의 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		setVisible(true);
	}
	public void CreateButtons() {
		int i;
		for(i=0; i<10; i++) {
			numberBnts[i] = new JButton("" + i);
		}
		clearBnt = new JButton("Clear");
		enterBnt = new JButton("Enter");
		rootBnt = new JButton("\u221A");
		addBnt = new JButton("+");
		subBnt = new JButton("-");
		mulBnt = new JButton("*");
		divBnt = new JButton("/");
		dotBnt = new JButton(".");
	}
	public void setContainer( ) {
		// 컨테이너 객체 확보 작업
		firstContainer = getContentPane();
		secondContainer = new JPanel();
		thirdContainer = new JPanel();
		//배치관리자 추가 작업
		firstContainer.setLayout(new BorderLayout(5,5));
		secondContainer.setLayout(new BorderLayout(5,5));
		thirdContainer.setLayout(new GridLayout(4,4,5,5));
		//컨테이너 적층
		firstContainer.add(secondContainer, BorderLayout.CENTER);
		secondContainer.add(thirdContainer, BorderLayout.CENTER);
		//적층 확인용 배경색 추가
		//firstContainer.setBackground(Color.RED);
		//secondContainer.setBackground(Color.BLUE);
		//thirdContainer.setBackground(Color.YELLOW);
		
	}
	public void setComponents() {
		firstContainer.add(enterBnt, BorderLayout.SOUTH);
		
		firstContainer.add(tf, BorderLayout.NORTH); 
        Font font = new Font("Arial", Font.BOLD, 40); // 텍스트필드 옵션 추가: 폰트 Arial, 볼드체, 크기 30, 우측정렬
        tf.setFont(font); // 텍스트 필드에 폰트 적용
        tf.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽 정렬
        
		secondContainer.add(clearBnt, BorderLayout.NORTH);
		thirdContainer.add(numberBnts[1]);
		thirdContainer.add(numberBnts[2]);
		thirdContainer.add(numberBnts[3]);
		thirdContainer.add(addBnt);
		
		thirdContainer.add(numberBnts[4]);
		thirdContainer.add(numberBnts[5]);
		thirdContainer.add(numberBnts[6]);
		thirdContainer.add(subBnt);
		
		thirdContainer.add(numberBnts[7]);
		thirdContainer.add(numberBnts[8]);
		thirdContainer.add(numberBnts[9]);
		thirdContainer.add(mulBnt);
		
		thirdContainer.add(numberBnts[0]);
		thirdContainer.add(dotBnt);
		thirdContainer.add(rootBnt);
		thirdContainer.add(divBnt);
		
	}
}
