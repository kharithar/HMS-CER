import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class ShortestPath {
	
	private static final int M = 10;
	
	private static final int N = 10;
	
	private static final int row[] = {-1,0,0,1};
	
	private static final int col[] = {0,-1,1,0};
	
	private static boolean isValid(int[][] mat, boolean[][] visited, int newRow, int newCol) {
		return (newRow>=0) && (newRow<M) && (newCol>=0) && (newCol<N) && !visited[newRow][newCol] 
				&& mat[newRow][newCol]==1;
	}
	
	private static void BFS(int[][] mat, int i, int j, int x, int y) {
		
		boolean[][] visited = new boolean[10][10];
		
		Queue<Node1> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.add(new Node1(i,j,0));
		int min_dist = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Node1 temp = queue.poll();
			i = temp.x;
			j = temp.y;
			int dist = temp.distance;
			
			if((i==x) && (j==y)) {
				min_dist = dist;
				break;
			}
			
			for(int k=0;k<4;k++) {
				if(isValid(mat,visited,i+row[k],j+col[k])) {
					//set visited as true;
					visited[i+row[k]][j+col[k]] = true;
					queue.add(new Node1(i+row[k],j+col[k],dist+1));
					//increase dist by 1
				}
			}
		}
		
		if(min_dist != Integer.MAX_VALUE) {
			System.out.println(min_dist);
		}
	}
	
	public static void main(String[] args)
	{
		// input maze
		int[][] mat =
		{
			{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
			{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
			{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
		};

		// Find shortest path from source (0, 0) to
		// destination (7, 5)
		BFS(mat, 0, 0, 7, 5);
	}

}


class Node1 {
	int x,y,distance;
	
	public Node1(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}
