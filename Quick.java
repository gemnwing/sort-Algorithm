package com.gemnwing.sort;
/**
 * 快速排序:每次选取第一个元素，剩下的，左边没有比它大元素，右边没有比它小的元素。直至中间，将它放置中间位置。
 * @author gemnwing
 *
 */
public class Quick {
	public void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j+1, hi);
		
	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		Comparable v = a[lo];
		while(true){
			while(a[++i].compareTo(v) < 0) if(i == hi) break;
			while(v.compareTo(a[--j]) < 0) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
}
