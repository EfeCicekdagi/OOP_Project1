public class Node {
    private CustomerData data;
    private int id;
    private Node link;  // "link" variable is used to link to another Node object

    public Node(){  //Creates empty construct in Node class
        data = null;
        id = 0 ;
        link = null;
    }

    public Node( int id,CustomerData data){  //Creates a parameterised construct in the Node class
        this.data = data;
        this.id = id;  
        link = null;      
    }

    public CustomerData getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    public Node getLink() {
        return link;
    }

    public void setData(CustomerData data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setlink(Node link) {
        this.link = link;
    }
    
}
