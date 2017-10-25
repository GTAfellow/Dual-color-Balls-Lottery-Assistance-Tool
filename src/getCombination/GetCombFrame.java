package getCombination;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GetCombFrame {

	private JFrame frame;
	private JTextField inputSumTF;
	private JTextField inputPathTF;
	private JLabel label;
	public static JTextField HDTF;
	public static JTextField TZTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetCombFrame window = new GetCombFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GetCombFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("双色球和值组合");
		frame.setFont(new Font("黑体", Font.PLAIN, 12));
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel inputSumLabel = new JLabel("输入红球和值");
		inputSumLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		inputSumLabel.setBounds(26, 137, 108, 37);
		frame.getContentPane().add(inputSumLabel);
		
		inputSumTF = new JTextField();
		inputSumTF.setFont(new Font("黑体", Font.PLAIN, 18));
		inputSumTF.setBounds(144, 138, 124, 35);
		frame.getContentPane().add(inputSumTF);
		inputSumTF.setColumns(10);
		
		JButton BFButton = new JButton("生成文件");
		BFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputPathTF.getText() == "" || inputPathTF.getText() == null){
					JOptionPane.showMessageDialog(null, "文件名不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
				}else if(HDTF.getText() == "" || HDTF.getText() == null 
						|| TZTF.getText() == "" || TZTF.getText() == null){
					JOptionPane.showMessageDialog(null, "红胆个数和投注个数不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						getCombination.execute(inputPathTF.getText(), inputSumTF.getText());
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "红球和值请输入21到183之间的整数", "错误", JOptionPane.ERROR_MESSAGE);
					}
				}	
			}
		});
		BFButton.setFont(new Font("黑体", Font.PLAIN, 18));
		BFButton.setBounds(316, 184, 108, 29);
		frame.getContentPane().add(BFButton);
		
		JLabel inputPathLabel = new JLabel("输入文件名");
		inputPathLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		inputPathLabel.setBounds(26, 180, 96, 37);
		frame.getContentPane().add(inputPathLabel);
		
		inputPathTF = new JTextField();
		inputPathTF.setText("数据.csv");
		inputPathTF.setFont(new Font("黑体", Font.PLAIN, 16));
		inputPathTF.setBounds(144, 181, 162, 37);
		frame.getContentPane().add(inputPathTF);
		inputPathTF.setColumns(10);
		
		label = new JLabel("双色球和值组合");
		label.setForeground(new Color(204, 0, 0));
		label.setFont(new Font("黑体", Font.PLAIN, 22));
		label.setBounds(132, 10, 162, 44);
		frame.getContentPane().add(label);
		
		JButton REbutton = new JButton("根据红胆和投注生成");
		REbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetCombByTwoWaysFrame.initial();
			}
		});
		REbutton.setForeground(Color.BLUE);
		REbutton.setFont(new Font("黑体", Font.PLAIN, 13));
		REbutton.setBounds(132, 223, 175, 28);
		frame.getContentPane().add(REbutton);
		
		JLabel label_1 = new JLabel("红胆个数");
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(10, 49, 81, 29);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("投注个数");
		label_2.setFont(new Font("黑体", Font.PLAIN, 18));
		label_2.setBounds(10, 94, 81, 33);
		frame.getContentPane().add(label_2);
		
		HDTF = new JTextField();
		HDTF.setBounds(85, 51, 339, 29);
		frame.getContentPane().add(HDTF);
		HDTF.setColumns(10);
		
		TZTF = new JTextField();
		TZTF.setBounds(85, 98, 339, 29);
		frame.getContentPane().add(TZTF);
		TZTF.setColumns(10);
	}
}
