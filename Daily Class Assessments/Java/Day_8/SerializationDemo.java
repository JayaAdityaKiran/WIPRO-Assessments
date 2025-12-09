import java.io.*;

public class SerializationDemo {

    private static final String FILE_NAME = "employee.ser";

    public static void main(String[] args) {
        EmployeeRecord originalRecord = new EmployeeRecord(5001, "Marketing");
        serializeRecord(originalRecord);

        EmployeeRecord deserializedRecord = deserializeRecord();

        if (deserializedRecord != null) {
            System.out.println("--- Deserialization Successful ---");
            System.out.println("Original Record: " + originalRecord);
            System.out.println("Deserialized Record: " + deserializedRecord);
        }
    }

    private static void serializeRecord(EmployeeRecord record) {
        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(record);
            System.out.println("EmployeeRecord object successfully serialized and saved to " + FILE_NAME);

        } catch (IOException i) {
            System.err.println("Serialization failed: " + i.getMessage());
        }
    }

    private static EmployeeRecord deserializeRecord() {
        EmployeeRecord record = null;
        try (FileInputStream fileIn = new FileInputStream(FILE_NAME);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            record = (EmployeeRecord) in.readObject();

        } catch (IOException i) {
            System.err.println("Deserialization failed (I/O Error): " + i.getMessage());
            return null;
        } catch (ClassNotFoundException c) {
            System.err.println("EmployeeRecord class not found.");
            return null;
        }
        return record;
    }
}

class EmployeeRecord implements Serializable {
    private static final long serialVersionUID = 2L;

    private int employeeId;
    private String department;

    public EmployeeRecord(int employeeId, String department) {
        this.employeeId = employeeId;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Dept: " + department;
    }
}