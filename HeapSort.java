package com.gemnwing.sort;

/**
 * 堆排序：先生成堆结构，且堆有序，即堆中父节点比他的所有子节点大。再用下沉排序，将根元素，即最大的元素与最后一个元素交换位置，再讲第一个元素进行下降。
 * @author gemnwing
 *
 */
public class HeapSort {
	
	public void sort(Comparable[] a){
		int N = a.length;
		for(int k = N/2; k >= 1; k--){
			sink(a,k,N);
		}
		while(N > 1){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	private void exch(Comparable[] a, int i, int k) {
		Comparable t = a[i]; 
		a[i] = a[k]; 
		a[k] = t;
		
	}
	//下沉
	private void sink(Comparable[] a, int i, int N) {
		while(2*i <= N){
			int j = 2*i;
			if(j < N && less(a, j, j+1)) j++;
			if(!less(a, i, j)) break;
			exch(a, i, j);
			i = j;
		}
	}
	

	private boolean less(Comparable[] a, int i, int k) {
		return a[i].compareTo(a[k]) < 0;
	}
	
	
}
