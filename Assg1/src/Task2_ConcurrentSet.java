import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Task2_ConcurrentSet {
    public static void main(String[] args) {
        System.out.println("=== TASK 2: Concurrent Set ===");

        Set<String> courseSet = ConcurrentHashMap.newKeySet();

        courseSet.add("STIW3014");
        courseSet.add("STIW2024");
        courseSet.add("STIW1004");

        boolean addedDuplicate = courseSet.add("STIW3014");
        System.out.println("Was duplicate 'STIW3014' added? " + addedDuplicate);

        System.out.println("Unique course codes: " + courseSet);

        boolean hasCourse = courseSet.contains("STIW2024");
        System.out.println("Does 'STIW2024' exist? " + hasCourse);

        courseSet.remove("STIW1004");
        System.out.println("Total unique courses after removal: " + courseSet.size());
        System.out.println("Remaining courses: " + courseSet);
    }
}