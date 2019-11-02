/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

/**
 *
 * @author hieund3
 */
public class GasStation {

	static GasStation INSTANCE = new GasStation();

	public static void main(String[] args) {
		int[] gas = {13, 2, 3, 4, 2};
		int[] cost = {0, 4, 5, 0, 15};
		int indexGas = INSTANCE.canCompleteCircuit(gas, cost);
		System.out.println("indexGas: " + indexGas);
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sumGas = 0;
		int sumCost = 0;
		for (int i = 0; i < cost.length; i++) {
			sumCost += cost[i];
			sumGas += gas[i];
		}
		if (sumCost > sumGas) {
			return -1;
		}
		int indexGas = -1;
		int tmpGas = 0;
		int tmpCost = 0;
		for (int i = 0; i < cost.length; i++) {
			tmpGas += gas[i];
			tmpCost += cost[i];
			if (tmpGas >= tmpCost) {
				if (indexGas == -1) {
					indexGas = i;
				}
			} else {
				tmpGas = 0;
				tmpCost = 0;
				indexGas = -1;
			}
		}
		return indexGas;
	}
}
