package ga.workshop.com.LeetCode.prac20181022;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		ListNode result = new ListNode(head.val),resultNext = null,next = head.next;
		Set<Integer> numSet = new HashSet<>();
		numSet.add(head.val);
        while(next != null) {
        	if(!numSet.contains(next.val)) {
        		if(result.next == null)
        			result.next = resultNext = new ListNode(next.val);
        		else {
        			resultNext.next = new ListNode(next.val);
        			resultNext = resultNext.next;
        		}
        		numSet.add(next.val);
        	}
        	next = next.next;
        }
        return result;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList a = new RemoveDuplicatesFromSortedList();
		ListNode node = a.deleteDuplicates(parseToListNode(new int[] {1,1,2,4}));
		StringBuilder sb = new StringBuilder("");
		while(node != null) {
			sb.append("->"+node.val);
			node = node.next;
		}
		System.out.println(sb.toString().replaceFirst("->", ""));
	}
	
	private static ListNode parseToListNode(int[] a) {
		ListNode finalNode = null,node = null,tmp = null;
		for(Integer i : a) {
			tmp = new ListNode(i);
			if(finalNode == null)
				finalNode = tmp;
			else if (finalNode.next == null) {
				finalNode.next = node = tmp;
			}else {
				node.next = tmp;
				node = tmp;
			}
		}
		return finalNode;
	}
}


class ListNode {
	 	int val;
	 	ListNode next;
	 	ListNode(int x) { val = x; }
}