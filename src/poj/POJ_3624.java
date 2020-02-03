package poj;

import java.util.Scanner;

/**
 * 动态规划的0-1背包问题
 * @author xxm
 *
 */
public class POJ_3624 {
	
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
		
		//制表（二维数组）V(i,j)......表示前i个商品中，背包为容量为j时的商品组合的最大价值
		int [][]v = new int[N+1][M+1];
		
		/****递推公式：************
		 * 	1.太大，放不下	Wi > M , v(i,j) = v(i-1,j); 
		 * 	2.可放，但要看价值      
		 *    Wi < M , v(i,j) = max(v(i-1,j),v(i-1,j- Wi)+Di )	
		 *     比较不放第i个时的最值a与放第i个时容量刚好为j时的最值b，取a与b的max
		 */
		
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=M;j++) {
				//1
				if(w[i] > j) {
					v[i][j] = v[i-1][j];
				}
				//2
				else {
					
					v[i][j] = v[i-1][j] > (v[i-1][j-w[i]]+d[i])? 
							v[i-1][j] : (v[i-1][j-w[i]]+d[i]);
				}
			}
		}
		
		System.out.println(v[N][M]);//要的最大值存于此
		
	}
}
