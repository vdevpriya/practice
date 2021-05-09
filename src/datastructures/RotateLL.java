package datastructures;

public class RotateLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) {
        		return head;
        }
        int l = 1;
        ListNode ptr = head;
        while(ptr.next!=null) {
        		ptr = ptr.next;
        		l++;
        }
        ListNode tail = ptr;
        if(l%k==0)
        		return head;
        
        int i=1;
        ptr = head;
        while(i<k) {
        		ptr = ptr.next;
        		i++;
        }
        ptr.next = null;
        tail.next = head;
        head = ptr;
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
