package ga.workshop.com.LeetCode.prac20181019;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class XofAKindInADeckOfCards {
	
	public boolean hasGroupsSizeX(int[] deck) {
		if(deck.length <= 1)
			return false;
		List<Integer> counts = new LinkedList<>();
		int count =0;
        for(int i=0;i<deck.length;i++) {
        	count = 0;
        	if(deck[i] < 0)
        		continue;
        	int j = i+1;
        	while(j<deck.length) {
        		if(deck[i] == deck[j]) {
        			deck[j] = -1;
        			count += 1;
        		}
        		j++;
        	}
        	counts.add(count+1);
        }
        
        // 找最大公因數
        Collections.sort(counts);
        List<Integer> childs = new LinkedList<>();
        for(int j=2;j<=counts.get(0);j++)
    		if(counts.get(0) % j == 0)
    			childs.add(j);
        
        counts.remove(0);
        boolean hasCommon;
        for(Integer c : childs) {
        	hasCommon = true;
        	for(Integer i : counts) {
        		if(i % c != 0) {
        			hasCommon = false;
        			break;
        		}
            }
        	if(hasCommon)
        		return true;
        }
        return false;
    }
	/*
	public boolean hasGroupsSizeX(int[] deck) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<deck.length;i++) {
			if(!map.containsKey(deck[i]))
				map.put(deck[i], 1);
			else
				map.put(deck[i], map.get(deck[i])+1);
		}
		List<Integer> sizes = new LinkedList<>(map.values());
		Collections.sort(sizes);
		int maxCommon = sizes.get(0);
		for(Integer size : map.values()) {
			
		}
    }
    */
	
	public static void main(String[] args) {
		XofAKindInADeckOfCards m = new XofAKindInADeckOfCards();
//		System.out.println(m.maxSubArray(new int[] {-2,-1,-2}));
//		System.out.println(m.hasGroupsSizeX(new int[] {1,1,1,2,2,2,3,3}));
		System.out.println(m.hasGroupsSizeX(new int[] {1,1,1,1,2,2,2,2,2,2}));
//		System.out.println(m.maxSubArray(new int[] {-1,-2}));
//		System.out.println(m.maxSubArray(new int[] {0,-3,1,1}));
//		System.out.println(m.maxSubArray(new int[] {-2,-3,-1}));
//		System.out.println(m.maxSubArray(new int[] {0,-3,-2,-3,-2,2,-3,0,1,-1}));
	}
}
