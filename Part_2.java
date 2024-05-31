package com.mycompany.st10448858_poe;

import java.util.Scanner;
public class Part_2 {
    
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to EasyKanban");
        
        //This boolean will determine if the user's login is correct.
        boolean loggedIn = login();
        if (!loggedIn) {
            System.out.println("Login unsuccessful. Exiting application.");
            return;
        }

        int numTasks = getNumTasks(scanner);
        Task[] tasks = new Task[numTasks];

        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add tasks");
            System.out.println("2. Show report (Coming Soon)");
            System.out.println("3. Quit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    for (int i = 0; i < numTasks; i++) {
                        tasks[i] = addTask(scanner, i);
                    }
                    break;
                case 2:
                    System.out.println("Showing report (Coming Soon)");
                    break;
                case 3:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public static boolean login() {
        // Simplified login process, return true if successful, false otherwise
        return true; // Assuming login is always successful for now
    }

    public static int getNumTasks(Scanner scanner) {
        System.out.print("Enter the number of tasks: ");
        return scanner.nextInt();
    }

    public static Task addTask(Scanner scanner, int taskNumber) {
        scanner.nextLine(); // Consume newline character
        System.out.println("Task " + (taskNumber + 1) + ":");
        
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter Task Description (max 50 characters): ");
        String taskDescription = scanner.nextLine();
        if (taskDescription.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters");
            return addTask(scanner, taskNumber); // Retry adding task
        } else {
            System.out.println("Task successfully captured");
        }

        System.out.print("Enter Developer First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Developer Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Task Duration (in hours): ");
        double duration = scanner.nextDouble();

        String taskId = generateTaskID(taskName, taskNumber, firstName, lastName);

        System.out.println("Choose Task Status:");
        System.out.println("1. To Do");
        System.out.println("2. Done");
        System.out.println("3. Doing");
        int statusChoice = scanner.nextInt();
        String status;
        switch (statusChoice) {
            case 1:
                status = "To Do";
                break;
            case 2:
                status = "Done";
                break;
            case 3:
                status = "Doing";
                break;
            default:
                status = "Unknown";
        }

        return new Task(taskName, taskNumber, taskDescription, firstName, lastName, duration, taskId, status);
    }

    public static String generateTaskID(String taskName, int taskNumber, String firstName, String lastName) {
        String taskId = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + lastName.substring(lastName.length() - 3).toUpperCase();
        return taskId;
    }
}

class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String firstName;
    private String lastName;
    private double duration;
    private String taskId;
    private String status;

    public Task(String taskName, int taskNumber, String taskDescription, String firstName, String lastName, double duration, String taskId, String status) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.firstName = firstName;
        this.lastName = lastName;
        this.duration = duration;
        this.taskId = taskId;
        this.status = status;
    }

}

    

