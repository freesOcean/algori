
/**
 * 利用栈数据结构判断括号是否匹配
 * 比如：{[()]}就是匹配的， {[())} 、{}()等 这是不符合的，左右不对称.
 * 题目：给定一个字符串，它是由括号符组成，判断是否符合前后匹配
 * 
 * 思路：定义一个栈用来保存遍历的括号符，遍历这个字符串，每次取出一个字符先判断符合是左括号还是右括号
 * 如果是左括号，压入栈，如果是右括号，则从栈中取出一个进行对比，如果都相等，并且栈中没有元素剩余。则
 * 
 */
public class MyStackTest {
    public static void main(String[] args){

        MyStackTest t = new MyStackTest();
        String test = "{([])}";
        boolean  re = t.isMirror(test);
        System.out.println(re);

        

    }

    public  boolean isMirror(String str){
        MyStack stack = new MyStack(str.length());
        
        for(char c:str.toCharArray()){
            if(isLeft(c)){
                stack.push(c);
            }else if(isRight(c)){
                //取出栈顶的括号
                char top = stack.pop();
                boolean isMatch = isMatch(top, c);
                if(!isMatch){
                    return false;
                }
            }
        }

        if(stack.count>0){
            return false;
        }
        return true;

    }

    public  boolean isLeft(char s){
        if(s=='('||s=='['||s=='{'){
            return true;
        }
        return false;

    }

    public  boolean isRight(char s){
        if(s==')'||s==']'||s=='}'){
            return true;
        }
        return false;

    }

    public  boolean isMatch(char left,char right){
        String combine = left+""+right+"";

        if(combine.equals("()") || combine.equals("[]") || combine.equals("{}")){
            return true;
        }
        return false;
    }


}