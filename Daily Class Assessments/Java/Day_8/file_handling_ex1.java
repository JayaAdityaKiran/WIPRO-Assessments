package Java.Day_8;
import java.io.*;
import java.nio.file.*;

public class file_handling_ex1 {
    public static void main(String[] args) {
        File f1 = new File("file1.txt");
        try {
            // 1️⃣ Create new file
            if (f1.createNewFile()) {
                System.out.println("File created: " + f1.getName());
            } else {
                System.out.println("File already exists: " + f1.getName());
            }

            // 2️⃣ Write content
            try (FileWriter fw = new FileWriter(f1)) {
                fw.write("This is the 1st line in this file");
            }

            try (BufferedWriter bfw = new BufferedWriter(new FileWriter(f1, true))) {
                bfw.newLine();
                bfw.write("This is the 2nd line in this file...using buffer writer");
                bfw.newLine();
                bfw.write("This is the 3rd line in this file...using buffer writer");
            }

            // 3️⃣ Read with FileReader
            System.out.println("\nUsing FileReader:");
            try (FileReader fr = new FileReader(f1)) {
                int content;
                while ((content = fr.read()) != -1) {
                    System.out.print((char) content);
                }
            }

            // 4️⃣ Read with BufferedReader
            System.out.println("\n\nUsing BufferedReader:");
            try (BufferedReader br = new BufferedReader(new FileReader(f1))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // 5️⃣ Rename the file (same folder)
            File f3 = new File("file3.txt");
            if (f1.renameTo(f3)) {
                System.out.println("\nFile renamed successfully to: " + f3.getName());
            } else {
                System.out.println("\nRename failed or already done.");
            }

            // 6️⃣ Move renamed file to another directory
            Path sourcePath = f3.toPath();
            Path moveDestination = Paths.get("D:\\Wipro -Pre Skilling Training\\Vs code\\Java\\Day_8\\file3.txt");
            Files.createDirectories(moveDestination.getParent());
            Files.move(sourcePath, moveDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved to: " + moveDestination);

            // 7️⃣ Make a copy of the moved file
            Path copyDestination = Paths.get("D:\\Wipro -Pre Skilling Training\\Vs code\\Java\\Day_8\\file3_copy.txt");
            Files.copy(moveDestination, copyDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copy created at: " + copyDestination);

            System.out.println("\n");

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
