import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task3_ConcurrentMap {
    public static void main(String[] args) {
        System.out.println("=== TASK 3: Concurrent Map ===");

        Map<String, String> studentMap = new ConcurrentHashMap<>();

        for (int i = 1; i <= 50; i++) {
            String studentId = (i == 1) ? "286494" : "2860" + String.format("%02d", i);
            String course = (i % 2 == 0) ? "STIW3014" : "STIW2024";

            studentMap.put(studentId, course);
        }

        System.out.println("Course for Student 286494: " + studentMap.get("286494"));

        studentMap.replace("286494", "STIW1004");
        System.out.println("Updated course for Student 286494: " + studentMap.get("286494"));

        boolean hasStudent = studentMap.containsKey("286010");
        System.out.println("Does Student 286010 exist? " + hasStudent);

        studentMap.remove("286050");
        System.out.println("Total registrations after removal: " + studentMap.size());

        System.out.println("Displaying first 3 records: ");
        int count = 0;
        for (Map.Entry<String, String> entry : studentMap.entrySet()) {
            if (count >= 3) break;
            System.out.println("ID: " + entry.getKey() + " -> Course: " + entry.getValue());
            count++;
        }
    }
}