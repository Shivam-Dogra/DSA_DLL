package DSA.Singly_LinkedList.DoublyLinkedList;

public class Structure {
    private int len;
    private Node head;
    private Node tail;

    class Node {
        int data;
        Node next;
        Node previous;

        Node(int value){
            this.data = value;
        }
    } 

    public Structure(int data){
        //create node
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        len = 1;
    }


    //print ddl
    public void printDDL(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    //Append Node -> Insert at the end of the ddl
    public void appendNode(int data){
        //create node
        Node newNode = new Node(data);
        if(len == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        len++;
    }

    //Delete Node -> Remove last node of the ddl
    public Node removeLast(){
        if(len == 0){
           return null;
        }
        Node temp = tail;
        if(len == 1){
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
            temp.previous = null;
        }
        len--;
        return temp;
    }

    //Preprend - Insert Node at the start of the ddl
    public void preprend(int value){
        //create node
        Node newNode = new Node(value);
        if(len==0){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        len++;
    }

     //Delete Node -> Remove first node of the ddl
     public Node removeFirst(){
        if(len == 0) return null;
        Node temp = head;
        if(len==1){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
            temp.next = null;
        }
        len--;
        return temp;
     }


     //Read -> Get Node by passing index
     public Node get(int index){
        if(index < 0 || index >= len) return null;
        Node temp = head;
        if(index < len/2){
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }    
        } else {
            temp = tail;
            for (int i = len-1; i > index; i--) {
                temp = temp.previous;
            }
        }
        return temp;
     }

     //Update -> Set Node by passing index and value
     public boolean set(int index, int data){
        Node temp = get(index);
        while(temp!=null){
            temp.data = data;
            return true;
        }
        return false;
     }
    
}
