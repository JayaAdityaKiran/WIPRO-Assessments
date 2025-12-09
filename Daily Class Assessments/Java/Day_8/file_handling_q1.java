package Java.Day_8;
import java.io.*;
public class file_handling_q1 {
    public static void main(String[] args) {

        File ess = new File("essay.txt");
        System.out.print("\n");
        try{
            BufferedWriter bff = new BufferedWriter(new FileWriter("essay.txt"));
            bff.write("My name is Jaya Aditya");
            bff.newLine();
            bff.write("I live in pune");
            bff.newLine();
            bff.write("Virat Goat");
            bff.newLine();
            bff.write("One Piece");
            bff.close();

            BufferedReader bffr = new BufferedReader(new FileReader("essay.txt"));
            String s;
            int lines = 0;
            int word_count = 0;
            while((s = bffr.readLine()) != null){
                lines = lines+1;
                System.out.println(s);
                String [] words = s.trim().split("\\s+");
                for(String w : words){
                    System.out.println("The word is : "+w);
                }
                System.out.print("\n");
                word_count = word_count + words.length;
            }
            System.out.println("Number of lines in the file is : "+lines);   
            System.out.println("The final word count is : "+word_count+"\n");
            bffr.close();

            File re = new File("report.txt");
            BufferedWriter bffw_report = new BufferedWriter(new FileWriter("report.txt"));
            bffw_report.write("Total Number of lines : ");
            bffw_report.write(Integer.toString(lines));
            bffw_report.newLine();
            bffw_report.write("Total Number of words : ");
            bffw_report.write(Integer.toString(word_count));
            bffw_report.close();

            BufferedReader bffr_report = new BufferedReader(new FileReader("report.txt"));
            String rep;
            while((rep = bffr_report.readLine()) != null){
                System.out.println(rep);
            }
            bffr_report.close();
            System.out.print("\n");
            System.out.print("Report generated successfully!\n");


            System.out.print("\n");
        }catch (IOException e){
            System.out.println("Error Occured");
        }
    }
}
