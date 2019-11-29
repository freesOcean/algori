
public class Solution {

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
     * 
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l11 = new ListNode(0);
        ListNode l12 = new ListNode(0);

        ListNode re = rever(l1, l2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }

    }

    public ListNode s(ListNode l1, ListNode l2) {
        // 思路，从低位相加，去sum%10创建一个节点，进位 carry = sum/10;如果有进位就带到下一次计算
        ListNode node = new ListNode(0);
        int carry = 0;
        ListNode curentNode;
        while (l1 != null && l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            // if(curr)
            // curentNode
        }

        return null;
    }
    // public ListNode s(ListNode l1,ListNode l2,int a){

    // }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public static ListNode add(ListNode l1, ListNode l2, int a) {
        if (l1 == null && l2 == null && a == 0)
            return null;
        int x = l1 == null ? 0 : l1.val;
        int y = l2 == null ? 0 : l2.val;
        int sum = x + y + a;
        ListNode n = new ListNode(sum % 10);
        n.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
        return n;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode cur = head;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = node;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }

    public ListNode a(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int x = l1 == null ? 0 : l1.val;
        int y = l2 == null ? 1 : l2.val;
        int sum = x + y + carry;
        ListNode n = new ListNode(sum % 10);
        carry = sum / 10;
        n.next = a(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);

        return n;
    }

    public static ListNode rever(ListNode l1, ListNode l2) {
        // 按照从节点从前往后依次相加，记录一个cur节点，如果相加时结果大于9说明cur要+1
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y;
            if (sum > 9) {
                cur.val = cur.val + 1;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        //如果头节点的值不是0，说明产生了进位
        if (head.val == 0) {
            return head.next;
        } else {
            return head;
        }

    }

    public static ListNode addTwoNumbersz(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int prio = 0;
        int number1 = l1 == null ? 0 : l1.val;
        while (l1.next != null) {
            prio += 1;
            number1 += l1.next.val * ((int) Math.pow(10, prio));
            l1 = l1.next;
        }

        prio = 0;
        int number2 = l2 == null ? 0 : l2.val;
        while (l2.next != null) {
            prio += 1;
            number2 += l2.next.val * ((int) Math.pow(10, prio));
            l2 = l2.next;
        }
        int result = number1 + number2;

        System.out.println(result);

        ListNode headNode = null;
        if (result == 0) {
            headNode = new ListNode(0);
            return headNode;
        }

        while (result % 10 > 0 || result / 10 > 0) {
            int value = result % 10;
            ListNode node = new ListNode(value);
            if (headNode == null) {
                headNode = node;
            } else {
                // 插入结点：
                ListNode tail = headNode;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = node;
            }
            result = result / 10;
        }

        return headNode;
    }

}