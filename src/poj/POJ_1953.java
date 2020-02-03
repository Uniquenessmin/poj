package poj;

import java.util.ArrayList;
import java.util.Scanner;

public class POJ_1953 {

	public static void main(String[] args) {
		//存
		int anum[] = new int[45];
		anum[0]=2;
		anum[1]=3;
		for(int i=2;i<45;i++) {
			anum[i]=anum[i-1]+anum[i-2];
		}
		
		// TODO input
		Scanner in = new Scanner(System.in);
		int nums = in.nextInt();//方案个数
		int[] scenario = new int[nums];// 方案列表
		int i = 0;
		while (i < nums) {
			scenario[i]=in.nextInt();
			i++;
		}

		// solve problem
	
			for (int j = 0; j < scenario.length; j++) {
				System.out.println("Scenario #" + (j + 1) + ":");
				System.out.println(anum[scenario[j]-1]);
				System.out.println();
//
			}

	}


}
