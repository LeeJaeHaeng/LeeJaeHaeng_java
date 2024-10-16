package 실습;

import java.io.*;
import java.util.StringTokenizer;


public class BufferedReader_Writer {
		public static void main(String[] args) {
				File dataFile = new File("C:\\data.txt");
				String readData;
				StringTokenizer st;
				try{
						BufferedReader br = new BufferedReader(new FileReader(dataFile));
						while((readData = br.readLine()) != null ){
							st = new StringTokenizer(readData, " ");
							String name = st.nextToken();
							System.out.println("이름: " + name);
							String telNum = st.nextToken();
							st = new StringTokenizer(telNum, "-");
							String telNumP1 = st.nextToken();
							String telNumP2 = st.nextToken();
							String telNumP3 = st.nextToken();
							System.out.println("전화번호: " + telNumP1 + "-" + telNumP2+ "-" + telNumP3 );
						}
						br.close();
				}catch(IOException e){
				System.out.println(e.getMessage());
				}
		}
}