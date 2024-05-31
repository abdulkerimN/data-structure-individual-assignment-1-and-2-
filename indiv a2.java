public class Main {
    public static void main(String[] args) {
        // Creating a linked list
        LinkedList linkedList = new LinkedList();

        // Inserting elements into the linked list
        linkedList.insertAtPos(10, 1);
        linkedList.insertAtPos(20, 2);
        linkedList.insertAtPos(30, 3);

        // Deleting an element at a given position
        linkedList.deleteAtPosition(2);

        // Creating a stack
        Stack stack = new Stack();

        // Pushing elements onto the stack
        stack.push(50);
        stack.push(60);
        stack.push(70);

        // Popping an element from the stack
        System.out.println("Popped element from stack: " + stack.pop());

        // Viewing the updated linked list
        linkedList.displayLinkedList();

        // Searching for a node
        int searchData = 20;
        if (linkedList.searchNode(searchData)) {
            System.out.println("Node with data " + searchData + " found.");
        } else {
            System.out.println("Node with data " + searchData + " not found.");
        }

        // Deleting a node after a given node
        Node node = linkedList.head.next;
        linkedList.deleteAfterNode(node);

        // Viewing the updated linked list
        System.out.println("Linked list after deleting node after a given node:");
        linkedList.displayLinkedList();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    // Inserting a Node at Any Given Position in a Singly Linked List
    void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Deleting a Node at Any Given Position in a Singly Linked List
    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Invalid position");
            return;
        }
        current.next = current.next.next;
    }

    // Deleting a Node After a Given Node in a Singly Linked List
    void deleteAfterNode(Node node) {
        if (node == null || node.next == null) {
            System.out.println("Invalid node or end of list");
            return;
        }
        node.next = node.next.next;
    }

    // Searching a Node in a Singly Linked List
    boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Displaying the LinkedList
    void displayLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.println("Data: " + current.data);
            current = current.next;
        }
    }
}

class Stack {
    Node top;

    // Pushing an element onto the stack
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Popping an element from the stack
    int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Peeking the top element of the stack
    int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
}
