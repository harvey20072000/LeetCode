package ga.workshop.com.LeetCode.prac20181017;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode finalResult = null,result = null,resultNext = null;
        while(l1 != null || l2 != null) {
        	if(l1 != null && l2 == null) {
        		resultNext = new ListNode(l1.val);
        		l1 = l1.next;
        	}else if (l1 == null && l2 != null) {
        		resultNext = new ListNode(l2.val);
        		l2 = l2.next;
			}else if(l1.val <= l2.val) {
        		resultNext = new ListNode(l1.val);
        		l1 = l1.next;
        	}else {
        		resultNext = new ListNode(l2.val);
        		l2 = l2.next;
        	}
        	
        	if(finalResult == null)
        		finalResult = resultNext;
        	else if(finalResult.next == null)
        		finalResult.next = result = resultNext;
        	else {
        		result.next = resultNext;
        		result = resultNext;
        	}
        }
        return finalResult;
    }
	
	public static void main(String[] args) {
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		ListNode node = m.mergeTwoLists(parseToListNode(new int[] {1,2,4}),parseToListNode(new int[] {1,3,4}));
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

	ListNode(int x) {
		val = x;
	}
}
