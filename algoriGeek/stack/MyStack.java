import java.lang.reflect.Array;

/**
 * 定义一个
 */
public class MyStack {
    
    public int count;//当前栈中元素的个数
    public char[] items ;
    public int height;//栈的高度

    public MyStack(){
    }

    public MyStack(int len){
        if(len>0){
            items = new char[len];
            count = 0;
            height = len;
        }
    }

    /**
     * 判断一个栈是否为空
     * @return
     */
    public boolean isEmpty(){
        if(count==0){
            return true;
        }
        return false;
    }

    /**
     * 压入栈
     * @param item
     * @return
     */
    public boolean push(char item){
        //判断栈是否已满
        if(count==height){
            return false;
        }

        //将元素压入栈，并更新count
        items[count] = item;
        ++count;
        return true;
    }


    /**
     * 从栈中弹出一个元素
     * @return
     */
    public Character pop(){
        //判断栈中是否为空
        if(isEmpty()){
            return null;
        }
        char tmp = items[count-1];
        --count;
        return tmp;
    }




}