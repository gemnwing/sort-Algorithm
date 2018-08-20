package com.gemnwing.sort;
/**
 * 插入排序:从后往前开始，比较是否比前面一个小，如果是，则前面的一个后移一位，继续比较，直至比前面一个大，插入
 * 时间复杂度：O（N^2）
 * @author gemnwing
 *
 */
public class Insertion {
	public void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			Comparable temp = a[i];
			for (int j = i; j > 0; j--) {
				if(temp.compareTo(a[j-1]) < 0){
					a[j] = a[j-1];
				}else{
					a[j-1] = temp;
					break;
				}
			}
		}
	}
}
