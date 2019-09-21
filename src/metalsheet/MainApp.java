package metalsheet;

import java.util.ArrayList;

public class MainApp {

	private static final String INFO_VALUE_FOR_DIM_M = "Enter a value for the m-dimension:";
	private static final String INFO_VALUE_FOR_DIM_N = "Enter a value for the n-dimension:";
	private static final String INFO_CUTTING_COSTS_FOR_M = "Specify cutting costs for the m-dimension (x1,...,x(m-1)):";
	private static final String INFO_CUTTING_COSTS_FOR_N = "Specify cutting costs for the n-dimension (y1,...,y(n-1)):";
	private static final String INFO_MIN_COST_OF_CUTTING = "The minimum cost of cutting metal sheet is: ";

	public static void main(String[] args){
		ScannerHelper scanner = new ScannerHelper();
		
		System.out.println(INFO_VALUE_FOR_DIM_M);
		int dimM = scanner.getNextInt();
		System.out.println(INFO_VALUE_FOR_DIM_N);
		int dimN = scanner.getNextInt();
		
		ArrayList<Integer> xCosts = fillCuttingCosts(dimM, scanner, INFO_CUTTING_COSTS_FOR_M);
		ArrayList<Integer> yCosts = fillCuttingCosts(dimN, scanner, INFO_CUTTING_COSTS_FOR_N);
		
		scanner.closeSession();
		
		MetalSheet metalSheet = new MetalSheet(dimM, dimN, xCosts, yCosts);
		int minCost = metalSheet.minCuttingCost();
		System.out.println(INFO_MIN_COST_OF_CUTTING + minCost);
	}
	
	private static ArrayList<Integer> fillCuttingCosts(int dim, ScannerHelper scanner, String info) {
		ArrayList<Integer> costs = new ArrayList<>();
		if (dim > 1) {
			System.out.println(info);
			for (int i = 1; i < dim; i++) {
				System.out.println(i + ": ");
				costs.add(scanner.getNextInt());
			}
		}

		return costs;
	}
	
}
