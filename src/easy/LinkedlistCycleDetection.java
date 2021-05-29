package easy;

public class LinkedlistCycleDetection {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(-4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n2.next = n2;
		LinkedlistCycleDetection l= new LinkedlistCycleDetection();
		System.out.println(l.detectCycle(n1).val);
		
	}
	
	public ListNode detectCycle(ListNode head) {
		 if(head==null || head.next==null) {
			 return null;
		 }
		 ListNode ptr = head;
		 ListNode ptr2 = head;
	     while(ptr2!=null && ptr2.next!=null) {
	    	 	ptr = ptr.next;
	    	 	ptr2 = ptr2.next.next;
	    	 	if(ptr2==null)
	    	 		return null;
	    	 	if(ptr==ptr2) {
	    	 		ptr = head;
	    	 		int i = 0;
	    	 		while(ptr!=ptr2) {
	    	 			ptr = ptr.next;
	    	 			ptr2 = ptr2.next;
	    	 			i++;
	    	 		}
	    	 		System.out.println("tail connects to node index "+i);
	    	 		return ptr;
	    	 	}
	    }
	     return null;
    }

	 public boolean hasCycle(ListNode head) {
		 if(head==null || head.next==null) {
			 return false;
		 }
		 ListNode ptr = head;
		 ListNode ptr2 = head;
	     while(ptr2!=null && ptr2.next!=null) {
	    	 	ptr = ptr.next;
	    	 	ptr2 = ptr2.next.next;
                if(ptr2==null)
	    	 		return false;
	    	 	if(ptr==ptr2)
	    	 		return true;
	     }
	     return false;
	 }
}


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
	}}