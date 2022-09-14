package hw7;

import java.util.Iterator;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.BreadthFirstPaths;

public class Solver {
	public static String solve(char[][] grid) {
		// TODO
		/*
		 * 1. Construct a graph using grid
		 * 2. Use BFS to find shortest path from start to finish
		 * 3. Return the sequence of moves to get from start to finish
		 */
		
		int vert = grid.length * grid[0].length;
		Graph g = new Graph(vert);
		int sint = -1;
		int fint = -1;
		String fin = "";
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[row].length; col++) {
				int gpos = (row*grid.length)+col;

				if(col+1 != grid[row].length && (grid[row][col+1] == ' ' || grid[row][col+1] == 's' || grid[row][col+1] == 'f')) { //check below
					g.addEdge(gpos,gpos+1);
					}
				if(row+1 != grid.length && (grid[row+1][col] == ' ' || grid[row+1][col] == 's' || grid[row+1][col] == 'f')) { //check right
					g.addEdge(gpos, gpos+grid.length);
				}
				
				if(grid[row][col] == 's') {
					sint = gpos;
				}
				if(grid[row][col] == 'f') {
					fint = gpos;
				}
			}
		}
		
		BreadthFirstPaths bfp = new BreadthFirstPaths(g, sint);
		String path = "";
		if(bfp.hasPathTo(fint)) {
			path = bfp.pathTo(fint).toString();
		}
		else {
			return null;
		}

		
		String[] p = path.split(" ");
		int[] pathar = new int[p.length];
		for(int n = 0; n < p.length; n++) {
			pathar[n] = Integer.parseInt(p[n]);
		}
		
		for(int x = 1; x < pathar.length; x++) {
			if(pathar[x-1] + grid.length == pathar[x]) {
				fin += "D";
			}
			else if(pathar[x-1] + 1 == pathar[x]) {
				fin += "R";
			}
			else if(pathar[x-1] - grid.length == pathar[x]) {
				fin += "U";
			}
			else if(pathar[x-1] - 1 == pathar[x]) {
				fin += "L";
			}
		}
		
		// Hardcoded solution to toyTest
		return fin;
	}
}
