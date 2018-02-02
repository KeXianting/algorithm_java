package leetcode;

/**
 * Created by kentorvalds on 2017/6/26.
 */
/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)



这道题定义了一种嵌套链表的结构，链表可以无限往里嵌套，规定每嵌套一层，深度加1，
让我们求权重之和，就是每个数字乘以其权重，再求总和。那么我们考虑，由于嵌套层数可以很大，
所以我们用深度优先搜索DFS会很简单，每次遇到嵌套的，递归调用函数，一层一层往里算就可以了，
我最先想的方法是遍历给的嵌套链表的数组，对于每个嵌套链表的对象，调用getSum函数，并赋深度值1，
累加起来返回。在getSum函数中，首先判断其是否为整数，如果是，则返回当前深度乘以整数，如果不是，
那么我们再遍历嵌套数组，对每个嵌套链表再调用递归函数，将返回值累加起来返回即可
 */
public class NestedListWeightSum {
}
