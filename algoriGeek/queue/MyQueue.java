

/**
 * 基于数组实现队列
 */
public class MyQueue{

    public int head;
    public int tail;
    public String[] items;
    public int capacity;

    public MyQueue(int len){
        if(len>0){
            items = new String[len];
            head = 0;
            tail = 0;
            capacity = len;
        }
    }

    public boolean enqueue(String item){
        //判断队列是否已满
        if(tail == capacity && head==0){
            return false;
        }

        //队尾已满，但队头还有空余，需要做数据搬移
        if(head>0 && tail==capacity){
            for(int i=head;i<tail;i++){
                items[i-head] = items[i];
            }
            tail -=head;
            head = 0;
        }

        

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 
     * @return
     */
    public String dequeue(){
        //队列为空
        if(tail == head){
            return null;
        }


        String tmp = items[head];

        ++head;

        return tmp;
    }
}