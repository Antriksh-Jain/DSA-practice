import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[n][m];

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		int count = 0;
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 0 && visited[i][j] == false) {
					drawTreeForComponent(arr, i, j, visited);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	public static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited) {
	    if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j]){
	        return;
	    }
	    
		visited[i][j] = true;
		drawTreeForComponent(arr, i - 1, j, visited);
		drawTreeForComponent(arr, i, j + 1, visited);
		drawTreeForComponent(arr, i + 1, j, visited);
        drawTreeForComponent(arr, i, j - 1, visited);
	}
}
