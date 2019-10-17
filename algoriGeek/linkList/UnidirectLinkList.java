import java.util.HashMap;

import javax.lang.model.type.NullType;

import org.w3c.dom.NodeList;

/**
 * 单向链表
 */
public class UnidirectLinkList{

    public  LinkNode head;

    /**
     * 普通插入结点
     * @param node
     */
    public void insert(LinkNode node){
        if(head == null){
            head = node;
        }else{
            LinkNode tail = head;
            while(tail.next!=null){
                tail = tail.next;
            }
            tail.next = node;
        }
    }
    /**
     * 基于哨兵节点进行插入，简化代码. 需要提前初始化哨兵节点。
     */
    public void insertBaseSentinel(LinkNode node ){
        LinkNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = node;
    }


  


    /**
     * 判断当前单链表中的字符序列是否是回文串
     * @return
     */
    public boolean isPalindrome(){
        
        //对于边界情况：一个字符和空串
        if(head==null || head.next==null){
            return true;
        }


        LinkNode slow = head;
        LinkNode quick = head;
        LinkNode pre = null;

        //慢指针每次前进一步，快指针每次前进两步。并在前进过程中，每次修改慢指针的后继指针，
        //从而使前半段节点逆序。最后当快指针到最后时，慢指针刚好停止在中间节点。pre会停在前半段逆序后的第一个节点。
        while(quick!=null && quick.next!=null){
            //移动快指针
            quick = quick.next.next;
            //修改后继指针
            LinkNode next = slow.next;
            slow.next = pre;
            pre = slow;
            //移动慢指针
            slow = next;
        }
        
        //如果序列表是奇数，此时slow落在中间位置，quick刚好落在最后一位。如果是偶数，此时slow落在中下位,并且此时quick指针为null。
        if(quick!=null){
            slow = slow.next;
        }

        //判断前半段和后半段的序列是否相当

        while(slow!=null){
            if(slow.data!=pre.data){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;


    }


    /**
     * 单向链表反序
     * @return
     */
    public String reverseNode(){
         //对于边界情况：一个字符和空串
         if(head==null || head.next==null){
            return "";
        }

        // LinkNode slow = head;
        LinkNode pre = null;
        while(head!=null && head.next!=null){
            LinkNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        head.next = pre;
        

        return append();
    }

    public void reverseWithNoReturn(){
        if(head==null||head.next==null){
            return ;
        }

        LinkNode pre = null;
        while(head!=null && head.next!=null){
            LinkNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        head.next = pre;
    

    }

    public String append(){
        if(head==null || head.next ==null){
            return "";
        }   

        StringBuilder builder = new StringBuilder();
        while(head!=null){
            builder.append(head.data);
            head = head.next;
        }

        return builder.toString();

    }


    /**
     * 当前链表环路检测
     * 思路：用一个集合保存已经遍历过的节点，从链表的头结点开始遍历，
     * 每到一个节点判断节点的next节点是否在集合，如果有说明有环路。没有则将该节点加入集合，继续。
     * @return
     */
    public boolean hashLoopLink(){
        if(head==null||head.next==null){
            return false;
        }
        HashMap<Integer,LinkNode> map = new HashMap<>();
        int index = 0;
        while(head!=null &&head.next!=null){
            LinkNode next = head.next;
            boolean isExist = map.containsValue(next);
            if(isExist){
                return true;
            }
            map.put(index, head);
            head = head.next;
            ++index;
        }

        return false;
    }

    /**
     * 删除链表中的倒数第n个节点
     * 思路：1.先将链表进行逆序
     *      2.反转后按照删除第n个节点的算法删除，
     *      3.将最终链表再次逆序
     * @param n
     * @return
     */
    public String deleteNodeReverse(int n){
        reverseNode();
        deleteNode(n);
        String re =  reverseNode();
        return re;
    }

    /**
     * 删除链表中的第n个节点
     * 思路
     * 1.遍历链表，记录index，当遍历到第n-1时，设置当前节点的next为 删除节点的下一个节点.
     * 2.边界判断：判断n是否为0,判断n-1节点之后是否有节点。
     * @return
     */
    public String deleteNode(int n){
        
        if(head==null ||n<0){
            return "not found";
        }
        if(n==0){
            head = head.next;
            return append();
        }
        int index = 0;
        LinkNode slow = head;
        while(slow!=null && slow.next!=null){
            if(index == n-1){   
                slow.next = slow.next.next;
                return append();
            }
            slow = slow.next;
            ++index;
        }
        return "not found";
    }

    public void deleteNodeWithNoArags(int n){
        if(head==null||n<0){
            return;
        }


        if(n==0){
            head = head.next;
            return;
        }

        int index = 0;
        LinkNode slow = head;
        while(slow!=null && slow.next!=null){
            if(index == n-1){
                slow.next = slow.next.next;
                return;
            }
            slow = slow.next;
            ++index;
        }
        

    }
    /**
     * 删除链表中值等于某某的节点
     * @param node
     * @return
     */
    public String deleteNode(LinkNode node){
        if(node==null){
            return "not found!";
        }

        if(head==null){
            return "linkList is empty";
        }

        //如果删除的是头节点
        if(head.data==node.data){
            if(head.next!=null){
                head = head.next;
            }else{
                head = null;
            }
            return append();
        }

        

        while(head!=null && head.next!=null){
           LinkNode next = head.next;
           if(node.data==next.data){
                head = head.next.next;
                return append();
           }
           head = head.next;
        }

        return "not found";
    }
}