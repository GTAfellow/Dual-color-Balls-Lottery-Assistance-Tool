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

public class getCombination {
	
	private static Set<String> getCombination(int sum){
		int a1,a2,a3,a4,a5,a6 = 0;
		int[] is = new int[6];
		String str = new String("");
		Set<String> set = new HashSet<String>();
		
		for (a1=1;a1<34;a1++){
			for (a2=a1;a2<34;a2++){
				for (a3=a2;a3<34;a3++){
					for (a4=a3;a4<34;a4++){
						for (a5=a4;a5<34;a5++){
							a6 = sum-a1-a2-a3-a4-a5;
							if(a6>33 || a6<=0 ||a1 == a2||a1 == a3||a1 == a4||
									a1 == a5||a1 == a6||a2 == a3||a2 == a4||a2 == a5||a2 == a6||
									a3 == a4||a3 == a5||a3 == a6||a4 == a5||a4 == a6||a5 == a6){
								continue;
							}else{
								is[0] = a1;
								is[1] = a2;
								is[2] = a3;
								is[3] = a4;
								is[4] = a5;
								is[5] = a6;
								Arrays.sort(is);
								
								for(int i=0;i<6;i++){
									str = str+String.format("%02d", is[i])+",";
								}
								//str = str.substring(0, str.length()-1);
								str += getOERate(is)+","+mod3Rate(is)+","+mod10Rate(is)
										+","+sectionRate(is)+","+getCombByTwoWays.getUnitSum(is)
										+","+getRedEstSum(is,GetCombFrame.HDTF.getText())
										+","+getRedEstSum(is,GetCombFrame.TZTF.getText());
								set.add(str);
								str = "";
							}
						}
					}
				}
			}
		}
		
		return set;	
	}
	
	/*private static String getPrimeRate(int[] is){
		int[] primeArr = new int[]{1,2,3,5,7,11,13,17,19,23,29,31};
		String result = new String();
		int comp = 0;
		int prime = 0;
		int tmp = 0;
		for (int i=0;i<is.length;i++){
			tmp = prime;
			for(int j=0;j<primeArr.length;j++){
				if(is[i] == primeArr[j]){
					prime++;
					break;
				}	
			}
			if(tmp == prime){
				comp++;
			}
		}
		result = prime+":"+comp;
		return result;
	}*/
	
	public static String getOERate(int[] is){
		String result = new String();
		int odd = 0;
		int even = 0;
		for (int i=0;i<is.length;i++){
			if(is[i]%2 == 1){
				odd++;
			}else{
				even++;
			}
		}
		result = odd+":"+even;
		return result;
	}
	
	public static String mod3Rate(int[] is){
		String result = new String();
		int m0 = 0;
		int m1 = 0;
		int m2 = 0;
		for (int i=0;i<is.length;i++){
			if(is[i]%3 == 1){
				m1++;
			}else if(is[i]%3 == 2){
				m2++;
			}else{
				m0++;
			}
		}
		result = m0+":"+m1+":"+m2;
		return result;
	}
	
	public static String mod10Rate(int[] is){
		String result = new String();
		int big = 0;
		int small = 0;
		
		for (int i=0;i<is.length;i++){
			if(is[i]%10 < 5){
				small++;
			}else{
				big++;
			}
		}
		result = big+":"+small;
		return result;
	}
	
	public static String sectionRate(int[] is){
		String result = new String();
		int s0 = 0;
		int s1 = 0;
		int s2 = 0;
		for (int i=0;i<is.length;i++){
			if(is[i]<12){
				s0++;
			}else if(is[i]>11 && is[i]<23){
				s1++;
			}else{
				s2++;
			}
		}
		result = s0+":"+s1+":"+s2;
		return result;
	}
	
	/*private static String getBSRate(int[] is){
		String result = new String();
		int big = 0;
		int small = 0;
		for (int i=0;i<is.length;i++){
			if(is[i]<17){
				small++;
			}else{
				big++;
			}
		}
		result = big+":"+small;
		return result;
	}*/
	
	private static String getRedEstSum(int[] is, String redEst){
		int[] REIA = EstStr2EstIA(redEst);
		int sum = 0;
		
		for(int i=0; i<is.length; i++){
			sum += REIA[is[i]-1];
		}
		return String.valueOf(sum);
	}
	
	private static int[] EstStr2EstIA(String estStr){
		int[] EstIA = new int[33];
		String[] estSA = estStr.split(",");
		
		for(int i = 0; i < estSA.length; i++){
			EstIA[i] = Integer.parseInt(estSA[i]);
		}
		return EstIA;
	}

	public static void execute(String path, String input) {
		// TODO Auto-generated method stub
		String str2 = new String("");
		File file = new File(path);
		int n = Integer.parseInt(input);
		
		if(n<21 || n>183){
			JOptionPane.showMessageDialog(null, "请输入21到183之间的整数", "错误", JOptionPane.ERROR_MESSAGE);
		}
		
		if(file.exists()){
			//System.out.println("File has already existed.");
		}else{
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		try {
			BufferedWriter bw = new BufferedWriter
					(new OutputStreamWriter(new FileOutputStream(file), "gb2312"));
			str2 = "红1,红2,红3,红4,红5,红6,奇偶比,除3余数,个位数大小比,三区间比,尾和,红胆和值,投注和值\r\n";
			for(String str1 : getCombination(n)){
				str2 += str1+"\r\n";
			}
			bw.write(str2);
			str2 = "";
			bw.close();
			JOptionPane.showMessageDialog(null, "生成文件完成！", "完成", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "文件名不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		//System.out.println("Executed.");	
	}

}
