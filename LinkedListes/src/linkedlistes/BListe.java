package linkedlistes;

/**
 *
 * @author amacemirhan
 * Mehmed Emirhan Amaç - 170420517
 */
public class BListe {

    Node head = null;
    
    public void reverse(){
    Node next;
    Node temp = head;
    temp = temp.next;
    Node previus = head;
    head.next=null;
    while (temp.next != null) {
            next=temp.next;
            temp.next=previus;
            head=temp;
            
            previus=head;
            temp = next;
        }
    temp.next=previus;
    head=temp;
    }
    
    public float medyan(BListe list) {
        Node temp = head;

        int n = list.elementCount();
        int i = 0;
        int j = 1;
        int top = 0;
        if (n == 0) {
            return 0;
        } else if (n % 2 == 1) {
            i = n / 2;
            while (temp.next != null) {
                if (j == i+1) {
                    return temp.data;
                }
                j++;
                temp = temp.next;
            }
        } else {
            i = n/2;
            while (temp.next != null) {
                if (j == i) {
                    top=temp.data;
                    temp = temp.next;
                    return (float)(top+temp.data)/2;
                }
                j++;
                temp = temp.next;
            }
            

        }

    return 0;
    }

    public void siraliEkle(int item) {
        Node temp = head;
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = null;
        int i = 0;
        int j = 0;
        while (temp.next != null) {
            if (temp.data > item) {
                break;
            }
            i++;
            temp = temp.next;
        }
        temp = head;
        while (temp.next != null) {
            if (j == i - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
            j++;
            temp = temp.next;

        }

    }

    public void concatenate(BListe first, BListe second) {
        Node temp = first.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = second.head;
    }

    public Node getFirst() {
        if (head != null) {
            return head;
        } else {
            System.out.println("bağıl liste boş");
        }

        return null;
    }

    public boolean contains(int item) {
        Node temp = head;

        int i = 0;
        while (temp != null) {
            if (temp.data == item) {
                System.out.print(i + " ");
                return true;
            }
            temp = temp.next;
            i++;
        }

        return false;
    }

    public void set(int n, int item) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (i == n) {
                temp.data = item;
            }
            i++;
            temp = temp.next;
        }

    }

    public void initialize(int data) {
        head = new Node();
        head.data = data;
        head.next = null;
    }

    public void addElementLast(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public int elementCount() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void addElementFront(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    public boolean deleteNode(int data) {
        boolean durum = false;
        Node current = head;
        Node tmp = null;
        if (current.data == data) {
            tmp = current.next;
            head = tmp;
        } else { // else
            {
                while (current.next != null) {
                    if (current.next.data == data) {
                        tmp = current.next;
                        current.next = tmp.next;
                        durum = true;
                        break;
                    }
                    current = current.next;
                }
            }
            return durum;
        }
        return false;
    }
}
