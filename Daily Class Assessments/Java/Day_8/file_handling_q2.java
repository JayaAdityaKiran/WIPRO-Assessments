package Java.Day_8;
import java.io.*;
public class file_handling_q2 {
    public static void main(String[] args) {
        System.out.print("\n");
        File f1 = new File("f1.txt");
        File f2 = new File("f2.txt");
        File f3 = new File("f_merged.txt");
        try{

            BufferedWriter b1 = new BufferedWriter(new FileWriter("f1.txt"));
            b1.write("f1 line 1");
            b1.newLine();
            b1.write("f1 line 2");
            b1.newLine();
            b1.write("f1 line 3");
            b1.newLine();
            b1.write("f1 line 4");
            b1.newLine();
            b1.close();

            BufferedWriter b2 = new BufferedWriter(new FileWriter("f2.txt"));
            b2.write("f2 line 1");
            b2.newLine();
            b2.write("f2 line 2");
            b2.newLine();
            b2.write("f2 line 3");
            b2.newLine();
            b2.write("f2 line 4");
            b2.newLine();
            b2.write("f2 line 5");
            b2.newLine();
            b2.write("f2 line 6");
            b2.newLine();
            b2.close();

            BufferedReader br1 = new BufferedReader(new FileReader("f1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("f2.txt"));
            String s1 = br1.readLine();
            String s2 = br2.readLine();
            BufferedWriter b_merged_w = new BufferedWriter(new FileWriter("f_merged.txt"));
            while((s1 != null) || (s2 != null)){
                if (s1 != null) {
                    b_merged_w.write(s1);
                    b_merged_w.newLine();
                    s1 = br1.readLine();
                }
                if (s2 != null) {
                    b_merged_w.write(s2);
                    b_merged_w.newLine();
                    s2 = br2.readLine();
                }
            }
            br1.close();
            br2.close();
            b_merged_w.close();

            BufferedReader b_merged_r = new BufferedReader(new FileReader("f_merged.txt"));
            String s_merged;
            while((s_merged = b_merged_r.readLine()) != null){
                System.out.println(s_merged);
            }
            b_merged_r.close();
            System.out.println("\nMerged Completed Successfully!\n");
            
        }catch(IOException e){
            System.out.println("Error Occured\n");
        }
        
    }
}
