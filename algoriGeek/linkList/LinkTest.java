/**
 * 链表测试
 */
 public class LinkTest{
     public static void main(String[] args) {
        LinkTest test = new LinkTest();
        // test.T0();
        // test.T1();
        // test.T2();
        // test.T3();
        // test.TT();
        test.T4();

        // char a = 'A';
        // char b = 'A';
        // System.out.println(a==b);



     }

     public UnidirectLinkList createLinkList(String str){
        UnidirectLinkList linkList = new UnidirectLinkList();
        char[]arr = str.toCharArray();
        for(char c:arr){
            LinkNode node = new LinkNode<Character>(c,null);
            linkList.insert(node);
        }
        return linkList;
     }

     public void T0(){
          //测试单向列表存储字符串，判断是否是回文串
        String str = "Abc";
        UnidirectLinkList linkList = createLinkList(str);
        
        System.out.println(linkList.head.data);
        boolean re = linkList.isPalindrome();
     }

     public void T1(){
         //单向链表反转
         String str = "Abc";
         UnidirectLinkList linkList = createLinkList(str);
        String re = linkList.reverseNode();
        System.out.println(re);
     }

     public void T2(){
         //链表环路检测
         String str = "abc";
         UnidirectLinkList linkList = new UnidirectLinkList();
         char[]arr = str.toCharArray();

         for(int i=0;i<arr.length;i++){
             LinkNode node = new LinkNode<Character>(arr[i], null);
             if(i==(arr.length-1)){
                 node.next =  linkList.head;
             }
             linkList.insert(node);
         }

         boolean re = linkList.hashLoopLink();
         System.out.println(re);
     }

     /**
      * 找到链表的中间节点：快慢指针。slow
      */
     public void T3(){
        String str = "Abc";
        UnidirectLinkList linkList = createLinkList(str);
        String re = linkList.reverseNode();
        System.out.println(re);
     }

     public void TT(){
        String str = "Abcdef";
        UnidirectLinkList linkList = createLinkList(str);
        String re = linkList.deleteNode(0);
        System.out.println(re);
    
     }
     /**
      * 删除链表的倒数第n个节点
      */
     public void T4(){
        
        String str = "Abcdef";
        UnidirectLinkList linkList = createLinkList(str);
        String re1 = linkList.reverseNode();
        UnidirectLinkList temp1 = createLinkList(re1);
        String re2  = temp1.deleteNode(1);
        UnidirectLinkList temp2 = createLinkList(re2);
        String refinal = temp2.reverseNode();
        System.out.println(refinal);

        // LinkListAction action = new LinkListAction();
        // String re = action.deleteNodeReverse(linkList, linkList.head, 1);
        //String re = linkList.deleteNodeReverse(1);
        // System.out.println(re);
     }
 }