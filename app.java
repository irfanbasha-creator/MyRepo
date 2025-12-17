// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

//Dev2 java code
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== TASK MANAGER ===\n");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Exit");
            System.out.print("Choose option (1-4): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void addTask() {
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        tasks.add("[ ] " + task);
        System.out.println("Task added successfully!");
    }
    
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }
        
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    
    private static void completeTask() {
        viewTasks();
        if (tasks.isEmpty()) return;
        
        System.out.print("Enter task number to mark as complete: ");
        int taskNum = scanner.nextInt();
        scanner.nextLine();
        
        if (taskNum > 0 && taskNum <= tasks.size()) {
            String task = tasks.get(taskNum - 1);
            tasks.set(taskNum - 1, task.replace("[ ]", "[✓]"));
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task number!");
        }
    }
}
