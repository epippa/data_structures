public class List {

    protected Node head;

    public List(Node head) {
        this.head = head;
    }

    //if there is not a first/starting Node, the list is empty
    public boolean isEmpty() {
        if (head == null){
            return true;
        }
        return false;
    }
    
    //walk through the entire list, until the last Node, incrementing a counter
    public int length() {
        if (head == null){
            return 0;
        }
        Node n = head;
        int temp = 0;
        while (n != null){
            n = n.next;
            temp += 1;
        }
        return temp;
    }

    //walk through the entire list comparing the value of every Node,
    //with also the value i
    public int floor(int i) {
        if (isEmpty() == true){
            return Integer.MIN_VALUE;
        }
        Node n = head;
        int temp = head.val;
        while (n.next != null){
            if ((n.next.val > temp) && (n.next.val <= i)){
                temp = n.next.val;
            }
            n = n.next;
        }
        if (temp <= i){
            return temp;
        }
        return Integer.MIN_VALUE;
    }

    //we reach the last position/Node, and we add there the list L
    public void addAll(List l) {
        if (isEmpty() == true){
            head = l.head;
        }
        else {
            Node n = head;
            while (n.next != null){
                n = n.next;
            }
            n.next = l.head;
        }
    }

    //increment a counter every time the next Node is greater than the current 
    //one, then we store that value in a variable, resetting the counter.
    //Then it compares the cariable and the counter, keeping the biggest one.
    public int maxAscent() {
        if (head == null){
            return 0;
        }
        int count = 1, temp = 1;
        Node n = head;
        while (n.next != null){
            if (n.val <= n.next.val){
                count += 1;
            }
            else {
                if (temp < count){
                    temp = count;
                    count = 1;
                }
                
            }
            n = n.next;
        }
        temp = Math.max(temp,count);
        return temp;
    }

    //walk through the array as long as the next node is bigger than the
    //current one. If the next node is neither null, nor a bigger value,
    //return false
    public boolean sorted() {
        if (isEmpty() == true){
            return true;
        }
        Node n = head;
        while (n.next != null){
            if (n.val > n.next.val){
                return false;
            }
            n = n.next;
        }
        return true;
    }

    //compares all the Nodes' value and stores the current biggest value 
    //into a variable
    public int extractMax() {
        if (isEmpty() == true){
            throw new RuntimeException("No elements in this list");
        }
        Node n = head;
        Node a = head;
        while (n != null){
            if (a.val < n.val){
                a = n;
            }
            n = n.next;
        }
        int i = a.val;
        a = a.next;
        return i;
    }
    
    //it calls and combines other methods, for copying the entire list and sorting
    //it by removing in loop the maximal (value) node, and adding it as head
    public List selectionSort() {
        List sorted = new List(null);
        if (head != null) {
            List clone = cloneList();
            while (clone.head != null) {
                Node max = clone.copyRemoveMax();
                sorted.addAsHead(max.val);
            }
        }
        return sorted;
    }
    
    //it creates a full copy (clone) of the original list
    public List cloneList(){
        if (head == null){
            List empty = new List(head);
            return empty;
        }
        Node current = head;
        Node cloneCurrent = new Node(current.val, null);
        List clone = new List(cloneCurrent);
        while (current.next != null) {
            current = current.next;
            Node n = new Node(current.val, null);
            cloneCurrent.next = n;
            cloneCurrent = n;
        }
        return clone;
    }
    
    //finds the Node with the Max value, then it copies the value into another
    //node. Furthermore, it removes that node from the list
    public Node copyRemoveMax(){
        if (head == null){
            throw new RuntimeException("No elements in this list");
        }
        Node currentMax = head;
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.val > currentMax.val) {
                currentMax = temp.next;
            }
            temp = temp.next;
        }
        Node max = new Node(currentMax.val, null);
        if (currentMax == head) {
            head = head.next;
        } else {
            temp = head;
            while (temp.next != currentMax) {
                temp = temp.next;
            }
            temp.next = currentMax.next;
        }
        return max;
    }    
    
    //it adds a node with value i at the head position.
    public void addAsHead(int i) {
        if (head == null){
            Node n = new Node(i, null);
            head = n;
        }
        else {
            Node n = new Node(i, head);
            head = n;
        }
    }

    //checks if the list is empty or if the fist value is greater/equal than the
    //value we want to insert. In that case addAsHead. Otherwise, it steps through
    //the list and inserts the value in front of a node with greater/equal value
    public void addSorted(int i) {
        if ((head == null) || (head.val >= i)){
            addAsHead(i);
            return;
        }
        Node pointer = head;
        Node n = new Node(i, null);
        while ((pointer.next != null) && (pointer.next.val < i)){
            pointer = pointer.next;
        }
        n.next = pointer.next;
        pointer.next = n;
    }

    //steps through the list, copying step by step every node and inserting it 
    //at the correct position in another list
    public List insertionSort() {
        if (head == null || head.next == null) {
            return cloneList();
        }
        List sorted = new List(null);
        Node current = head;
        while (current != null) {
            Node after = current.next;
            sorted.addSorted(current.val);
            current = after;
        }
        return sorted;
    }

    public List mergeSort() {
        return null;
    }

}
