package linkedList;

public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 9};
        Node head = convertSrrToLL(arr);
//        printLinkedList(head);
//        System.out.println(countLinkedListLength(head));
//        System.out.println(checkIfPresent(head, 12));
//        printLinkedList(deleteTail(head));
//        printLinkedList(deleteAtAPosition(head, 1));
//        printLinkedList(deleteAtNodeData(head, 9));
//        printLinkedList(insertAtLast(head, 19));
//        printLinkedList(insertAtKthPosition(head, 8, 10));
//        printLinkedList(insertAtNodeWithValue(head, 18, 5));

    }


    static Node convertSrrToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static Integer countLinkedListLength(Node head) {
        Node temp = head;
        Integer count = 0;
        while (temp != null) {
            ++count;
            temp = temp.next;
        }
        return count;

    }

    static int checkIfPresent(Node head, Integer val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }

    /***************************Deletion*********************************************/

/*Edge cases to consider
            1. if its null is passed as head
            2. if linked list with single element is passed */
    static Node deleteHead(Node head) {
        if (head == null) return head;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    static Node deleteTail(Node head) {
        Node temp = head;
        if (head == null || head.next == null) { // check if null is sent or linkedList has only one node
            return head;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    static Node deleteAtAPosition(Node head, Integer k) {
        if (head == null) {
            return head;
        }

        if (k == 1) {
            head = head.next;
            return head;
        }
        int count = 0;
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            count = count + 1;
            if (count == k) {
                Node curr = temp;
                prev.next = curr.next;
                curr.next = null;
                break;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    static Node deleteAtNodeData(Node head, Integer data) {
        if (head == null) {
            return head;
        }
        if (head.data == data) {
            head = head.next;
            return head;
        }
        //int count = 0;
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            //count = count + 1;
            if (temp.data == data) {
                Node curr = temp;
                prev.next = curr.next;
                curr.next = null;
                break;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    /***************************Insertion*********************************************/
    static Node insertAtHead(Node head, Integer val) {
        if (head == null) {
            return new Node(val);
        }
        head = new Node(val, head);
        return head;
    }

    private static Node insertAtLast(Node head, int i) {
        if (head == null) {
            return new Node(i);
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                Node last = new Node(i);
                temp.next = last;
                return head;
            }
                temp = temp.next;
        }

        return head;
    }

    private static Node insertAtKthPosition(Node head, int i, int pos) {
        if (head == null) {
            return new Node(i);
        }
        if(pos == 1){
            return new Node(i, head);
        }
        Node temp = head;
        Node prev = null;
        Integer count = 0;
        while (temp != null) {
            count = count + 1;
            if(count == pos){
                Node newNode = new Node(i, temp);
                prev.next = newNode;
                return head;
            }
            prev = temp;
            temp = temp.next;

        }

        return head;
    }

    private static Node insertAtNodeWithValue(Node head, int newValue, int value) {
        if (head == null) {
            return new Node(newValue);
        }
        if(head.data == value){
            return new Node(newValue, head);
        }
        Node temp = head;
        Node prev = null;
        //Integer count = 0;
        while (temp != null) {
            if(temp.data == value){
                prev.next = new Node(newValue, temp);
                return head;
            }
            prev = temp;
            temp = temp.next;

        }

        return head;
    }
}
