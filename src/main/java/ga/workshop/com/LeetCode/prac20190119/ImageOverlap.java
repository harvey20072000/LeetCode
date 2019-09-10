package ga.workshop.com.LeetCode.prac20190119;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ImageOverlap {

	public int largestOverlap(int[][] A, int[][] B) {
        Map<Position,Object> bPattern = new HashMap<>();
        for(int i=0;i<B.length;i++) {
        	for(int j=0;j<B[i].length;j++) {
        		if(B[i][j] == 1) {
        			bPattern.put(new Position(j, i),B[i][j]);
        		}
        	}
        }
        Map<Position,Object> aPos = new HashMap<>();
        int diff = A.length-1,extHeight = A.length+diff*2,extWidth = A[0].length+diff*2;
        for(int i=0;i<extHeight;i++) {
        	for(int j=0;j<extWidth;j++) {
        		if(i < diff || i >= A.length+diff || j < diff || j >= A[0].length+diff) {
        			aPos.put(new Position(j, i),0);
        		}else {
        			aPos.put(new Position(j, i),A[i-diff][j-diff]);
        		}
        	}
        }
        int result = 0,tmpResult = 0;
        for(Entry<Position, Object> entry : aPos.entrySet()) {
        	tmpResult = 0;
        	for(Entry<Position, Object> pattern : bPattern.entrySet()) {
        		Object ret = aPos.get(pattern.getKey().clone().resetOrigin(entry.getKey())); 
        		if(ret != null && ret.equals(pattern.getValue()))
            		tmpResult++;
        	}
        	if(tmpResult > result)
        		result = tmpResult;
        }
        return result;
    }
	
	public static void main(String[] args) {
		ImageOverlap t = new ImageOverlap();
		System.out.println(t.largestOverlap(new int[][] {{1,1,0},{0,1,0},{0,1,0}},new int[][] {{0,0,0},{0,1,1},{0,0,1}}));
		System.out.println(t.largestOverlap(new int[][] {{1,0},{0,0}},new int[][] {{0,1},{1,0}}));
	}

}

class Position{
	private int x;
	private int y;
	
	public Position() {}
	
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	Position resetOrigin(Position origin) {
		this.x = origin.x + this.x;
		this.y = origin.y + this.y;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public Position clone() {
		try {
			return new Position(this.x, this.y);
		} catch (Exception e) {}
		return null;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
