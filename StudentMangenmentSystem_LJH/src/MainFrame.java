import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.table.*;

public class MainFrame extends JFrame {
    String[] departments = {"컴공", "전자", "기계", "AISW", "영어영문"};
    Object[][] students = {
        {"컴퓨터공학부", "1학년", "홍길동", "학부생", "111111"},
        {"컴퓨터공학부", "4학년", "김철수", "학부생", "123467"},
        {"컴퓨터공학부", "4학년", "이병헌", "학부생", "100011"},
        {"컴퓨터공학부", "2학년", "푸하하", "학부생", "145361"},
        {"컴퓨터공학부", "1학년", "하하하", "학부생", "111551"},
        {"컴퓨터공학부", "1학년", "강호동", "학부생", "123111"},
        {"컴퓨터공학부", "3학년", "이수근", "학부생", "165101"},
        {"컴퓨터공학부", "1학년", "서장훈", "학부생", "133411"},
        {"전자공학과", "1학년", "홍길동", "학부생", "111111"},
        {"전자공학과", "1학년", "김철수", "학부생", "123467"},
        {"전자공학과", "4학년", "이병헌", "학부생", "100011"},
        {"전자공학과", "4학년", "푸하하", "학부생", "145361"},
        {"전자공학과", "1학년", "하하하", "학부생", "111551"},
        {"전자공학과", "2학년", "강호동", "학부생", "123111"},
        {"전자공학과", "1학년", "이수근", "대학원생", "165101"},
        {"전자공학과", "3학년", "서장훈", "대학원생", "133411"}
    };

    // 공간제어를 위한 컨테이너 필드
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel westPanel = new JPanel();
    JPanel centerPanel = new JPanel(new BorderLayout());

    // 메뉴용
    JMenuBar mb = new JMenuBar();
    JMenu homeMenu = new JMenu("HOME");
    JMenuItem openMI = new JMenuItem("Open");
    JMenuItem newMI = new JMenuItem("New");
    JMenuItem exitMI = new JMenuItem("Exit");

    // westPanel에 올라갈 컴포넌트
    JLabel titleLabel = new JLabel("Select Student Type");
    JCheckBox usCheck = new JCheckBox("학부생");
    JCheckBox gsCheck = new JCheckBox("대학원생");
    JComboBox<String> comboBox;
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultTreeModel treeModel;

    // CenterPanel에 올라갈 컴포넌트
    JTable table;
    DefaultTableModel tableModel;
    String[] columnNames = {"학과", "학년", "이름", "구분", "학번"};

    MainFrame() {
        setTitle("학생관리시스템_이재행_V0.01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메뉴 추가 작업
        homeMenu.add(openMI);
        homeMenu.add(newMI);
        homeMenu.add(exitMI);
        mb.add(homeMenu);
        setJMenuBar(mb);

        // westPanel 세팅
        westPanel.setPreferredSize(new Dimension(180, 0));
        westPanel.setLayout(new FlowLayout());
        titleLabel.setPreferredSize(new Dimension(160, 20));
        westPanel.add(titleLabel);
        westPanel.add(usCheck);
        westPanel.add(gsCheck);

        // 트리 구성
        root = new DefaultMutableTreeNode("학과");
        tree = new JTree(root);
        tree.setPreferredSize(new Dimension(160, 140));
        for (String department : departments) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(department);
            root.add(node);
        }
        treeModel = (DefaultTreeModel) tree.getModel();
        treeModel.setRoot(root);
        westPanel.add(tree);

        // ComboBox 추가
        comboBox = new JComboBox<>(departments);
        comboBox.setPreferredSize(new Dimension(160, 20));
        westPanel.add(comboBox);

        // CenterPanel 세팅 (Table)
        tableModel = new DefaultTableModel(students, columnNames);
        table = new JTable(tableModel);
        JScrollPane sp= new JScrollPane(table);
        centerPanel.add(sp, BorderLayout.CENTER);

        // 전체 패널 세팅
        basePanel.add(westPanel, BorderLayout.WEST);
        basePanel.add(centerPanel, BorderLayout.CENTER);
        setContentPane(basePanel);

        setSize(900, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
    }
}
