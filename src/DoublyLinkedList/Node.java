package DoublyLinkedList;

class Node{
    int data;
    Node previous;
    Node next;
    Node(int data, Node previous, Node next){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}