package edu.cdu.ppj.chapter8.four;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
public class Demo
{
    public static void main(String[] args)
    {
        File file = new File("D:\\Demo1.java");
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\IdeaProjects\\experiment\\src\\edu\\cdu\\ppj\\chapter8\\four\\Demo.java"));
            String temp = null;
            StringBuffer sb = new StringBuffer();
            int i = 1;
            while((temp = br.readLine()) != null )
            {
                temp = i + " " + temp;
                i++;
                sb.append(temp + "\r\n");
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(sb.toString().getBytes());
        } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}