package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import metalsheet.MetalSheet;

class MetalSheetTest {

	@Test
	public void shoulReturnMinCuttingCost1() {
		MetalSheet metalSheet = new MetalSheet(0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
		
		int minCost = metalSheet.minCuttingCost();
		
		assertEquals(minCost, 0);
	}

	@Test
	public void shoulReturnMinCuttingCost2() {
		MetalSheet metalSheet = new MetalSheet(1, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
		
		int minCost = metalSheet.minCuttingCost();
		
		assertEquals(minCost, 0);
	}
	
	@Test
	public void shoulReturnMinCuttingCost3() {
		ArrayList<Integer> xCosts = fillArray(3);
		ArrayList<Integer> yCosts = fillArray(6);
		MetalSheet metalSheet = new MetalSheet(2, 2, xCosts, yCosts);
		
		int minCost = metalSheet.minCuttingCost();
		
		assertEquals(minCost, 12);
	}
	
	@Test
	public void shoulReturnMinCuttingCost4() {
		ArrayList<Integer> xCosts = fillArray(2, 1, 3, 1, 4);
		ArrayList<Integer> yCosts = fillArray(4, 1, 2);
		MetalSheet metalSheet = new MetalSheet(6, 4, xCosts, yCosts);
		
		int minCost = metalSheet.minCuttingCost();
		
		assertEquals(minCost, 42);
	}
	
	private ArrayList<Integer> fillArray(int... costs) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int cost: costs) {
			values.add(cost);
		}
		
		return values;
	}
}
