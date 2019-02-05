import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap {
	
	private int[] list;
	private int capacity;
	private int heap_size;
	
	public MinHeap(int capacity) {
		this.heap_size = 0;
		this.capacity = capacity;
		this.list = new int[capacity+1];
	}
	//insert
	public void insert(int item) {
		if(heap_size == capacity) {
			System.out.println("Overflow");
		}
		heap_size++;
		int current = heap_size -1;
		list[current] = item;

		while(current != 0 && list[parent(current)]>list[current]) {
			swap(list[current], list[parent(current)]);
			current = parent(current);
			//parent = parent(parent);
		}
	}
	
	private void swap (int current, int parent) {
		int temp = parent;
		parent = current;
		current = temp;
	}
	
	private int parent(int i) {

		return (i-1)/2;
	}
	
	public void getMin() {
		System.out.println(Arrays.toString(list));
	}
	
	public static void main(String[] args) {

		MinHeap minHeap = new MinHeap(4);
		minHeap.insert(5);
		//minHeap.insert(10);
		minHeap.insert(2);
		minHeap.insert(3);
		minHeap.insert(6);
		
		minHeap.getMin();
		
	}

}
