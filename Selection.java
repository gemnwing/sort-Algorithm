package com.gemnwing.sort;
/**
 * 选择排序：每次选择剩余一个最小的，进行交换
 * 时间复杂度 :O(n^2)
 * @author gemnwing
 *
 */
public class Selection {
	public void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i; j < N; j++) {
				if(a[j].compareTo(a[min]) < 0){
					min = j;
				}
			}
			Comparable temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}
}
