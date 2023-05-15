import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private static int nextId = 1;

    private int id;
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.id = nextId++;
        this.description = description;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public void markAsComplete() {
        this.isCompleted = true;
    }

    public String toString() {
        return String.format("%d: %s [%s]", id, description, isCompleted ? "completed" : "not completed");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        this.tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void removeTask(int id) {
        boolean removed = false;
        for (Task task : this.tasks) {
            if (task.getId() == id) {
                this.tasks.remove(task);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void markTaskAsComplete(int id) {
        boolean marked = false;
        for (Task task : this.tasks) {
            if (task.getId() == id) {
                task.markAsComplete();
                marked = true;
                break;
            }
        }
        if (marked) {
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public String listTasks() {
        StringBuilder sb = new StringBuilder();
        for (Task task : this.tasks) {
            sb.append(task.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //Display the Menu
            System.out.println("Please choose an option\n");
            System.out.println("1. Enter a task ");
            System.out.println("2. Remove a task ");
            System.out.println("3. Update a task ");
            System.out.println("4. List all tasks ");
            System.out.println("5. Exit");
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.println("Enter task description:");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;
                case "2":
                    System.out.println("Enter task ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    taskManager.removeTask(id);
                    break;
                case "3":
                    System.out.println("Enter task ID:");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    taskManager.markTaskAsComplete(id);
                    break;
                case "4":
                    System.out.println(taskManager.listTasks());
                    break;
                case "5":
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}
