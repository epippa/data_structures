public class HTList {

    protected Node head;
    protected Node tail;

    public HTList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    // If the list is empty, the head is the new Node. Otherwise, the new Node 
    // is inserted before the head Node, becoming the new Head.
    public void addAsHead(int i) {
        if (head == null) {
            Node n = new Node(i, null);
            head = n;
            tail = n;
        } else {
            Node n = new Node(i, head);
            head = n;
        }
    }

    // If the list is empty, the new Node is added at the head, otherwise it is
    // inserted at the end, becoming the new tail.
    public void addAsTail(int i) {
        Node n = new Node(i, null);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
    }

    // If the list is empty, the Head of the current list points to the Head
    // of the new list. Otherwise, the tail of the current list points to the
    // head of the new list. Then the tail is up to date.
    public void addAll(HTList i) {
        if (i.head == null) return;
        
        if (head == null) {
            head = i.head;
            tail = i.tail;
        } else {
            tail.next = i.head;
            tail = i.tail;
        }
    }

    // Returns a new sorted list without modifying the original
    public HTList quickSort() {
        if (head == null || head.next == null) return this;
        
        HTList copy = this.clone();
        copy.sortInternal();
        return copy;
    }

    // Internal sorting logic
    private void sortInternal() {
        quickSort(head, tail);
        fixTail();
    }

    // Creates a deep copy of the list
    public HTList clone() {
        if (head == null) return new HTList(null, null);
        
        Node newHead = new Node(head.val, null);
        Node current = head.next;
        Node newCurrent = newHead;
        
        while (current != null) {
            newCurrent.next = new Node(current.val, null);
            newCurrent = newCurrent.next;
            current = current.next;
        }
        return new HTList(newHead, newCurrent);
    }

    // Recursive quicksort implementation
    private void quickSort(Node left, Node right) {
        if (left == null || right == null || left == right) return;
        
        Node[] partitionResult = partition(left, right);
        Node pivot = partitionResult[0];
        Node leftEnd = partitionResult[1];
        
        if (left != pivot) quickSort(left, leftEnd);
        if (pivot != right && pivot.next != null) quickSort(pivot.next, right);
    }

    // Partitions the list around the pivot
    private Node[] partition(Node left, Node right) {
        Node pivot = right;
        Node dummy = new Node(-1, left);
        Node prev = dummy;
        Node partitionEnd = dummy;
        
        Node current = left;
        while (current != pivot) {
            if (current.val < pivot.val) {
                partitionEnd = current;
                prev = current;
                current = current.next;
            } else {
                Node next = current.next;
                prev.next = next;
                
                current.next = pivot.next;
                pivot.next = current;
                current = next;
            }
        }
        
        if (dummy.next != left) {
            head = dummy.next; // Update head only for leftmost partition
        }
        
        return new Node[]{pivot, partitionEnd};
    }

    // Ensures tail points to the last node
    private void fixTail() {
        Node current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        tail = current;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}