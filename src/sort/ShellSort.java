package sort;

//希尔排序
public class ShellSort {

	public static void main(String[] args) {
		int num[] = { 3, 1, 5, 4, 123, 55, 33, 123 };
		new ShellSort().sort(num);
		for (int n : num) {
			System.out.print(n + " ");
		}

	}
	public static void sort(int num[]){
		int N = num.length;
		int gap = 1;
		while(gap<N/2) gap = 2*gap+1;
		while(gap>=1){
			////从第gap个元素，逐个对其所在组进行直接插入排序操作
			for(int i=gap;i<N;i++){
				////插入排序采用交换法
				for(int j=i; j >= gap  && Utils.less(num[j], num[j-gap]);j-=gap){
					Utils.exec(num, j, j-gap);
				}
			}
			gap = gap/2;
		}
	}


	/**
	 * 希尔排序 针对有序序列在插入时采用移动法。
	 * @param arr
	 */
	public static void sort1(int []arr){
		//增量gap，并逐步缩小增量
		for(int gap=arr.length/2;gap>0;gap/=2){
			//从第gap个元素，逐个对其所在组进行直接插入排序操作
			for(int i=gap;i<arr.length;i++){
				int j = i;
				int temp = arr[j];
				if(arr[j]<arr[j-gap]){
					while(j-gap>=0 && temp<arr[j-gap]){
						//移动法
						arr[j] = arr[j-gap];
						j-=gap;
					}
					arr[j] = temp;
				}
			}
		}
	}
}
