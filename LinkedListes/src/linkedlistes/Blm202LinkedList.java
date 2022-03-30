package linkedlistes;

/**
 *
 * @author amacemirhan
 * Mehmed Emirhan Amaç - 170420517
 */
public class Blm202LinkedList {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        BListe b1 = new BListe();
        BListe b2 = new BListe();
        
        b1.initialize(2);
        b1.addElementLast(3);
        b1.addElementLast(1);
        
        b2.initialize(4);
        b2.addElementLast(5);
        
        b1.printLinkedList();
        b2.printLinkedList();
        
        //b1.concatenate(b1, b2); ikisi de kullanılabilir
        b2.concatenate(b1, b2);
        System.out.println("birleşmiş liste:");
        b1.printLinkedList();
        b2.printLinkedList();//sona eklenen listenin headi hala eskisi gibi
        
        System.out.println("-------------------------------");
        BListe b3 = new BListe();
        
        b3.initialize(2);
        b3.addElementLast(7);
        b3.addElementLast(9);
        b3.addElementLast(13);
        b3.printLinkedList();
        
        b3.siraliEkle(8);
        b3.printLinkedList();
        
        System.out.println("-------------------------------");
        
        System.out.println(b3.medyan(b3));
        System.out.println(b2.medyan(b2));
        
        BListe b4 = new BListe();
        System.out.println(b4.medyan(b4));//boş liste
        
        System.out.println("-------------------------------");
        
        b3.reverse();
        b3.printLinkedList();
        
        
        
        
        
    }

}
