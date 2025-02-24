import java.nio.file.FileStore;
import java.util.ArrayList;

public class LinkedList{
    private Node head;  // Is the variable that holds the first node in the LinkedList.
    private Node last_node;   // Is the variable that holds the last node in the LinkedList.


    public LinkedList(){    // Creates empty construct in  LinkedList class
        head = null;
        last_node = null;
    }
    
    public boolean is_empty(){  //Checks if the head variable is empty
        return head == null;
    }

    public void  sortedAdd(int id,String name ,String surname ,String country,String city, String occupation ){  // Function that adds nodes sequentially to a Linkedlist
        Node newnode = new Node(id,new CustomerData(name,surname,country,city,occupation));
        if(is_empty() || id<head.getId() ){  // Creates the first node if Linkedlist is empty or allows the node with the lowest id to be added to the top of the list
            newnode.setlink(head);
            head = newnode;
            if(last_node == null){
                last_node = head;
            }
            return;
        }
        Node present = head;    // Created a called "present" variable to insert the new node in the middle of the list
        while(present.getLink() != null && id >= present.getLink().getId()){  // Finds the node that will be in the linkedlist after the id of the new node
            present = present.getLink();
        }
        newnode.setlink(present.getLink()); 
        present.setlink(newnode);
        if(newnode.getLink() == null){  // Checks if the new node is the last node in the linkedlist.
            last_node = newnode;
        }
    }

    public ArrayList<Integer> doctor(){                     //It scans the linkedlist from the beginning to the end 
        ArrayList<Integer> doctor_id = new ArrayList<>();  // and keeps the id information of the people whose profession is doctor in the array named doctor_id.
        Node position = head;
        while(position != null){
            if("Doctor".toLowerCase().equals(position.getData().getOccupation().toLowerCase()))
                doctor_id.add(position.getId());
            position = position.getLink();
        }
        return doctor_id; // Sends this arraylist back to be used

    }
    public ArrayList<Integer> avTurkey(){                   //It scans the linkedlist from the beginning to the end 
        ArrayList<Integer> turkey_id = new ArrayList<>();   // and keeps the id information of the people whose live in Turkey in the array named turkey_id.
        Node position = head;
        while(position != null){
            if("Turkey".toLowerCase().equals(position.getData().getCountry().toLowerCase()))
                turkey_id.add(position.getId());
            position = position.getLink();
        }
        return turkey_id; // Sends this arraylist back to be used
    }
    public ArrayList<Integer> nonAvTurkey(){                    //It scans the linkedlist from the beginning to the end 
        ArrayList<Integer> none_turkey_id = new ArrayList<>();  // and keeps the id information of the people whose do not live in Turkey in the array named none_turkey_id.
        Node position = head;
        while(position != null){
            if(!("Turkey".toLowerCase().equals(position.getData().getCountry().toLowerCase())))
                none_turkey_id.add(position.getId());
            position = position.getLink();
        }
        return none_turkey_id; // Sends this arraylist back to be used
    }
    public void printCustomer(){  // Prints the elements of the created linkedlist on the screen
        Node position = head;
        while(position != null){
            System.out.println("customer ID:"+position.getId()+" "+position.getData().toString());
            position = position.getLink();
        }
    }
}  

