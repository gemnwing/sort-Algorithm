package com.gemnwing.sort;

import java.nio.channels.Pipe.SinkChannel;
import java.util.concurrent.Exchanger;

/**
 * 插入排序:从后往前开始，比较是否比前面一个小，如果是，则前面的一个后移一位，继续比较，直至比前面一个大，插入
 * 时间复杂度：O（N^2）
 * @author gemnwing
 *
 */
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	public MaxPQ(int MaxN){
		pq = (Key[]) new Comparable[MaxN+1];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void insert(Key v){
		pq[++N] = v;
		swim(N);
	}

	private void swim(int k) {
		while(k > 1 && less(k/2, k)){
			exch(k/2,k);
			k/=2;
		}
	}
	
	public Key delMax(){
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}

	private void sink(int i) {
		while(2*i <= N){
			int j = 2*i;
			if(j < N && less(j, j+1)) j++;
			if(!less(i, j)) break;
			exch(i, j);
			i = j;
		}
		
	}

	private void exch(int i, int k) {
		Key t = pq[i]; 
		pq[i] = pq[k]; 
		pq[k] = t;
	}

	private boolean less(int i, int k) {
		return pq[i].compareTo(pq[k]) < 0;
	}
	
	
}
