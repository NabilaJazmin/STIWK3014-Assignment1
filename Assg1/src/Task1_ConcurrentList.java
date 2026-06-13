import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task1_ConcurrentList {
    public static void main(String[] args) {
        System.out.println("=== TASK 1: Concurrent List ===");

        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 50; i++) {
            list.add("Req_" + i + "_STIW3014");
        }

        System.out.println("First record: " + list.get(0));
        System.out.println("Last record: " + list.get(list.size() - 1));

        System.out.println("Total registration requests: " + list.size());

        boolean exists = list.contains("Req_10_STIW3014");
        System.out.println("Does 'Req_10_STIW3014' exist? " + exists);

        System.out.println("Record at index 10: " + list.get(10));
    }
}