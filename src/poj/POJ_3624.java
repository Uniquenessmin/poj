package poj;

import java.util.Scanner;

/**
 * 动态规划的0-1背包问题
 * @author xxm
 *
 */
public class POJ_3624 {
	/**
	 * 遇到的问题：用二维数组存储物品组合最大价值时，空间复杂度太大了？不符合题目要求
	 * 解决方法： 用一维数组存储价值（因为第i个物品价值总和只与第i-1个物品时的价值总和有关）
	 * 			且用“人人为我”递推型动归实现。
	 * @param args
	 */
	public static void main(String[] args) {
		//input
		Scanner sc = new Scanner(System.in);
		//line 1: N物品数量		M背包容量
		final int N = sc.nextInt();
		final int M = sc.nextInt();
		//line 2...N+行 输入，两个数组分别存储物品价值Di与容量Wi
		int[] d = new int[N+1];
		int w[] = new int[N+1];
		
		int k = 1;
		while (k<=N) {
			w[k] = sc.nextInt();
			d[k] = sc.nextInt();
			k++;
			
			
		}
		
		
		int v[] = new int[M+1];//一维数组代替二维
		
		/****记忆递推公式：************
		 * 	1.太大，放不下	Wi > M , v(i,j) = v(i-1,j); 
		 * 	2.可放，但要看价值      
		 *    Wi < M , v(i,j) = max(v(i-1,j),v(i-1,j- Wi)+Di )	
		 *     比较不放第i个时的最值a与放第i个时容量刚好为j时的最值b，取a与b的max
		 */
		
		for(int i = 0 ;i<=M; i++) {
			//给一维数组v赋初值
			if(w[1]<=i) {
				v[i] = d[1];
			}else {
				v[i]=0;
			}
		}
		
		//从第二个物品开始，逆序比较
		for (int i = 2; i <= N; i++) {
			for (int j = M; j >= w[i]; j--) {
				v[j]=Math.max(v[j], v[ j-w[i] ] + d[i]);
			}
		}
		
		System.out.println(v[M]);//要的最大值存于此
		
	}
}
