package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

//    @Test
//    void testAppend() {
//        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
//        assertNull(dll.head);
//        assertNull(dll.tail);
//
//        ArrayList<String> artistNames = new ArrayList<>();
//        artistNames.add("Artist 1");
//        artistNames.add("Artist 2");
//
//        Album a1 = new Album(1, artistNames, "album 1", 1);
//        assertEquals(1, dll.append(a1).album.numberOfSongs);
//
//        Album a2 = new Album(2, artistNames, "album 2", 2);
//        assertEquals(2, dll.append(a2).album.numberOfSongs);
//
//        Album a3 = new Album(3, artistNames, "album 3", 3);
//        assertEquals(3, dll.append(a3).album.numberOfSongs);
//
//        assertEquals(1, dll.head.album.numberOfSongs);
//
//        assertEquals("1 -> 2 -> 3 -> NULL", dll.toString());
//
//    }


    @Test
    void testGetIndex() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();


        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        ArrayList<String> artistNames1 = new ArrayList<>();
        artistNames1.add("Artist 1");
        artistNames1.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        dll.insert(1,a1);
        //assertEquals(1, dll.getIndex(a1));

        Album a2 = new Album(2, artistNames, "album 2", 1);
        dll.insert(2,a2);
        assertEquals(2, dll.getIndex(a2));

        Album a3 = new Album(3, artistNames, "album 3", 3);
        dll.insert(3,a3);
        assertEquals(3, dll.getIndex(a3));

        assertEquals(1, dll.head.album.numberOfSongs);

        //assertEquals("1 -> NULL", dll.toString());

    }


    @Test
    void testDelete() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();


        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        ArrayList<String> artistNames1 = new ArrayList<>();
        artistNames1.add("Artist 1");
        artistNames1.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        dll.insert(1,a1);
        //assertEquals(1, dll.getIndex(a1));

        Album a2 = new Album(2, artistNames, "album 2", 1);
        dll.insert(2,a2);
        assertEquals(2, dll.getIndex(a2));

        Album a3 = new Album(3, artistNames, "album 3", 3);
        dll.insert(3,a3);
        assertEquals(3, dll.getIndex(a3));

        assertEquals(1, dll.head.album.numberOfSongs);
        dll.delete(2);


        assertEquals("1 -> 3 -> NULL", dll.toString());

    }


    @Test
    void testInsert() {

        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        ArrayList<String> artistNames1 = new ArrayList<>();
        artistNames1.add("Artist 1");
        artistNames1.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        dll.insert(1,a1);
        //assertEquals(1, dll.getIndex(a1));

        Album a2 = new Album(2, artistNames, "album 2", 1);
        dll.insert(2,a2);
        assertEquals(2, dll.getIndex(a2));

        Album a3 = new Album(3, artistNames, "album 3", 3);
        dll.insert(3,a3);
        assertEquals(3, dll.getIndex(a3));

        assertEquals(1, dll.head.album.numberOfSongs);



        assertEquals("1 -> 2 -> 3 -> NULL", dll.toString());


    }


    @Test
    void testShuffle() {

    }


    @Test
    void testPartition() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        ArrayList<String> artistNames1 = new ArrayList<>();
        artistNames1.add("Artist 1");
        artistNames1.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        dll.insert(1,a1);
        //assertEquals(1, dll.getIndex(a1));

        Album a2 = new Album(2, artistNames, "album 2", 1);
        dll.insert(2,a2);
        assertEquals(2, dll.getIndex(a2));

        Album a3 = new Album(3, artistNames, "album 3", 3);
        dll.insert(3,a3);
        assertEquals(3, dll.getIndex(a3));

        Album a4 = new Album(4, artistNames, "album 4", 3);
        dll.insert(4,a3);
        assertEquals(4, dll.getIndex(a4));

        Album a5 = new Album(5, artistNames, "album 5", 3);
        dll.insert(4,a5);
        assertEquals(4, dll.getIndex(a5));

        dll.partition(a2);

        assertEquals("2 -> 3 -> 4 -> NULL", dll.toString());
    }

    @Test
    void testToString() {
        DoublyLinkedList<Album> dll = new DoublyLinkedList<>();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        ArrayList<String> artistNames1 = new ArrayList<>();
        artistNames1.add("Artist 1");
        artistNames1.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        dll.insert(1,a1);
        //assertEquals(1, dll.getIndex(a1));

        Album a2 = new Album(2, artistNames, "album 2", 1);
        dll.insert(2,a2);
        assertEquals(2, dll.getIndex(a2));

        Album a3 = new Album(3, artistNames, "album 3", 3);
        dll.insert(3,a3);
        assertEquals(3, dll.getIndex(a3));

        Album a4 = new Album(4, artistNames, "album 4", 3);
        dll.insert(4,a3);
        assertEquals(4, dll.getIndex(a4));

        Album a5 = new Album(5, artistNames, "album 5", 3);
        dll.insert(4,a5);
        assertEquals(4, dll.getIndex(a5));

        dll.partition(a2);

        assertEquals("2 -> 3 -> 4 -> NULL", dll.toString());

    }

}