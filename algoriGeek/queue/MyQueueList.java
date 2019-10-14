

/**
 * 基于链表实现队列
 */
public class MyQueueList{

    public LinkNode<String> head;
    public LinkNode<String> tail;

    public MyQueueList(){
       
    }

    public boolean enqueue(String item){
        LinkNode<String> node = new LinkNode<String>(item, null);
        //判断队列是否为空
        if(head==null){
            head = node;
            tail = node;
            return true;
        }

        if(head!=null && head==tail){
            tail = node;
            head.next = tail ;
            return true;
        }

        tail.next = node ;    
        tail = node;    
        return true;
    }

    /**
     * 
     * @return
     */
    public String dequeue(){
        //队列为空
        if(head == null){
            return null;
        }

        if(head == tail){
            String tmp =  head.data;
            head = null;
            tail = null;
            return tmp;
        }

        String tmp = head.data;
        head = head.next;
        return tmp;
    }
}