public class Main {
    public static void main(String[] args) {
        // Creating a to-do list
        ToDoList toDoList = new ToDoList();

        // Adding tasks to the to-do list
        Task task1 = new Task("Task 1", "Description for Task 1");
        Task task2 = new Task("Task 2", "Description for Task 2");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);

        // Marking task1 as completed
        toDoList.markToDoAsCompleted("Task 1");

        // Viewing the updated to-do list
        toDoList.viewToDoList();
    }
}

class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

class Node {
    private Task task;
    private Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class ToDoList {
    private Node head;

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTitle().equals(title)) {
                current.getTask().markCompleted();
                return;
            }
            current = current.getNext();
        }
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            Task task = current.getTask();
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println();
            current = current.getNext();
        }
    }
}
