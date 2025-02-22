// @Test Class provided by Deepseek AI
/*Compile and Execute:
* javac HTList.java TestHTList.java
* java TestHTList
*/

public class TestHTList {
    public static void main(String[] args) {
        // Test caso base: lista 3 -> 1 -> 2
        HTList list = new HTList(null, null);
        list.addAsTail(3);
        list.addAsTail(1);
        list.addAsTail(2);
        testSort(list, "Caso Base");

        // Caso 1: Lista vuota
        HTList list1 = new HTList(null, null);
        testSort(list1, "Lista Vuota");

        // Caso 2: Elemento singolo
        HTList list2 = new HTList(null, null);
        list2.addAsTail(5);
        testSort(list2, "Singolo Elemento");

        // Caso 3: Lista in ordine inverso 3 -> 2 -> 1
        HTList list3 = new HTList(null, null);
        list3.addAsTail(3);
        list3.addAsTail(2);
        list3.addAsTail(1);
        testSort(list3, "Lista Inversa");

        // Caso 4: Elementi duplicati 2 -> 2 -> 1
        HTList list4 = new HTList(null, null);
        list4.addAsTail(2);
        list4.addAsTail(2);
        list4.addAsTail(1);
        testSort(list4, "Elementi Duplicati");
    }

    private static void testSort(HTList list, String testName) {
        System.out.println("=== " + testName + " ===");
        System.out.print("Originale: ");
        printList(list);
        
        HTList sorted = list.quickSort();
        
        System.out.print("Ordinato:  ");
        printList(sorted);
        System.out.println("Tail: " + (sorted.tail != null ? sorted.tail.val : "null"));
        System.out.println();
    }

    private static void printList(HTList list) {
        if (list.head == null) {
            System.out.println("Lista vuota");
            return;
        }
        
        HTList.Node current = list.head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}


/*  Expected Outputs:

=== Caso Base ===
Originale: 3 1 2 
Ordinato:  1 2 3 
Tail: 3

=== Lista Vuota ===
Originale: Lista vuota
Ordinato:  Lista vuota
Tail: null

=== Singolo Elemento ===
Originale: 5 
Ordinato:  5 
Tail: 5

=== Lista Inversa ===
Originale: 3 2 1 
Ordinato:  1 2 3 
Tail: 3

=== Elementi Duplicati ===
Originale: 2 2 1 
Ordinato:  1 2 2 
Tail: 2

*/