package com.gemnwing.sort;
/**
 * 希尔排序：按照等差序列分组排序，然后随着递减等差序列，直至为1分组排序。
 * @author gemnwing
 *
 */
public class Shell {
	public void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while(h < N/3) h = h*3 + 1;
		while(h >= 1){
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j-=h) {
					if(a[j].compareTo(a[j-h]) < 0){
						Comparable temp = a[j];
						a[j] = a[j-h];
						a[j-h] = temp;
					}
				}
			}
			h /= 3;
		}
	}
}
