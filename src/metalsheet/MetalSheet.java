package metalsheet;

import java.util.ArrayList;
import java.util.Collections;

public class MetalSheet {

	private int dimM;
	private int dimN;
	private ArrayList<Integer> xCosts;
	private ArrayList<Integer> yCosts;

	public MetalSheet(int dimM, int dimN, ArrayList<Integer> xCosts, ArrayList<Integer> yCosts) {
		this.dimM = dimM;
		this.dimN = dimN;
		this.xCosts = xCosts;
		this.yCosts = yCosts;
		
		this.xCosts.sort(Collections.reverseOrder());
		this.yCosts.sort(Collections.reverseOrder());
	}

	public int minCuttingCost() {
		int tempDimM = this.dimM - 1;
		int tempDimN = this.dimN - 1;
		
		int totalCost = 0;	
		int stepX = 0;
		int stepY = 0;
		int amountOfCuttingM = 1;
		int amountOfCuttingN = 1;
		boolean end = false;
		
		while (end == false) {
			if (stepX < tempDimM && stepY == tempDimN) {
				totalCost += this.xCosts.get(stepX) * amountOfCuttingN;
				stepX++;
			}
			else if (stepY < tempDimN && stepX == tempDimM) {
				totalCost += this.yCosts.get(stepY) * amountOfCuttingM;
				stepY++;
			}
			else if (stepX < tempDimM && stepY < tempDimN) {
				if (this.xCosts.get(stepX) > this.yCosts.get(stepY)) {
					totalCost += this.xCosts.get(stepX) * amountOfCuttingN;
					stepX++;
					amountOfCuttingM++;
				} 
				else {
					totalCost += this.yCosts.get(stepY) * amountOfCuttingM;
					stepY++;
					amountOfCuttingN++;
				}
			}
			else {
				end = true;
			}
		}
	
		return totalCost;
	}

}
