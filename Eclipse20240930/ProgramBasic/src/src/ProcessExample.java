package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProcessExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		try {
			String[] command = {"CMD", "/C", "dir"};
			ProcessBuilder probuilder = new ProcessBuilder(command);
			
			probuilder.directory(new File("c:\\tmp"));
			
			Process process = probuilder.start();
			
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			System.out.printf("실행 결과 %s is : \n", Arrays.toString(command));
			
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			
			int exitValue = process.waitFor();
			System.out.println(process.exitValue());
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}

}
