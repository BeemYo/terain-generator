package terrainGenerator;

import java.util.Random;

public class Generator {

	public static void main(String[] args) {
		
		float[][] terrain = new float[10][10];
		//print the generated terrain
		
		double seed = 0.5;
		                                         
		Random rand = new Random();
		
		for (int row = 0; row < terrain.length; row++) {
			for (int col = 0; col < terrain[row].length; col++) {
				if (row == 0 && col == 0) {
					terrain[row][col] = rand.nextFloat();
				} 
				else if (row == 0) {
					float mut = (float) (rand.nextFloat() / seed - 0.5 / seed);
					terrain[row][col] = terrain[row][col - 1] - mut;
				}
				else if (col == 0) {
					float mut = (float) (rand.nextFloat() / seed - 0.5 / seed);
					terrain[row][col] = terrain[row - 1][col] - mut;
				}
				else {
					float mut = (float) (rand.nextFloat() / seed - 0.5 / seed);
					float ar = (terrain[row - 1][col] + terrain[row][col - 1]) / 2;
					terrain[row][col] = ar - mut;
				}
			}
		}
		PrintTerrain(terrain);
	}
	static void PrintTerrain(float[][] terrain) {
		for (float[] i : terrain) {
			for (float j : i) {
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
