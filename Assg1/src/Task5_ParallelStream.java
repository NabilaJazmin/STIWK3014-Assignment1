import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Task5_ParallelStream {
    public static void main(String[] args) {
        System.out.println("=== TASK 5: Parallel Stream Analysis ===");

        Map<String, String> studentMap = new ConcurrentHashMap<>();
        for (int i = 1; i <= 50; i++) {
            String studentId = "2860" + String.format("%02d", i);
            String course = (i % 3 == 0) ? "STIW3014" : "STIW2024";
            studentMap.put(studentId, course);
        }
        long stiw2024Count = studentMap.values().parallelStream()
                .filter(course -> course.equals("STIW2024"))
                .count();
        System.out.println("Total students registered for STIW2024: " + stiw2024Count);

        Map<String, Long> courseCounts = studentMap.values().parallelStream()
                .collect(Collectors.groupingBy(course -> course, Collectors.counting()));

        String mostPopular = Collections.max(courseCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most popular course: " + mostPopular);

        System.out.println("Thread names used during Parallel Stream processing:");
        studentMap.values().parallelStream()
                .forEach(course -> {
                    System.out.println(Thread.currentThread().getName());
                });
    }
}