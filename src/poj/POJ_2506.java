package poj;

import java.math.BigDecimal;
import java.util.Scanner;

public class POJ_2506 {
	public static void main(String[] args) {
		/**第一、
		 * 把2*n拆分成
		 * 2*(n-1) vs 2*1的组合
		 * 与
		 * 2*(n-2) vs 2*2的组合
		 */
		/**
		 * 第二、怎么存储这么大的数值？ 
		 * 
		 */
		
		//先存储
		BigDecimal[] n = new BigDecimal[251];
		n[0]=BigDecimal.ONE;
		n[1]=BigDecimal.ONE;
		BigDecimal b = BigDecimal.valueOf(2);
		
		for(int i = 2; i<n.length;i++) {
			n[i]=n[i-1].add(n[i-2].multiply(b)) ;
			//System.out.println(i+" --- "+n[i]);
		}
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int k = scanner.nextInt();
			while(k<0||k>250) {
				System.out.println("input again:");
				k = scanner.nextInt();
			}
			System.out.println(n[k]);
		}

	}
}
