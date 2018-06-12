package jianzhi_offer;

/**
 * Created by kentorvalds on 2018/4/17.
 */
public class Test {

/*
   // 链表节点的创建
    public class Node<T> {

        public T data;// 数据域，保存数据元素
        public Node<T> next;// 地址域，引用后继节点

        //初始化单链表
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        //空的单链表
        public Node() {
            this(null, null);
        }
    }

    //单链表的长度
    public int length(Node head) {
        int i = 0;
        Node p = head;// p从单聊表第一个节点开始
        while (p != null) {// 若单链表未结束
            i++;
            p = p.next;// p到达其后继节点
        }
        return i;
    }

    //单链表的增加元素
    // 将x对象插入在序号为i节点前
    public void insert(int i, Node x) {
        if (x == null)
            return;// 不能插入空对象
        Node p = head;// p指向头结点
        // 寻找插入位置
        for (int j = 0; p.next != null && j < i-1; j++)
            p = p.next;// 循环停止时,p指向第i-1节点或最后一个节点
        // 插入x作为p节点
        p.next = x;
        x.next = p;
    }

    //删除节点: O(1)
    public static void deleteNode(ListNode head,ListNode node){
        //删除尾节点，采用顺序查找找到尾节点的前一节点
        if(node.next==null){
            while(head.next!=node){
                head=head.next;
            }
            head.next=null;
        }
        //要删除的节点是头结点
        else if(head==node){
            head=null;
        }
        //要删除的节点是中间普通节点: 把要删除的节点的后一个节点覆盖在要删除的节点上
        else{
            node.data=node.next.data;
            node.next=node.next.next;
        }
    }

    //逆序创建单链表
    public static void createList(Node n, int[] a){
        n = null;
        for(int i = n -1; i>=0; --i){
            s = new Node();
            s.data = A[i];
            s.next = n;
            n = s;
        }
    }

    //链表的排序
     public static void quickSort(Node begin, Node end){
        if(begin == null || begin == end)
            return;

        Node index = paration(begin, end);
        quickSort(begin, index);
        quickSort(index.next, end);
    }
    public static ListNode paration(Node begin, Node end){
        if(begin == null || begin == end)
            return begin;

        int val = begin.val;  //基准元素
        Node index = begin, cur = begin.next;

        while(cur != end){
            if(cur.val < val){  //交换
                index = index.next;
                int tmp = cur.val;
                cur.val = index.val;
                index.val = tmp;
            }
            cur = cur.next;
        }


        begin.val = index.val;
        index.val = val;

        return index;
    }

    //删除链表中重复的元素
    //1.额外空间,用HashMap存储链表的节点以及个数
    public static void deleteDuplecate(Node head){
        HashMap<Integer, Integer> h = new HashMap();
        Node temp = head;
        Node pre = null;
        while(temp != null){
            if(h.containsKey(temp.data)){
                pre.next = temp.next
            }
        }
    }
    //2.不要用额外空间
     public ListNode deleteDuplication(Node pHead)
    {
		if (pHead == null) {
			return null;
		}
		Node preNode = null;
		Node node = pHead;
		while (node != null) {
			if (node.next != null && node.val == node.next.val) {
				int value = node.val;
				while (node.next != null && node.next.val == value) {
					node = node.next;
				}
				if (preNode == null) {
					pHead = node.next;
				} else {
					preNode.next = node.next;
				}
			} else {
				preNode = node;
			}
            node = node.next;
		}
		return pHead;
    }

    //单链表中倒数第k个节点:快慢指针,要求只能遍历一次单链表，可以设两个指针p和q，
    //最开始时它们都指向头结点，然后p向后移动k位，最后p,q同时向后移动直到p为最后一个结点，那么此时q即为所求。
    public LNode reciprocalKNode(Node L, int k) {
        if (k < 0) {
            System.out.println("k不可以为负数");
            return null;
        }
        if (L == null) {
            System.out.println("单链表为空");
            return null;
        }
        Node p = L;
        Node q = L;
        while (k > 0) {
            p = p.next;
            if (p == null) {
                System.out.println("单链表太短，不存在倒数第k个结点");
                return null;
            }
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

        //链表反转:不用额外空间, 记录下链表的断开位置
        public static Node ReverseList(Node head) {

            if(head == null){
                return null;
            }
            Node rHead = null;//逆转后的头节点
            Node prior = null;//store prior,前一个节点
            Node q = head;//store current, 记录当前节点

            while(q != null){
                Node next = q.next;//store the next

                if(next == null){
                    rHead = q;
                }

                q.next = prior;

                prior = q;
                q = next;
            }

            return rHead;
        }

        //从尾到头输出链表:递归(运用栈的特性)
        public static void printList(Node head){
            if(head !=null){
                printList(head.next);
                System.out.println(head.data);
            }
        }

        //寻找单边表的中间节点:快慢指针,慢指针走一步,快指针走两步
        public static Node searchMid(Node head){
            Node p = head;
            Node q = head;
            while(p != null && p.next != null && p.next.next != null){
                p = p.next.next;
                q = q.next;
            }
            return q;
        }

        //检测链表是否有环:快慢指针,慢指针走一步,快指针走两步
        public static boolean isLoop(Node head){
            Node fast = head;
            Node slow = head;
            if(fast==null){
                return false;
            }
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    return true;
                }
            }
           return !(fast == null || fast.next == null);
        }

        //在不知道头节点的情况下删除指定的节点,若n为尾节点则无法删除,因为不知道前驱
        public static boolean deleteNode(Node n){
            if(n == null || n.next == null){
                return false;
            }
            //用后面一个节点覆盖当前节点
            int temp = n.data;
            n.data = n.next.data;
            n.next.data = temp;
            n.next = n.next.next;
            return true;
        }

        //判断两个链表是否相交:首先遍历两个链表得到他们的长度，就能知道哪个链表比较长，
        //以及长的链表比短的链表多几个结点。在第二次遍历的时候，在较长的链表上先走若干步，
        //接着再同时在两个链表上遍历，找到第一个相同的结点就是他们的第一个公共结点。
        public Node findFirstCommonNode(Node root1,Node root2){
        int length1 = getLength(root1);
        int length2 = getLength(root2);
        Node pointLongListNode = null;
        Node pointShortListNode = null;
        int dif = 0;
        if(length1 >length2){
            pointLongListNode = root1;
            pointShortListNode = root2;
            dif = length1-length2;
        }else{
            pointLongListNode = root2;
            pointShortListNode = root1;
            dif = length2 - length1;
        }
        for(int i = 0;i<dif;i++)
            pointLongListNode = pointLongListNode.next;
        while(pointLongListNode != null && pointShortListNode != null && pointLongListNode != pointShortListNode){
            pointLongListNode = pointLongListNode.next;
            pointShortListNode = pointShortListNode.next;
        }
        return pointLongListNode;
        }
        private int getLength(Node root){
            int result = 0;
            if(root == null)
                return result;
            Node point = root;
            while(point != null){
                point = point.next;
                result++;
            }
            return result;
        }

        //链表环的入口: 判断是否有环,然后计算环中节点的个数k,
        //然后在用快慢指针,快指针先走k步,然后和慢指针同步走,最终相遇点就是环的入口
        public Node entryNodeOfLoop(Node pHead){
            //判断是否有环, 并返回环中相遇节点
            Node meetingNode = findMeetingNode(pHead);
            if(meetingNode == null){
                return null;
            }
            //计算环的长度
            int len = 1;
            Node p1 = meetingNode;
            while(p1.next != meetingNode){
                p1.next = p1.next;
                len ++;
            }
            //快指针先移动len
            Node fast = pHead;
            for(int i = 0; i < len; i ++){
                fast = fast.next;
            }
            //快慢指针同时移动
            Node slow = pHead;
            while(slow != fast){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        //合并两个排序的链表:递归
        public Node  Merge(Node pHead1,Node pHead2){
        if(pHead1 == null)
            return pHead2;
        else if(pHead2 == null)
            return pHead1;
        Node pMergedHead = null;
        if(pHead1.data <pHead2.data){
            pMergedHead = pHead1;
            pMergedHead.next = Merge(pHead1.next ,pHead2);
        }else{
            pMergedHead = pHead2;
            pMergedHead.next = Merge(pHead1,pHead2.next);
        }
        return pMergedHead;
         }
          //复制复杂链表
          public static Node copy(Node head){
            copyList(head);
            setSbiling(head);
            return disConnectList(head);
          }
          public static void copyList(Node head){
            Node node = head;
            while(node != null){

                Node copyNode = new Node();
                copyNode.value = node.value;
                copyNode.next = node.next;
                copyNode.sbiling = null;
                node.next = copyNode;
                node = copyNode.next;
            }

        }
        public static void setSbiling(Node head){
            Node node = head;
            while(node != null){
                Node copyNode = node.next;
                if(node.sbiling != null){
                    copyNode.sbiling = node.sbiling.next;
                }
                node = copyNode.next;
            }
        }
        public static Node disConnectList(Node head){
            Node node = head;
            Node copyHead = null;
            Node copyNode = null;

            if(node != null){
                copyHead = node.next;
                copyNode = node.next;
                node.next = copyNode.next;
                node = node.next;
            }

            while(node != null){

                copyNode.next = node.next;
                copyNode = copyNode.next;

                node.next = copyNode.next;
                node = node.next;
            }

            return copyHead;
        }

        //两个链表的第一个公共节点:和判断两个链表是否相交方法相同






===============================================================================
        栈,队列,堆

        //O(1)时间求栈中最小元素:加入一个辅助栈用来存储最小值集合
        static Stack<Integer> ele = new Stack();
        static Stack<Integer> min = new Stack();
        public static void push(int data){
            ele.push(data);
            if (min.isEmpty()){
                min.push(data);
            }else {
                if (data < min.peek()){//peek返回栈顶元素,不删除
                    min.push(data);
                }
            }
        }
        public static int pop(){
            int topData = ele.peek();
            ele.pop();
            if (topData == min()){//如果在原栈中删除栈顶元素和最小栈的栈顶元素相等,为了同步,两个栈中都需要删除
                min.pop();
            }
            return topData;
        }
        public static int min(){
            if (min.isEmpty()){
                return Integer.MAX_VALUE;
            }else {
                return min.peek();
            }
        }

        //两个栈模拟队列:第一个栈临时保存插入的数据，当调用弹出函数的时候，
        //如果stack2不为空则直接弹出；为空则把stack1中的数据全部弹出放到stack2中
        private Stack<String> stack1 = new Stack<String>();
        private Stack<String> stack2 = new Stack<String>();

        public void appendTail(String s){
            stack1.push(s);
        }
        public String deletedHead() throws Exception{
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            if(stack2.isEmpty()){
                throw new Exception("队列为空，不能删除");
            }
            return stack2.pop();
        }


        //队列的最大值:同滑动窗口最大值(把窗口大小改为队列的大小即可)
        public static ArrayList<Integer> maxInWindows(int [] num, int size){
                ArrayList<Integer> result = new ArrayList<Integer>();
                if (num == null || num.length < size || size == 0) {
                    return result;
                }
                //双端队列
                Deque<Integer> deque = new ArrayDeque<Integer>();
                for (int i = 0; i < num.length; i++) {
                    if (!deque.isEmpty() && (i - deque.peekFirst()) == size) {
                        // 如果队列头部的元素已经超出滑动窗口的范围，就将头部元素退出
                        deque.pollFirst();
                    }
                    while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                        // 如果新来的元素比队列最后一个元素大，则将最后一个元素退出
                        deque.pollLast();
                    }
                    deque.offer(i);
                    if (i >= (size - 1)) {
                        // 如果遍历的元素已经达到一个滑动窗口的大小，就开始提取窗口的最大值了
                        result.add(num[deque.peekFirst()]);
                    }

                }
                return result;
            }

           //栈的压入弹出序列:用到辅助栈
           public boolean IsPopOrder(int [] pushA,int [] popA) {
                if(pushA == null || popA == null){
                    return false;
                }
                int m = pushA.length;
                int n = popA.length;

                if(m == 0 || n == 0){
                    return false;
                }
                Stack<Integer> s = new Stack<Integer>();
                int start = 0;
                for(int i = 0; i < n; i++){
                    while(s.empty() || s.peek() != popA[i]){

                        if(start >= m){
                            return false;
                        }
                        s.push(pushA[start++]);
                    }
                    if(s.peek() != popA[i]){
                        return false;
                    }
                     s.pop();
                }
                return true;
            }



====================================================================
            //排序算法
            //选择排序
              public static void sort(int num[]){
                    for(int i=0;i<num.length-1;i++){
                        int min = i;
                        for(int j=i+1;j<num.length;j++){
                            if(num[min]>num[j]){
                                min = j;
                            }
                        }
                        if(min!=i)
                            Utils.exec(num,i,min);
                    }
                }

            //插入排序
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

            //冒泡排序
            public static void sort(int num[]){
                int Length= num.length;
                for(int i=0;i<Length-1;i++){
                    for(int j=0;j<Length-i-1;j++){
                        if(num[j]>num[j+1]){
                            Utils.exec(num, j, j+1);
                        }
                    }
                }
            }

            //希尔排序
            public static void sort(int num[]){
                int N = num.length;
                int gap = 1;
                while(gap<N/2) gap = 2*gap+1;
                while(gap>=1){
                    ////从第gap个元素，逐个对其所在组进行直接插入排序操作
                    for(int i=gap;i<N;i++){
                        ////插入排序采用交换法
                        for(int j=i; j >= gap  && Utils.less(num[j], num[j-gap]);j-=gap){
                            swap(num, j, j-gap);
                        }
                    }
                    gap = gap/2;
                }
            }
            public static void swap(int[] num, int left, int right) {
                int temp = num[left];
                num[left] = num[right];
                num[right] = temp;
            }


            //快速排序
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

            //堆排序:手写
            //把堆中的a,b位置的值互换
            public static void heapSort(){
                List<Integer> array = new ArrayList<Integer>(Arrays.asList(null,
                    1, 2, 5, 10, 3, 7, 11, 15, 17, 20, 9, 15, 8, 16));
                adjust(array);//调整使array成为最大堆

                for (int i = heap.size()-1; i > 0; i--) {
                //把根节点跟最后一个元素交换位置，调整剩下的n-1个节点，即可排好序
                    swap(heap,1, i);
                        adjust(heap,1, i - 1);
                    }
                }
             }
             //根据树的性质建堆，树节点前一半一定是分支节点，即有孩子的，所以我们从这里开始调整出初始堆
            public static void adjust(List<Integer> heap){
                for (int i = heap.size() / 2; i > 0; i--)
                    adjust(heap,i, heap.size()-1);//heap[heap.size()/2,...n]之后都为树的叶子节点, 每一叶子节点本身就是包含一个元素的最大堆, 故只需要构建heap.size()/2之前元素的最大堆

                System.out.println("=================================================");
                System.out.println("调整后的初始堆：");
                print(heap);
            }
            public static void adjust(List<Integer> heap,int i, int n) {
                int child;
                for (; i <= n / 2; ) {
                    child = i * 2;
                    if(child+1 <= n && heap.get(child) < heap.get(child+1))
                        child+=1;//使child指向值较大的孩子
                    if(heap.get(i)< heap.get(child)){
                        swap(heap,i, child);
                                //交换后，以child为根的子树不一定满足堆定义，所以从child处开始调整
                        i = child;

                    }  else break;
                }
            }
            public static void swap(List<Integer> heap, int a, int b) {
                //临时存储child位置的值
                int temp = (Integer) heap.get(a);

                //把index的值赋给child的位置
                heap.set(a, heap.get(b));

                //把原来的child位置的数值赋值给index位置
                heap.set(b, temp);
            }

            //归并排序
            //初始low=0; high=num.length-1
            public  static void sort(int num[],int low,int high){
                if(low<high){
                    int mid = low+(high-low)/2;
                    sort(num,low,mid);
                    sort(num,mid+1,high);
                    merge(num,low,mid,high);
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

            //计数排序
            public static int[] sort(int[] A) {
                int k = findMax(A);
                int[] C = new int[k+1]; //长度加1，同步伪代码
                int[] B = new int[A.length];

                //初始化
                for(int i=0;i<C.length;i++) {
                    C[i] = 0;
                }
                //将带排序数组元素重复个数映射到辅助数组中
                for(int i=0;i < A.length;i++) {
                    C[A[i]] = C[A[i]] + 1;
                }
                //处理辅助数组，使c[j]表示待排序数组中小于等于j的元素个数
                for(int i=1;i<C.length;i++) {
                    C[i] = C[i] + C[i-1];
                }
                //从后往前还原排序数组元素到一个新的数组
                int i = A.length-1;
                for(;i >= 0; i --) {
                    B[C[A[i]]-1] = A[i];
                    C[A[i]] = C[A[i]] - 1;
                }
                return B;
            }

            public static int findMax(int[] A) {
                int temp = 0;
                for(int i:A) {
                    if(i > temp) {
                        temp = i;
                    }
                }
                return temp;
            }

            //基数排序
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

            //桶排序
            static void bucketSort(double arr[]){
                int n = arr.length;
                ArrayList arrList[] = new ArrayList [n];
                //把arr中的数均匀的的分布到[0,1)上，每个桶是一个list，存放落在此桶上的元素
                for(int i =0;i<n;i++){
                    int temp = (int) Math.floor(n*arr[i]);
                    if(null==arrList[temp])
                        arrList[temp] = new ArrayList();
                    arrList[temp].add(arr[i]);
                }
                //对每个桶中的数进行插入排序
                for(int i = 0;i<n;i++){
                    if(null!=arrList[i])
                        insert(arrList[i]);
                }
                //把各个桶的排序结果合并
                int count = 0;
                for(int i = 0;i<n;i++){
                    if(null!=arrList[i]){
                        Iterator iter = arrList[i].iterator();
                        while(iter.hasNext()){
                            Double d = (Double)iter.next();
                            arr[count] = d;
                            count++;
                        }
                    }
                }
            }

        //用插入排序对每个桶进行排序
        static void insert(ArrayList list){
            if(list.size()>1){
                for(int i =1;i<list.size();i++){
                    if((Double)list.get(i)<(Double)list.get(i-1)){
                        double temp = (Double) list.get(i);
                        int j = i-1;
                        for(;j>=0&&((Double)list.get(j)>(Double)list.get(j+1));j--)
                            list.set(j+1, list.get(j));
                        list.set(j+1, temp);
                    }
                }
            }
        }







**/
}
