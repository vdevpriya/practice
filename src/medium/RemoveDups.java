package medium;

public class RemoveDups {
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        ListNode lastUniqNode = null;
        //boolean dup = false;
        while(ptr!=null && ptr.next!=null) {
        		while(ptr.next!=null && ptr.val==ptr.next.val) {
        			ptr = ptr.next;
        			//dup = true;
        		}
        		if(lastUniqNode==null) {
        			if(head!=ptr) {
        				head = ptr.next;
        			} else {
        				lastUniqNode = ptr;
        			}
        		} else {
        			if(lastUniqNode.next!=ptr) {
        				lastUniqNode.next = ptr.next;
        			} else {
        				lastUniqNode = ptr;
        			}
        		}
        		ptr = ptr.next;
        		//dup = false;
        }
//        if(lastUniqNode!=null && lastUniqNode.next!=ptr) {
//        		lastUniqNode.next = dup ? ptr.next : ptr;
//        }
        return head;
    }

}
