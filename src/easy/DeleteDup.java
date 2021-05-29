package easy;

public class DeleteDup {
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        		return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null) {
	        	while(curr!=null && curr.val==prev.val) {
	        		prev.next = curr.next;
	        		curr = prev.next;
	        	}
	        	if(curr==null)
	        		break;
	        	prev = curr;
	        	curr = curr.next;
        }
        return head;
    }

}
