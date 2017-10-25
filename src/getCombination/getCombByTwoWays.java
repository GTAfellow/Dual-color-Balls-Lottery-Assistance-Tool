package getCombination;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class getCombByTwoWays {
	public static Set<String> getCombByRedEst(String input, int sum){
		Set<String> result = new HashSet<String>();
		int[] red = new int[33];
		String[] redStr = input.split(",");
		int[] redIA = new int[6];
		int a1,a2,a3,a4,a5,a6 = 0;
		String str = new String("");
		
		for(int i = 0; i < redStr.length; i++){
			red[i] = Integer.parseInt(redStr[i]);
		}
		
		for(a1=0;a1<33;a1++){
			for (a2=a1;a2<33;a2++){
				for (a3=a2;a3<33;a3++){
					for (a4=a3;a4<33;a4++){
						for (a5=a4;a5<33;a5++){
							for (a6=a5;a6<33;a6++){
								if(red[a1]+red[a2]+red[a3]+red[a4]+red[a5]+red[a6] == sum){
									if(a1 == a2||a1 == a3||a1 == a4||
											a1 == a5||a1 == a6||a2 == a3||a2 == a4||a2 == a5||a2 == a6||
											a3 == a4||a3 == a5||a3 == a6||a4 == a5||a4 == a6||a5 == a6){
										continue;
									}else{
										redIA[0] = a1+1;
										redIA[1] = a2+1;
										redIA[2] = a3+1;
										redIA[3] = a4+1;
										redIA[4] = a5+1;
										redIA[5] = a6+1;
										Arrays.sort(redIA);
										
										for(int i=0;i<6;i++){
											str = str+String.format("%02d", redIA[i])+",";
										}
										//str = str.substring(0, str.length()-1);
										str += getCombination.getOERate(redIA)+","+getCombination.mod3Rate(redIA)
												+","+getCombination.mod10Rate(redIA)+","+getCombination.sectionRate(redIA)
												+","+getSumNum(redIA)+","+getUnitSum(redIA);
										result.add(str);
										str = "";
									}
								}else{
									continue;
								}
							}
						}
					}
				}
			}
		}		
		
		return result;
	}
	
	private static Set<String> getCombByTwoWays(String input1, int sum1, String input2, int sum2){
		Set<String> result1 = getCombByRedEst(input1,sum1);
		Set<String> result2 = getCombByRedEst(input2,sum2);
		result1.retainAll(result2);
		return result1;
	}
	
	/*private static int[] Str2IA(String Str){
		int[] IA = new int[6];
		String[] SplitStr = Str.split(",");
		
		for(int i = 0; i < SplitStr.length; i++){
			IA[i] = Integer.parseInt(SplitStr[i]);
		}
		
		return IA;
	}*/
	
	private static String getSumNum(int[] is){
		int sum = 0;
		
		for (int i=0;i<is.length;i++){
			sum += is[i];
		}		
		return String.valueOf(sum);
	}
	
	public static String getUnitSum(int[] is){
		int sum = 0;
		
		for (int i=0;i<is.length;i++){
			sum += is[i]%10;
		}		
		return String.valueOf(sum);
	}
	
	public static void execute(String path, String input1, int sum1, String input2, int sum2) {
		File file = new File(path);
		//String inputStr1 = new String("0,2,0,0,4,0,0,1,0,1,0,1,4,0,3,2,2,0,1,2,0,1,0,1,0,3,0,0,1,0,0,1,0");
		//int sum1 = 10;
		//String inputStr2 = new String("1,5,2,1,6,2,4,6,3,4,2,3,5,2,7,1,4,5,2,6,2,2,3,3,6,6,2,5,8,3,4,3,1");
		//int sum2 = 25;
		
		Set<String> result = getCombByTwoWays(input1, sum1, input2, sum2);
		
		if(file.exists()){
			//System.out.println("File has already existed.");
		}else{
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		String output = new String("");
		
		try {
			BufferedWriter bw = new BufferedWriter
					(new OutputStreamWriter(new FileOutputStream(file), "gb2312"));
			output = "红1,红2,红3,红4,红5,红6,奇偶比,除3余数,个位数大小比,三区间比,和值,个位数和值\r\n";
			for(String str1 : result){
				output += str1+"\r\n";
			}
			bw.write(output);
			output = "";
			bw.close();
			JOptionPane.showMessageDialog(null, "生成文件完成！", "完成", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "文件名不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
