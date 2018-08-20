package com.gemnwing.sort;
/**
 * 归并排序：二分递归，由上而下
 * @author gemnwing
 *
 */
public class Merge1 {
	private static Comparable[] aux;
	public void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	private void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (lo + hi)/2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
		
	}
	private void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = 0; k < hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if(i > mid)                           a[k] = aux[j++];//左边用尽
			else if(j > hi)                       a[k] = aux[i++];//右边用尽
			else if(aux[i].compareTo(aux[j]) < 0) a[k] = aux[i++];//左边小于右边，将左边存储
			else                                  a[k] = aux[j++];//否则
		}
		
	}
}
