package DoublyLinkedList;

class DoublyLinkedList {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 7};
        Node head = convertArrToDoublyLL(arr);
        // printAllDoubleLL(head);
//        printAllDoubleLL(deleteHeadOfDll(head));
//        printAllDoubleLL(deleteTailOfDll(head));
        printAllDoubleLL(deleteElementAtKOfDll(head,1));
    }

    private static Node deleteElementAtKOfDll(Node head, int k) {
        if(head == null || (head.next == null && head.previous == null)){
            return head;
        }
        
        if(k == 1){
            head = head.next;
            head.previous = null;
            return head;
        }
        Node temp = head;
        int count = 0;
        while(temp != null){
            count = count + 1;
            if(count == k){
                Node prev = temp.previous;
                Node next = temp.next;
                prev.next = next;
                next.previous = prev;
                temp.previous = null;
                temp.next = null;
                break;
            }
            temp = temp.next;


        }

        return head;
    }

    private static Node deleteTailOfDll(Node head) {
        if(head == null ||(head.next == null && head.previous == null)){
            return head;
        }
        Node temp = head;
       /* Node prev = null;
        //Integer count = 0;
        while (temp != null){
            //count = count + 1;
            if(temp.next == null){ // shows last element in DLL
                prev.next = null;
                temp.next = null;
                temp.previous = null;
            }
            prev = temp;
            temp = temp.next;
        }*/

        while(temp.next!= null){
            temp = temp.next;
        }
        temp.previous.next = null;
        temp.next = null;
        temp.previous = null;

        return head;
    }

    private static Node deleteHeadOfDll(Node head) {
        if (head == null || (head.next == null && head.previous == null)) {
            return head;
        }
        Node newHead = head.next;
        head.next = null;
        head.previous = null;
        newHead.previous = null;
        return newHead;
    }

    private static void printAllDoubleLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    private static Node convertArrToDoublyLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {

            Node nNode = new Node(arr[i]);
            prev.next = nNode;
            nNode.previous = prev;
            prev = nNode;
        }

        return head;
    }
}