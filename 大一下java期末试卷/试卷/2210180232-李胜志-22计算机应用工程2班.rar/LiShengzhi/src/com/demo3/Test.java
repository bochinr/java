package com.demo3;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) throws Exception {
		File f = new File("c://Èý×Ö¾­.txt");
		File f2 = new File("E:\\study\\java\\homework\\zhangsi16");
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		 String fName = f.getName();
		 File f2Name = new File(f2,fName);
		 FileOutputStream fos = new FileOutputStream(f2Name);
		 BufferedOutputStream bos = new BufferedOutputStream(fos);
		 byte[] bytes = new byte[1024];
	        int len = 0;
	        while ((len = bis.read(bytes)) !=-1){
	            System.out.println(new String(bytes,0,len));
	        }
	        bis.close();
	        bos.close();
	}

}
