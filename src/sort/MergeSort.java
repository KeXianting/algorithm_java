package sort;

public class MergeSort {
	public static void main(String[] args) {
		int num[] = {5,2,4,7,1,3,2,6,9};
		sort(num, 0, num.length-1);
		for (int n : num) {
			System.out.print(n + " ");
		}
	}

	//初始low=0; high=num.length-1
	public  static void sort(int num[],int low,int high){
		if(low<high){
			int mid = low+(high-low)/2;
			//System.out.println("左边:" + low);
			//1:low =0,mid=4,high=8;
			//2:low=0,mid=2,high=4;
			//3:low=0,mid=1,high=2;
			//4:low=0,mid=0,high=1;
			//5:low=3,mid=3,high=4;
			//6:low=5,mid=6,high=8;
			//7:low=5,mid=5,high=6;
			//8:low=7,mid=7,high=8
			sort(num,low,mid); //每一次结果会入栈(栈桢:保存函数的信息),low=0,mid=0,high=1时不满足(0=0), 会弹栈,回到上次执行的下一条语句出
			//System.out.println("右边:" + low);
			//1:low=0,mid=0,high=1;
			//2:low=0,mid=1,high=2;
			//3:low=0,mid=2,high=4;
			//4:low=3,mid=3,high=4;
			//5:low=0,mid=4,high=8;
			//6:low=5,mid=5,high=6;
			//7:low=5,mid=6,high=8;
			//8:low=7,mid=7,high=8
			sort(num,mid+1,high);//上一条弹栈的值为low=0,mid=0,high=1(mid+1=1=high(1)),不满足,弹栈,进入下一条语句;// 下一条返回后继续执行low=0,mid=1,high=2,此时不满足,执行下一条; 再次返回后low=0,mid=2,high=4,此时满足if条件,因此构建此语句的调用栈
			//1:low=0,mid=0,high=1;
			//2:low=0,mid=1,high=2;
			//3:low=3,mid=3,high=4;
			//4:low=0,mid=2,high=4;
			//5:low=5,mid=5,high=6;
			//6:low=7,mid=7,high=8;
			//7:low=5,mid=6,high=8;
			//8:low=0,mid=4,high=8
			merge(num,low,mid,high);//上一条的弹栈的值,low=0,mid=0,high=1,执行结束后num={2,5,4,7,1,3,2,6,9},回来继续执行,上一条语句继续执行弹栈
		}
		
	}



	public static void merge(int[] num, int low, int mid, int high) {
		int copyNum[]=new int[num.length];
		for(int i=0;i<=high;i++){
			copyNum[i] = num[i];
		}
		int left = low;
		int right = mid+1;
		int current = low;
		while(left<=mid && right<=high){
			if(copyNum[left]<copyNum[right]){
				num[current++]=copyNum[left];
				left++;
			}else{
				num[current++]=copyNum[right];
				right++;
			}
		}

		int remaining = mid-left;
		for(int i=0;i<=remaining;i++){
			num[current+i]=copyNum[left+i];
		}
	}

}
