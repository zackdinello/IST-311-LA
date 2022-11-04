package com.company;


public class DoublyLinkedList <T extends Comparable<T>> {

    protected Node head;
    protected Node tail;


    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    public Node append(Album album) {

        //create a new node
        Node toAppend = new Node(album);

        //check if list is empty
        if (head == null) {
            head = toAppend;
            tail = toAppend;
        }

        //if list length is one or more than one
        else {
            toAppend.previous = tail;
            tail.next = toAppend;
            tail = tail.next;
        }


        //return node
        return toAppend;
    }


    public Node delete(int location) throws IllegalArgumentException{

    }


    public int getIndex(Album album) {
        int index = 0;
        Node temp = head;
        while (temp != null){
            if(temp.data == album){
                return index;
            }
            temp = temp.next;
        }
    return -1;
    }


    public Node insert(int location, Album album) throws IllegalArgumentException{
        //Creating node
        Node newNode = new Node(album);

        //Checking whether our doubly linked list is empty or not
        if(head == null && location == 1) {
            head = newNode;
        }
        //Execute when the list is not empty
        else {
            int size = 0;
            Node temp = head;
            while (temp != null){
                temp = temp.next;
                size++;
            }
            if(location > size){
                throw new IllegalArgumentException();
            }
            if(location == size+1){

                //Call lastNode() method to add the node at last in the list
                tail.next = newNode;
                //The tail is pointing to the second last node so the newly created node's prev will point to tail
                newNode.previous = tail;
                //The newly created node will become new tail because it is last node in the doubly linked list
                tail = newNode;
                //The newly created node will be the last node so tail's next will be null
                tail.next = null;

            }else if(location == 1){

                //The head's prev will point to the newNode
                head.previous = newNode;
                //The newNode's next will point to the head
                newNode.next = head;
                //The newNode's prev will point to null because it will be the first node
                newNode.previous = null;
                //The newNode will become new head because now the newly created node is the first node of the list
                head = newNode;

            }else{
                //current node will point to head
                Node current = head;
                Node temp1 = null;

                //Iterate list till current points to the specified position
                for(int i = 1; i < location-1; i++){
                    current = current.next;
                }

                //The temp node points to the node that is next to current
                temp1 = current.next;
                temp1.previous = current;

                //newNode will be added between current and temp
                current.next = newNode;
                newNode.previous = current;
                newNode.next = temp1;
                temp1.previous = newNode;
            }
        }
        return newNode;

    }


    public Node shuffle() {


    }


    public DoublyLinkedList<Album> partition(Album album) {


    }


    @Override
    public String toString() {

        // get a current pointer
        Node toPrint = this.head;

        // get a string builder
        StringBuilder stringBuilder = new StringBuilder();

        // loop through all the nodes
        while (toPrint != null) {

            // append the content of the string to the builder
            stringBuilder.append(toPrint.album.numberOfSongs);
            stringBuilder.append(" -> ");

            // advance the pointer
            toPrint = toPrint.next;
        }

        // append null
        stringBuilder.append("NULL");

        // return the result
        return stringBuilder.toString();
    }
}
