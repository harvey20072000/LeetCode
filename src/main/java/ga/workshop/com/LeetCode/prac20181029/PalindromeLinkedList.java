package ga.workshop.com.LeetCode.prac20181029;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
        	list.add(head.val);
        	head = head.next;
        }
        for(int i=list.size()-1;i>=list.size()/2;i--) {
        	if(!list.get(i).equals(list.get(list.size()-1-i)))
        		return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		PalindromeLinkedList m = new PalindromeLinkedList();
		System.out.println(m.isPalindrome(parseToListNode(new int[] {-129,-129})));
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
