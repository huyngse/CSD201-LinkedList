/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistproject;

/**
 *
 * @author huyngo
 */
public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addLast("D");
        list.addLast("E");
        list.addLast("F");
        list.addLast("G");
        Node nodeE = list.getNode("E");
        list.addAfter(nodeE, "H");
        list.display();
        System.out.println("Size: " + list.size);
        
        System.out.println("Remove first: " + list.removeFirst());
        list.display();
        System.out.println("Remove last: " + list.removeLast());
        list.display();
        Node nodeD = list.getNode("D");
        System.out.println("Remove after node D: " + list.removeAfter(nodeD));
        list.display();
        System.out.println("Remove node A: " + list.remove("A"));
        list.display();
        
        System.out.println("Size: " + list.size);
        
    }
    
}
