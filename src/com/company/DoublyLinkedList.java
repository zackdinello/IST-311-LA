package com.company;


import javax.swing.*;
import java.util.List;

public class DoublyLinkedList <T extends Comparable<T>> {

    protected Node head;
    protected Node tail;


    public DoublyLinkedList() {
        head = null;
        tail = null;
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
        int i = 1;
        boolean flag = false;
        //Node current will point to head
        Node current = head;

        //Checks whether the list is empty
        if (head == null) {
            return -1;
        }
        while (current != null) {
            //Compare value to be searched with each node in the list
            if (current.album == album) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        if (flag)
            return i;

    return -1;
}


    public Node insert(int position,Album album) throws IllegalArgumentException {

        //1. allocate node to new element
        Node newNode = new Node(album);
        newNode.next = null;
        newNode.previous = null;

        //2. check if the position is > 0
        if (position < 1) {
            throw new IllegalArgumentException();
        } else if (position == 1) {

            //3. if the position is 1, make new node as head
            head = newNode;

        } else {

            //4. Else, make a temp node and traverse to the
            //   node previous to the position
            Node temp = null;
            temp = head;
            for (int i = 1; i < position - 1; i++) {
                if (temp != null) {
                    temp = temp.next;
                } else {
                    throw new IllegalArgumentException();
                }
            }

            //5. If the previous node is not null, adjust
            //   the links
            if (temp != null) {
                newNode.previous = temp;
                if (temp.next != null) {
                    newNode.next = temp.next;
                    newNode.next.previous = newNode;
                    temp.next = newNode;
                }else {
                    temp.next = newNode;
                }
            }
        }
        return newNode;
    }


    public Node shuffle() {
        Node temp = head;

        /*
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

         */
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
