package 실습; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FlyingTextEx extends JFrame {
    JPanel contentPane = new JPanel();
    JLabel la = new JLabel("HELLO");
    
    FlyingTextEx() {
        super("상, 하, 좌, 우 키를 이용하여 텍스트 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // KeyListener를 외부 클래스에서 받아옴
        contentPane.addKeyListener(new MyKeyListener(la));
        
        la.setLocation(50, 50);
        la.setSize(100, 20);
        contentPane.add(la);
        setSize(200, 200);
        setVisible(true);

        contentPane.setFocusable(true); // 포커스를 받을 수 있도록 설정
        contentPane.requestFocus(); // 포커스 지정
    }
    
    public static void main(String[] args) {
        new FlyingTextEx();
    }
}

// 독립된 KeyListener 클래스
class MyKeyListener extends KeyAdapter {
    JLabel label;

    // 생성자로 JLabel을 받아서 이동시킴
    MyKeyListener(JLabel label) {
        this.label = label;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); // 입력된 키 코드
        switch (keyCode) {
            case KeyEvent.VK_UP:
                label.setLocation(label.getX(), label.getY() - 100); break;
            case KeyEvent.VK_DOWN:
                label.setLocation(label.getX(), label.getY() + 100); break;
            case KeyEvent.VK_LEFT:
                label.setLocation(label.getX() - 100, label.getY()); break;
            case KeyEvent.VK_RIGHT:
                label.setLocation(label.getX() + 100, label.getY()); break;
        }
    }
}
