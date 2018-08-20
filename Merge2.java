package com.gemnwing.sort;
/**
 * 归并排序：二分递归，由下而上
 * @author gemnwing
 *
 */
public class Merge2 {
	private static Comparable[] aux;
	public void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 0;sz < N; sz+=sz){		//子数组大小
			for (int lo = 0; lo < N - sz; lo += sz+sz) {		//lo:子数组索引
				merge(a, lo, lo + sz - 1, Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	private void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
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
