public class CircleQueue{
    public int head;
    public int tail;
    public String[]items ;
    public int capicity;

    public CircleQueue(int len){
        if(len>0){
            items = new String[len];
            capicity = len;
        }
    }


    /**
     * 入队
     */
    public boolean enqueue(String item){
        //判断队列是否已满
        if((tail+1)%capicity == head){
            return false;
        }

        items[tail] = item;
        tail = (tail+1)%capicity;
        return true;

    }

    /**
     * 出队
     */
    public String dequeue(){
        //判断队列是否为空
        if(head == tail){
            return null;
        }

        String tmp = items[head];
        head = (head+1)%capicity;
        return tmp;
    }

}