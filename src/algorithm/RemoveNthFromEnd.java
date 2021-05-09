package algorithm;

public class RemoveNthFromEnd {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0)
        		return head;
        
        ListNode p1=head ,p2 = null;
        int i = 0;
        while(p1.next!=null)
        {
        		p1 = p1.next;
        		if(p2!=null)
        		{
        			p2 = p2.next;
        		}
        		i++;
        		if(i==n)
        		{
        			p2 = head;
        		}
        }
        if(p2!=null)
        {
        		p2.next = p2.next.next;
        		return head;
        } else if(p2==null && i==n-1){
        		return head.next;
        }
        
        return null;
   }

}


class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

