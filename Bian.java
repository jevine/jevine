import java.util.ArrayList;
public class Bian {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();

        sb.append(5);
        sb.append(6);
        System.out.println(sb.toString());
    }
    //链表翻转普通
    public ListNode reverseList(ListNode head)
    {
        ListNode node = head;
        ListNode temp=null;
        while (node!=null){
            ListNode t=node.next;
            node.next=temp;
            temp=node;
            node=t;
        }
        return node;
    }
    //链表反转递归法
    public ListNode dreverseList(ListNode head)
     {
       if (head==null||head.next==null)return head;

       ListNode tail=dreverseList(head.next);
       head.next.next=head;
       head.next=null;
       return tail;
    }

    public ListNode findKthToTail(ListNode x, int k) {
        int count = 0;
        ListNode pListHead = x;
        while (pListHead != null) {
            pListHead = pListHead.next;
            count++;
        }
        pListHead = x;
        if (count > k)
            return null;

        else {
            for (int i = 0; i < count - k; i++) {
                pListHead = pListHead.next;

            }
            return pListHead;
        }


    }
}
