
public class MyQueueTest{
    public static void main(String[]args){
        
        // T0();
        // T1();
        T2();

    }

    /**
     * 测试数组实现的队列
     */
    public static void T0(){
        String t = "abcdef";
        MyQueue queue = new MyQueue(t.length());
        for(String s:t.split("")){
            queue.enqueue(s);
        }

        String s = queue.dequeue();
        System.out.println(s);
        String s1 = queue.dequeue();
        System.out.println(s1);

        queue.enqueue("A");
        System.out.println(queue.tail);
    }

    /**
     * 基于链表实现的队列
     */
    public static void  T1(){
        String t = "abcdef";
        MyQueueList queue = new MyQueueList();
        for(String s:t.split("")){
            queue.enqueue(s);
        }

        String s = queue.dequeue();
        System.out.println(s);
        String s1 = queue.dequeue();
        System.out.println(s1);

        queue.enqueue("A");
        System.out.println(queue.tail);
    }

    /**
     * 循环队列
     */
    public static void T2(){
        String t = "abcdef";
        CircleQueue queue = new CircleQueue(t.length());
        for(String s:t.split("")){
            queue.enqueue(s);
        }

        String s = queue.dequeue();
        System.out.println(s);
        String s1 = queue.dequeue();
        System.out.println(s1);

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue.tail);


    }
}