package ga.workshop.com.LeetCode.prac20181029;

public class SurfaceAreaOf3DShapes {
	public int surfaceArea(int[][] grid) {
		int result = 0;
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[i].length;j++) {
        		if(grid[i][j] == 0)
        			continue;
        		result += grid[i][j]*4+2;
        		if(i-1 >= 0)
        			result -= Math.min(grid[i-1][j],grid[i][j])*2;
        		if(j-1 >= 0)
        			result -= Math.min(grid[i][j-1],grid[i][j])*2;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		SurfaceAreaOf3DShapes s = new SurfaceAreaOf3DShapes();
		System.out.println(s.surfaceArea(new int[][] {{2,2,2},{2,1,2},{2,2,2}}));
		
	}
}
