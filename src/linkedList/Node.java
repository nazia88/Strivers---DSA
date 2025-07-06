package linkedList;

public class Node {
    public Integer data;
    public Node next;

    Node(Integer data, Node node) {
        this.data = data;
        this.next = node;
    }
    Node(Integer data)
    {
        this.data = data;
        this.next = null;
    }
}
