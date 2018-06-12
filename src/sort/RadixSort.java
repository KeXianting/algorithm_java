package sort;


import java.util.LinkedList;
/**1344
 *
 * ge:1344%10=1344/1%10
 * shi:1344/10%10
 * bai:1344/100%10
 * @author Administrator
 *
 */
public class RadixSort {
	public static void main(String[] args) {
		int array[]={1,99,1,3,5,6,7,9,12,89,13123,10};
		new RadixSort().sort(array);
		for(int a:array)
			System.out.print(a+" ");

		//System.out.println(Math.pow(10, 3)%10);
	}
	public static void sort(int []array){
		//1.找出数组array中最大值
		int max = findMax(array);
		int time = 0; //time记录最大数的位数
		while(max>0){
			max/=10;
			time++;
		}
		//2.每位数都是从0到9
		LinkedList<Integer> queue[]=new LinkedList[10];
		for(int i=0;i<10;i++){
			queue[i]=new LinkedList<>(); //为每位数申请一个list空间
		}
		//3.对每位数对应的数组排序
		for(int i=0;i<time;i++){ //0代表个位,1代表十位,...
			//3.1
			for(int j=0;j<array.length;j++){
				//queue[array[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i)].add(array[j]);
				//(int)Math.pow(10, i): 10的i次方除以10取余数
				//array[j]/(int)Math.pow(10, i)%10: array[j]除以10的i次方然后除以10取余数, 得到每个数的个位, 十位,..对应的数字
				queue[array[j]/(int)Math.pow(10, i)%10].add(array[j]);
				//queue[0]存储个位为0的所有数, queue[1]存储个位为1的所有数
			}
			//3.2 按照位数重新组织数列(先按个位, 然后十位,...)
			int count = 0;
			for(int k=0;k<10;k++){
				while(!queue[k].isEmpty()){
					array[count++]=queue[k].remove(); //返回queue[k]的第一个元素给array[0]
				}
			}
		}


	}

	public static int findMax(int[] array) {
		int max = 0;
		for(int j=0;j<array.length;j++){
			if(array[j]>array[max]){
				max = j;
			}
		}
		return array[max];
	}
	
}
