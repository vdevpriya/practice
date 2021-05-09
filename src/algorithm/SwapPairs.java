package algorithm;

public class SwapPairs {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapPairs x = new SwapPairs();
		ListNode list = x.new ListNode(1);
		list.next = x.new ListNode(2);
		list.next.next = x.new ListNode(3);
		list.next.next.next = x.new ListNode(4);
		list.next.next.next.next = x.new ListNode(5);
		list.next.next.next.next.next = x.new ListNode(6);
		list.next.next.next.next.next.next = x.new ListNode(7);
		// ListNode l = x.swapPairs(list);
		x.printLL(list);
		ListNode l = x.swapkPairs(list, 2);
		x.printLL(l);
	}

	private void printLL(ListNode l) {
		while (l != null) {
			System.out.print(l.val);
			if (l.next != null) {
				System.out.print("->");
			}
			l = l.next;
		}
		System.out.println("");
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode temp = head.next;
			head.next = swapPairs(temp.next);
			temp.next = head;
			return temp;
		}
	}

	public ListNode swapkPairs(ListNode head, int k) {
		int len = getListLength(head);
		int cycles = len / k;
		ListNode prevStart = null;
		ListNode start = head;
		ListNode ptr = start;
		ListNode temp, newHead = head;
		for (int i = 0; i < cycles; i++) {
			int j = k - 1;
			while (j > 0) {
				temp = ptr.next;
				ptr.next = ptr.next.next;
				if (prevStart != null) {
					prevStart.next = temp;
				}
				temp.next = start;
				start = temp;
				j--;
			}
			if (i == 0) {
				newHead = start;
			}
			prevStart = ptr;
			ptr = ptr.next;
			start = ptr;
		}
		return newHead;
	}

	private int getListLength(ListNode head) {
		if (head != null) {
			int len = 0;
			ListNode ptr = head;
			while (ptr != null) {
				len++;
				ptr = ptr.next;
			}
			return len;
		}
		return 0;
	}

}
