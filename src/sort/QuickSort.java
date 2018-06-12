package sort;

/**
 *快速排序(源址排序)
 * 
 * @author Administrator
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		//int num[] = {7,6,5,10,4,4,3,2,1 };
		int[] num = {38,65,97,76,13,27,49};
		System.out.println("初始数组:==============================");
		for (int n : num) {
			System.out.print(n + " ");
		}
		System.out.println();
		new QuickSort().sort(num, 0, num.length-1);//
		System.out.println("快速排序的结果:=========================");
		for (int n : num) {
			System.out.print(n + " ");
		}

//		int num1[] = {7,8,5,9,4,12,2,6 }; //System.out.println("length: " + num1.length);
//		//for Ken quick sort
//		new QuickSort().sortKen(num1, 0, num1.length-1);
//		System.out.println("ken quick sort 的结果为: ================");
//		for (int n : num1) {
//			System.out.print(n + " ");
//		}

	}

	public static void sort(int num[], int left, int right) {
		if (left < right) {
			int index = partition(num, left, right);//基准元素的下标, 数组的划分调用
			sort(num, left, index-1);
			sort(num, index, right);
		}

	}

	public static  int partition(int[] num, int left, int right) {
		if(num==null || num.length<=0 || left<0 || right>=num.length){
			return 0;
		}
		int prio = num[left + (right - left) / 2]; //基准元素, 中间位置, 可以是第一个或者最后一个
		while(left<=right){
			while (num[left] > prio)
				left++; //如果比基准元素小的位置不动
			while (num[right] < prio)
				right--; //如果比基准元素大的位置不动
			if (left<=right) { //如果有左边的元素大于右边的元素, 则进行交换
				swap(num, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void swap(int[] num, int left, int right) {
		int temp = num[left];
		num[left] = num[right];
		num[right] = temp;
	}





	//for Ken quick sort
	void sortKen(int[] num, int left, int right) { //num, 0, 7
		if (left <right) {
			int index = partitionKen(num, left, right);//基准元素的下标, 数组的划分调用
			sortKen(num, left, index-1);
			sortKen(num, index, right);
		}

	}

	public  int partitionKen(int[] num, int p, int r){
		int temp = num[r];
		int i = 0;
		for(int j = p; j <= r-1; j ++){
			if (num[j] <= temp){
				i = i + 1;
				//System.out.println(i + " " + j);
				try {
					swap(num, num[i], num[j]);
				}catch (ArrayIndexOutOfBoundsException e){
					System.out.println("i:" + i + "j: " + j);
					e.printStackTrace();
				}


			}
		}
		swap(num, num[i+1], num[r]);
		return i + 1;
	}
}
