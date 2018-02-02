package sort;

public class InsertSort {
	public static void main(String[] args) {
		int num[] = { 3, 1, 5, 4, 123, 55, 33, 123 };
//		new InsertSort().sort(num);
//		for (int n : num) {
//			System.out.print(n + " ");
//		}
		insertSort(num);
		for (int n : num) {
			System.out.print(n + " ");
		}

	}


	public static void insertSort(int[] arr){
		int i, j;
		int n = arr.length;
		int target;

		//假定第一个元素被放到了正确的位置上
		//这样，仅需遍历1 - n-1
		for (i = 1; i < n; i++)
		{
			j = i;
			target = arr[i];

			while (j > 0 && target < arr[j - 1])
			{
				arr[j] = arr[j - 1];
				j--;
			}

			arr[j] = target;
		}
	}


	void sort(int num[]){
		for(int i=1;i<num.length;i++){
			for(int j=i;j>0 && Utils.less(num[j],num[j-1]);j--){
				Utils.exec(num, j, j-1);
			}
		}
	}

}
