import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Task4_ConcurrentQueue {
    public static void main(String[] args) {
        System.out.println("=== TASK 4: Concurrent Queue ===");

        Queue<String> requestQueue = new ConcurrentLinkedQueue<>();

        requestQueue.offer("Request_001_Ahmad");
        requestQueue.offer("Request_002_Siti");
        requestQueue.offer("Request_003_Chong");

        System.out.println("First request waiting (peek): " + requestQueue.peek());

        System.out.println("Processing all requests:");
        while (!requestQueue.isEmpty()) {
            String processedRequest = requestQueue.poll();
            System.out.println("Successfully processed: " + processedRequest);
        }

        System.out.println("Is the queue empty now? " + requestQueue.isEmpty());
    }
}