package datastructures;

public class mergeSortedLists {

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
		// lists = [[1,4,5],[1,3,4],[2,6]]
//		mergeSortedLists x = new mergeSortedLists();
//		// TODO Auto-generated method stub
//		mergeSortedLists.ListNode[] lists = new mergeSortedLists.ListNode[3];
//		lists[0] = x.new ListNode(1);
//		lists[0].next = x.new ListNode(4);
//		lists[0].next.next = x.new ListNode(5);
//
//		lists[1] = x.new ListNode(1);
//		lists[1].next = x.new ListNode(3);
//		lists[1].next.next = x.new ListNode(4);
//
//		lists[2] = x.new ListNode(2);
//		lists[2].next = x.new ListNode(6);
//		ListNode l = x.mergeKLists(lists);
//		while (l != null) {
//			System.out.print(l.val);
//			System.out.print("->");
//			l = l.next;
//		}
		int a[] = {};
		System.out.println(a);

	}
	// public ListNode mergeKLists(ListNode[] lists) {
	// PriorityQueue<ListNode> pq = new PriorityQueue<>(new
	// Comparator<ListNode>() {
	//
	// @Override
	// public int compare(ListNode o1, ListNode o2) {
	// // TODO Auto-generated method stub
	// return o1.val-o2.val;
	// }
	//
	// });
	//
	// ListNode p;
	// for(int i=0;i<lists.length;i++) {
	// p = lists[i];
	// while(p.next!=null) {
	// pq.add(p);
	// }
	// }
	// ListNode head = null,ptr = null;
	// while(!pq.isEmpty()) {
	// if(head == null) {
	// head = pq.poll();
	// ptr = head;
	// } else {
	// ptr.next = pq.poll();
	// }
	// }
	// return head;
	// }

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		ListNode ptr = null;
		int i = 0;
		for (; i < lists.length; i++) {
			if (lists[i] != null) {
				ptr = lists[i];
				break;
			}
		}
		if (i >= lists.length)
			return null;
		else
			i++;
		ListNode prev = null;
		ListNode minNode = null;
		ListNode l = null;
		int minNodeIdx = -1;
		while (true) {
			minNode = null;
			for (int j=i;j< lists.length; j++) {
				l = lists[j];
				if (l != null) {
					if (minNode == null || (minNode != null && l.val < minNode.val)) {
						minNodeIdx = j;
						minNode = l;
					}
				}
			}
			if (minNode == null)
				break;
			if (ptr != null && ptr.val <= minNode.val) {
				prev = ptr;
				ptr = ptr.next;
			} else {
				lists[minNodeIdx] = lists[minNodeIdx].next;
				if (prev == null) {
					prev = minNode;
					lists[i-1] = prev;
				} else {
					prev.next = minNode;
				}
				minNode.next = ptr;
				prev = minNode;
			}
		}
		for (int k=0;k < lists.length; k++) {
			if (lists[k] != null)
				return lists[k];
		}
		return null;
	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode() {} ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
	 */

}
