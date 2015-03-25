package com.leetcode.arraryList_2;

public class ClimbingStairs {
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top. Each
	 * time you can either climb 1 or 2 steps. In how many distinct ways can you
	 * climb to the top?
	 */

	/**
	 * Cuause you can only take one or two step, so wo can simplify the problem,
	 * if you want to get to Nth stair, you can only (go to N-1th stait and take
	 * one more step)+(go to N-2th stair and take two more steps) so here it is
	 * f(n)=f(n-1)*1+f(n-2)*1
	 */

	/**
	 * Too wasting time
	 */
	 private static long climbStair(long n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStair(n - 1) + climbStair(n - 2);
	}

	/**
	 * quickly
	 */
	static private long climbStair_method2(Long n) {
		long tmp1 = 1;
		long tmp2 = 2;
		long tmp = 0;
		while (n-2 > 0) {
			tmp = tmp1 + tmp2;
			tmp1 = tmp2;
			tmp2 = tmp;
			n--;
		}
		return tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long step = 61;
//		System.out.println(climbStair(step));  //time out
		System.out.println(climbStair_method2(step));
	}

}
