package com.company;


import javax.swing.*;
import java.util.List;

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
        Node temp1 = null;
        int size = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            size++;
        }

        //Check whether the DDL is empty or not
        if(head == null || location>size) {
            throw new IllegalArgumentException();
            //System.out.println("\n" +position +"th position is not available\n");
        }
        //Execute when the DDL is not empty
        else {
            if(location == 1){

                //Call deleteFirstNode() method to delete first node from the DDL
                temp1 = head;
                head = head.next;

                //Decrement the size of DDL


            }else if(location == size){
                //Call deleteLastNode() method to delete last node from the DDL
                temp1 = tail;
                tail = tail.previous;

                //Decrement the size of DDL


            }else{
                //current node will point to head
                Node current = head;

                //Iterate list till current points to the specified position
                for(int i = 1; i < location; i++){
                    current = current.next;
                }

                //Delete node pointed by current
                temp1  = current;
                current.next.previous = current.previous;
                current.previous.next = current.next;

            }
            return temp1;
        }
    }


    public int getIndex(Album album) {
        int index = 0;
        Node temp = head;
        while (temp != null){
            if(temp.album == album){
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
        Node temp = head;
        int randomX = (int) (Math.random() * 10 + 1);

//simply go until the randomX
        while(randomX-- > 0 && temp.next != null)
            temp = temp.next;

//remove the Nth node from the list
        temp.previous.next = temp.next;

        if(temp.next != null)
            temp.next.previous = temp.previous;

//set it to point to the head
        temp.next = (head);
        temp.previous = (null);

//now set the Head to the Nth node we found
        head = temp;
        return head;
    }


    public DoublyLinkedList<Album> partition(Album album) {
        DoublyLinkedList<Album> list = new DoublyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            if (temp.album.compareTo(album) == 1) {
                list.append(album);
            } else if (temp.album.compareTo(album) > 1) {
                list.append(album);
            }
                temp = temp.next;

        }
        return list;
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
