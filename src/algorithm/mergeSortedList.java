package algorithm;

public class mergeSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode m, mhead, temp = null;
		if (p1.val <= p2.val) {
			mhead = m = p1;
			p1 = p1.next;
		} else {
			mhead = m = p2;
			p2 = p2.next;
		}
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				temp = p1;
				p1 = p1.next;
				m.next = temp;
			} else {
				temp = p2;
				p2 = p2.next;
				m.next = temp;
			}
			m = m.next;
		}
		if (p1 == null && p2 != null) {
			m.next = p2;
		} else if (p2 == null && p1 != null) {
			m.next = p1;
		}
		return mhead;

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
