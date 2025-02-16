//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/ 
//
// Related Topics 数组 排序 👍 68 👎 0


import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        // 对二维数组进行排序，排序规则是按照区间的起始位置进行升序排序。
        // 使重叠区间相邻，便于合并
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 双向链表，用于存储合并后的区间
        LinkedList<int[]> result =  new LinkedList<>();
        // 添加排序好之后的第一个区间
        result.add(intervals[0]);

        for (int[] interval : intervals) {
            // 如果当前区间的起始位置大于链表最后一个区间的结束位置，则将当前区间添加到链表末尾。
            int[] last = result.getLast();
            // 如果当前区间的起始位置小于等于链表最后一个区间的结束位置，则更新链表最后一个区间的结束位置为当前区间的结束位置和链表最后一个区间的结束位置中的较大值。
            if (last[1] < interval[0]) {
                result.add(interval);
            } else {
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
