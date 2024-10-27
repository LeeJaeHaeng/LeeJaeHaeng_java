import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorInterface extends JFrame {
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

    StringBuilder input = new StringBuilder(); // 입력을 저장할 StringBuilder

    CalculatorInterface() {
        CreateButtons();
        setContainer();
        setComponents();
        
        setTitle("이재행의 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
    }
    
    public void CreateButtons() {
        for (int i = 0; i < 10; i++) {
            numberBnts[i] = new JButton("" + i);
            final int num = i; // final로 설정하여 람다 표현식에서 사용할 수 있게 함
            numberBnts[i].addActionListener(e -> addInput(String.valueOf(num)));
        }
        clearBnt = new JButton("Clear");
        clearBnt.addActionListener(e -> clearInput());
        
        enterBnt = new JButton("Enter");
        enterBnt.addActionListener(e -> calculateResult());
        
        rootBnt = new JButton("\u221A");
        addBnt = new JButton("+");
        subBnt = new JButton("-");
        mulBnt = new JButton("*");
        divBnt = new JButton("/");
        
        // 연산자 버튼에 대한 이벤트 리스너 추가
        addBnt.addActionListener(e -> addInput("+"));
        subBnt.addActionListener(e -> addInput("-"));
        mulBnt.addActionListener(e -> addInput("*"));
        divBnt.addActionListener(e -> addInput("/"));
        dotBnt = new JButton(".");
        dotBnt.addActionListener(e -> addInput("."));
    }
    
    public void setContainer() {
        firstContainer = getContentPane();
        secondContainer = new JPanel();
        thirdContainer = new JPanel();
        
        firstContainer.setLayout(new BorderLayout(5, 5));
        secondContainer.setLayout(new BorderLayout(5, 5));
        thirdContainer.setLayout(new GridLayout(4, 4, 5, 5));
        
        firstContainer.add(secondContainer, BorderLayout.CENTER);
        secondContainer.add(thirdContainer, BorderLayout.CENTER);
    }
    
    public void setComponents() {
        firstContainer.add(enterBnt, BorderLayout.SOUTH);
        firstContainer.add(tf, BorderLayout.NORTH);
        
        Font font = new Font("Arial", Font.BOLD, 40);
        tf.setFont(font);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        
        secondContainer.add(clearBnt, BorderLayout.NORTH);
        addButtonsToPanel();

        // 키보드 입력 이벤트 리스너 추가
        tf.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "calculate");
        tf.getActionMap().put("calculate", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });

        tf.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"), "backspace");
        tf.getActionMap().put("backspace", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.length() > 0) {
                    input.deleteCharAt(input.length() - 1);
                    tf.setText(input.toString());
                }
            }
        });

        // 숫자 및 연산자 키 입력 처리
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar) || keyChar == '+' || keyChar == '-' || keyChar == '*' || keyChar == '/' || keyChar == '.') {
                    addInput(String.valueOf(keyChar));
                    // 텍스트 필드 내용을 지우고 방금 입력한 문자만 표시
                    e.consume(); // 이벤트 소비
                }
            }
        });
    }
    
    private void addButtonsToPanel() {
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

    private void addInput(String text) {
        input.append(text);
        tf.setText(input.toString());
    }

    private void clearInput() {
        input.setLength(0); // 입력 초기화
        tf.setText("");
    }

    private void calculateResult() {
        try {
            // 입력이 비어있지 않은지 확인
            if (input.length() == 0) {
                return;
            }
            double result = eval(input.toString());
            tf.setText(String.valueOf(result));
            input.setLength(0); // 입력 초기화
        } catch (Exception e) {
            tf.setText("Error");
            input.setLength(0); // 입력 초기화
        }
    }

    // 간단한 수식 평가 메서드 (우선순위 처리)
    private double eval(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        double result = 0;
        java.util.Stack<Double> values = new java.util.Stack<>();
        java.util.Stack<Character> ops = new java.util.Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+(\\.\\d+)?")) { // 숫자인 경우
                values.push(Double.parseDouble(token));
            } else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(token.charAt(0))) {
                    double b = values.pop();
                    double a = values.pop();
                    char op = ops.pop();
                    values.push(applyOp(a, b, op));
                }
                ops.push(token.charAt(0));
            }
        }

        while (!ops.isEmpty()) {
            double b = values.pop();
            double a = values.pop();
            char op = ops.pop();
            values.push(applyOp(a, b, op));
        }

        return values.pop();
    }

    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private double applyOp(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        new CalculatorInterface();
    }
}
