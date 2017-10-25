package getCombination;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GetCombByTwoWaysFrame extends JFrame {

	private JPanel contentPane;
	private JTextField redEstTF;
	private JTextField estTF;
	private JTextField filepathTF;
	private JTextField redEstSum;
	private JTextField estSum;

	/**
	 * Launch the application.
	 */
	public static void initial() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetCombByTwoWaysFrame frame = new GetCombByTwoWaysFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GetCombByTwoWaysFrame() {
		setResizable(false);
		setFont(new Font("黑体", Font.PLAIN, 12));
		setTitle("根据红胆与投注生成文件");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("红胆个数");
		label.setFont(new Font("黑体", Font.PLAIN, 14));
		label.setBounds(10, 10, 66, 23);
		contentPane.add(label);
		
		redEstTF = new JTextField();
		redEstTF.setBounds(10, 38, 403, 21);
		contentPane.add(redEstTF);
		redEstTF.setColumns(10);
		
		JLabel label_1 = new JLabel("投注个数");
		label_1.setFont(new Font("黑体", Font.PLAIN, 14));
		label_1.setBounds(10, 69, 66, 15);
		contentPane.add(label_1);
		
		estTF = new JTextField();
		estTF.setBounds(10, 92, 403, 21);
		contentPane.add(estTF);
		estTF.setColumns(10);
		
		JLabel label_2 = new JLabel("注：红胆个数和投注个数分别输入33个数字，以“,”（半角逗号）间隔");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("黑体", Font.PLAIN, 12));
		label_2.setBounds(10, 123, 378, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("输入文件名");
		label_3.setFont(new Font("黑体", Font.PLAIN, 16));
		label_3.setBounds(10, 218, 83, 28);
		contentPane.add(label_3);
		
		filepathTF = new JTextField();
		filepathTF.setFont(new Font("黑体", Font.PLAIN, 14));
		filepathTF.setText("数据（红胆投注）.csv");
		filepathTF.setBounds(93, 217, 228, 33);
		contentPane.add(filepathTF);
		filepathTF.setColumns(10);
		
		JButton btnNewButton = new JButton("生成文件");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(redEstTF.getText()==null || redEstTF.getText()==""
						|| estTF.getText()==null || estTF.getText()==""){
					JOptionPane.showMessageDialog(null, "红胆个数和投注个数不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
				}else if(redEstSum.getText()==null || redEstSum.getText()==""
						|| estSum.getText()==null || estSum.getText()==""){
					JOptionPane.showMessageDialog(null, "红胆和投注个数和值不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						getCombByTwoWays.execute(filepathTF.getText(), redEstTF.getText(), 
								Integer.parseInt(redEstSum.getText()), estTF.getText(), 
								Integer.parseInt(estSum.getText()));
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "红胆和投注个数和值请输入整数！", "错误", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 16));
		btnNewButton.setBounds(325, 218, 99, 32);
		contentPane.add(btnNewButton);
		
		JLabel label_4 = new JLabel("红胆个数和值");
		label_4.setFont(new Font("黑体", Font.PLAIN, 14));
		label_4.setBounds(10, 152, 103, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("投注个数和值");
		label_5.setFont(new Font("黑体", Font.PLAIN, 14));
		label_5.setBounds(10, 185, 101, 23);
		contentPane.add(label_5);
		
		redEstSum = new JTextField();
		redEstSum.setFont(new Font("黑体", Font.PLAIN, 14));
		redEstSum.setBounds(127, 155, 137, 21);
		contentPane.add(redEstSum);
		redEstSum.setColumns(10);
		
		estSum = new JTextField();
		estSum.setFont(new Font("黑体", Font.PLAIN, 14));
		estSum.setBounds(127, 186, 137, 21);
		contentPane.add(estSum);
		estSum.setColumns(10);
	}
}
