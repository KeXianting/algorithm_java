implement data structure and algorithms
==
data_struct: 主要包括数据结构的java实现
--
1.数组

2.并查集

3.图

4.链表

5.队列

6.栈

7.树

divide_conquer:分治
=====
1.活动选择问题

2.输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。 求所有子数组的和的最大值。要求时间复杂度为O(n)。

3.最长回文

4.顺序统计量

5.Strassen矩阵乘法

dynamic:动态规划
-----
1.最长公共序列

2.最长公共子串

3.矩阵链乘法

4.最优二叉查找树

greedy:贪心算法
=====
leetcode: LeetCode上的题目
=======
methodofprogramming: 编程之美上的例子以及习题
--------
第一章:字符
==========
AlternateStr:

输入三个字符串s1、s2和s3，判断第三个字符串s3是否由前两个字符串s1和s2交错而成， 即不改变s1和s2中各个字符原有的相对顺序，例如当s1 = “aabcc”，s2 = “dbbca”， s3 = “aadbbcbcac”时，则输出true，但如果s3=“accabdbbca”，则输出false。

AverageDistribution01:

均分01: 有字符串只有0和1两种字符, 切0和1的个数为偶数, 对改字符进行切割,然后分给两个人,是的两个人分的的0和1一样多 例如，输入串是010111,我们可以把串切位01, 011,和1， 把第1段和第3段放在一起分给一个人，第二段分给另外一个人，这样每个人都得到了1个0和两个1。我们要做的是让切分的次数尽可能少。 输入是这样一个字符串，输出是最少的切分次数，保证输入合法。

CharInStringCount:

给定一个字符串，请写出一个函数，查找出每个字符的个数，要求区分大小写，且时间复杂度是O(n)。

CharMove:

字符串移动（字符串为’’号和26个字母的任意组合，把’’号都移动到最左侧，把字母移到最右侧并保持相对顺序不变），要求时间和空间复杂度最小 ###DeleteSpeChar:输入两个字符串，从第一个字符串中删除第二个字符串中出现的所有字符。 例如：输入"they are students." 与 “aeiou”,则应该输出“thy r stdnts.”

FirstCharInString:

第一个只出现一次的字符: 例如: 输入: "abaccdeff", 输出: b

FiveStrokeEncode:

如果将五笔的编码按字典序排序，形成数组如下：a, aa, aaa, aaaa, aaab, aaac, ..., b, ba, baa, baaa, baab...yyyx, yyyy 其中a的索引是0，aa的索引是1，aaa的索引是2，aaaa的索引是3，以此类推： 1）、编写一个函数，输入是任意一个合法的字符串，输出这个字符串对应的索引； 2）、编写一个函数，输入是任意一个合法的索引，输出这个索引对应的字符串。 ###IsPalindrome:回文判断,正读和反读都一样的字符串, 如madam, 我爱我

LongestContinueString:

最长连续字符: 例如"aaaabbcc"最长连续字符长度为4; "aabb"最长连续字符长度为2

LongestPalindrome:

最长回文子串: 给定一个字符串求出最长回文子串长度 ###LongestPublicSubstring:最长公共子串(区别与最长公共子序列): A="pabcni", B="wepiabc"; 则输出为"abc"

LongestRepeatSubString:

最长重复子串

ShortestAbstract:

互联网搜素已经成了我们生活和工作的一部分，在输入一些关键词之后， 搜索引擎会返回许多结果，每个结果都包含一段概括网页内容的摘要。 例如，在百度上搜索框中输入“图的最小生成树 - heart_love”，将会显示如下内容： xxxxx最小生成树.....heart——lovexxxxxx....

SmallestSubString:

最短子串:一篇文章由一个个单词组成,单词用空格分开,在一个字符数组char[] str={"hello","world","good"} 求给定文档中包含这个字符的数组的最短字符串

StringCombine:

并查集(算法导论21章) 字符串合并:给定一些字符串的集合,要求将其中交集不为空的集合合并,并且合并完成后的集合之间无交集.例如: {aaa,bbb,ccc},{bbb,ddd},{eee,fff},{ggg},{ddd,hhh}和操作后为: {aaa,bbb,ccc,ddd,hhh},{eee,fff},{ggg} ###StringCompress: 字符串空格的压缩：给定一个字符串，将其中连续出现的空格压缩为1个后，将其中已空格分隔的每个字符串逆序打印出来 例如: abc efg hij ef实现后变为:cba gfe jih fe

StringContain:

字符串包含: 字符串a: 'ABCD'; 字符串b: 'BAD'; 则字符串a包含字符串b(因为a里面还有字符BAD) ###StringEditDistance:给定一个源串和目标串，能够进行如下操作： 在任意位置上插入一个字符； 替换掉任意字符； 删除任意字符。 写一个程序，实现返回最小操作次数，使得对源串进行上述这些操作后等于目标串。 ###StringMatch:字符串匹配

StringPermutation:

字符串全排列的问题。例如：输入为{‘a’,’b’,’c’}，则其全排列组合为abc,acb,bac,bca,cba,cab。对于输入长度为n的字符串数组，全排列组合为n!种

StringReverse:

字符串反转: July变化后为yluJ

StringShift:

字符串旋转: 字符串'abcdef', 的前3个字符'a','b','c'旋转后变为:'defabc'

StringToInt:

输入字符串"1234"转化为整数1234

第二章:数组
------------------
ArrayDivideToAbs:

数组中的数分为两组，给出一个算法，使得两个组的和的差的绝对值最小。数组中的数的取值范围是0<x<100，元素个数也是大于0，小于100 比如a[]={2,4,5,6,7},得出的两组数{2，4,，6}和{5，7}，abs(sum(a1)-sum(a2))=0; 比如{2，5，6，10}，abs(sum(2,10)-sum(5,6))=1,所以得出的两组数分别为{2，10}和{5,6}。

ArraySegmentation:

数组分割: 给定一个数组, 长度为n, 将其分为m份, 使各份的和相等, 求m的最大值

ArraysMerge:

设子数组a[0:k-1]和a[k:n-1]已经排序（0<=k<=n-1）。 请设计一个合并这两个子数组为排好序的数组a[0:n-1]的算法。 要求算法在最坏情况下所用的计算时间为O(n)，且只用到O(1)的辅助空间。

BloomFileter:

布隆过滤器 ###CountOfOne:给定一个十进制整数N，求出从1到N的所有整数中出现"1"的个数

DrawProblem:

你的朋友提议玩一个游戏：将写有数字的 n个纸片放入口袋中，你可以从口袋中抽取 4次纸 片，每次记下纸片上的数字后都将其放回口袋中。如果这 4个数字的和是 m，就是你赢，否 则就是你的朋友赢。你挑战了好几回，结果一次也没赢过，于是怒而撕破口袋，取出所有纸 片，检查自己是否真的有赢的可能性。请你编写一个程序，判断当纸片上所写的数字是 k 1 , k 2 , …, k n 时，是否存在抽取 4次和为 m的方案。如果存在，输出 Yes；否则，输出 No。

Fibonacci:

一个台阶总共n级, 如果一次可以跳1级, 也可以跳两级, 求总共有多少中跳法 ###FindMappingArray:根据上排给出十个数，在其下排填出对应的十个数 要求下排每个数都是先前上排那十个数在下排出现的次数。 上排的十个数如下： 【0，1，2，3，4，5，6，7，8，9】 举一个例子， 数值: 0,1,2,3,4,5,6,7,8,9 分配: 6,2,1,0,0,0,1,0,0,0 0 在下排出现了 6 次，1 在下排出现了 2 次， 12 2 在下排出现了 1 次，3 在下排出现了 0 次.... 以此类推..

FindPairNumbers:

给定一个数组, 输出满足2a=b(a,b为数组中的数)的数对, 要求时间复杂度尽可能低;在给定数组中找出其中和最接近0的两个值 ###Five100MaxNumbers:寻找500个最大的数有20个数组，每个数组里面有500个数字，降序排列，每个数字是32位的int,求出这10000个数字中最大的500个

FixedSumOfBinaryTree:

输入一个整数和一棵二元树。从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。打印出和与输入整数相等的所有路径。

FixedSumOfManyNumbers:

输入两个整数n和sum, 要求从1,2,3,4...,n中随机取出几个数,使得他们的和等于sum输出所有可能的组合

FixedSumOfTwoNumber:

和为定值的两个数: 输入一个整数数组和一个整数,在数组中查找出一对数,满足他们的和正好是输入的那个整数,如果有多对则输出任意一对即可 例如:输入数组[1,2,4,5,7,11,15]和整数15 则输出:4和11

HalfTimesArray:

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字

JosephRemoveM:

n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始， 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。 求出在这个圆圈中剩下的最后一个数字。

LargestRectangleArea:

一个直方图是由许多矩形组成，在给定的直方图中找出最大的矩形面积。为了简化问题，假定所有矩形宽度都为1个单位。

LatticePro:

有n*n个格子，每个格子里有正数或者0，从最左上角往最右下角走， 只能向下和向右走，一共走两次(即从左上角往右下角走两趟)， 把所有经过的格子里的数加起来，求总和的最大值。如果两次经过同一个格子， 则最后求得的总和中该格子中的数只加一次。

LessSeq:

有一个由n个正整数组成的序列,给定一个整数s,要求出序列中长度最短的一个连续序列,满足该序列的和大于等于S的条件

LIS:

从一列数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小

LongestDecreasingSequence:

最长递减子序列: 求一个数组的最长递减子序列

MatrixMultiple:

矩阵相乘

MaxGapOfUnorderArray:

有一个无序数组V[N], 请找出该数列中大小相邻的实数的差的最大值,求线性空间和线性时间

MaxSubArray:

一个整数数组中的元素有正有负，在该数组中找出一个连续子数组，要求该连续子数组中各元素的和最大

MaxSubArrayInArray:

从N个整数中找了(n-1)个元素乘积最大的那一组

MDifferentNumbers:

从1,2,3,...,n中随机输出m个不重复的数

Medium:

给定3个数,请找出3个数的中位数

MinimumAbs:

数组中的最小绝对值

MinimumOfTwoArrays:

有两个序列a,b，大小都为n,序列元素的值任意整数，无序；要求：通过交换a,b 中的元素，使[序列a 元素的和]与[序列b 元素的和]之间的差最小。

MinimumRotateArray:

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个排好序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。

MininumNumberInArray:

输入一个正整数数组，把数组里面所有的数字拼接排成一个数，打印能拼接出的所有数字中的一个。例如输入数组｛3，32，321｝，则打印出这3个数字能排成的最小数字321323.

MiniumKNumbers:

有n个数,找出其中最小的k个数,要求时间负责副尽可能低

MoneyChange:

想兑换100元的零钱, 有1元,2元,5元和10元的四种面值, 总共多少种换法

NEggMBasket:

有N个鸡蛋和M个篮子，把鸡蛋放到M个篮子里，每个篮子都不能为空。

NetherlandsFlag:

现有红白蓝三个不同颜色的小球，乱序排列在一起，请重新排列这些小球，使得红白蓝三色的同颜色的球在一起

NotRandNumberRemove:

现在有1千万个随机数，随机数的范围在1到1亿之间。现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来

OddEnenSort:

长度为 n 的整数数组，对数组进行整理，使得所有的奇数都在数组的前面，而所有的偶数都在数组的后面。例如数组为 {1,2,3,4,5,6}. 整理后为 {1,3,5,2,4,6}. ###OddTwoNumbers:一个数组中，有两个数出现了奇数次，其余的数都出现偶数次，找出这两个数。

OnlyRepeated:

1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现一次．每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空间

RabbitReproduce:

如果有一对小兔，每一个月都生下一对小兔， 而所生下的每一对小兔在出生后的第三个月也都生下一对小兔。 那么，由一对兔子开始，满一年时一共可以繁殖成多少对兔子？(兔子没有死亡)

SimilarPartsOfNArrarys:

寻找n个数组的公共部分: 给定一个数组, 每个数组的元素都是递增的, 现在要找出这n个数组中的公共元素, 要求不能用额外辅助空间

StationDistance:

一个环形公路，上面有Ｎ个站点，A1, ..., AN，其中Ai和Ai+1之间的距离为Di,AN和A1之间的距离为D0。 高效的求第i和第j个站点之间的距离，空间复杂度不超过O(N)

SumOfMaxMatrix:

最大子矩阵和是最大子序列和的二维扩展

TaskAllocation:

100个任务，100个工人每人可做一项任务，每个任务每个人做的的费用为t[100][100],求一个分配任务的方案使得总费用最少(匈牙利算法求解)

ThreeOnlyRepeated:

在一个数组里, 只有三个只出现一次, 其他的数都是出现两次的, 找出这三个数 ###TopK:在一亿个整数中寻找1000个最大的

TwoOnlyRepeated:

一个整型数组里除了两个数字之外，其他的数字都出现了两次。

WaveArray:

一个数组[1,2,3,4,6,8,9,4,8,11,18,19,100] 前半部分是是一个递增数组，后面一个还是递增数组，但整个数组不是递增数组，那么怎么最快的找出其中一个数？

YoungTableau:

杨氏矩阵是一个二维矩阵，特点是每一行的右边的元素比左边的大，每一列下面的元素比上面的大； 比如: 1 2 8 9 2 4 9 12 4 7 10 13 6 8 11 15 定位法(Step-wise线性搜索解法) 假设要查找的变量为target, 以右上角的节点为基准点，如果查找的元素比基准点小， 那么基准点所在的列就可以排除了；如果查找的元素比基准点大， 那么基准点所在的行就可以排除了，就这样反复排除，最后可以把时间复杂度降低到O(m+n)，从左下角开始查找也是同样的道理，但是左上角和右下角就不行了，无法做到剔除某列或某行的效果
