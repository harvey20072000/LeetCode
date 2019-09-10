package ga.workshop.com.LeetCode.prac20181017;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int init = nums.length,count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				for(int j=i,k=j+1;j<nums.length;j++,k++)
					if(j == nums.length-1)
						nums[j] = -1;
					else
						nums[j] = nums[k];
				count++;
				i--;
			}
		}
        return init - count;
    }
	
	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		System.out.println(r.removeElement(new int[] {3,2,2,3},3));
	}
}
