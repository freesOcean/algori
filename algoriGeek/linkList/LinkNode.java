
public class LinkNode<T>{
    public T data;
    public LinkNode next;

    public LinkNode(T data,LinkNode node){
        this.data = data;
        this.next = node;
    }

}