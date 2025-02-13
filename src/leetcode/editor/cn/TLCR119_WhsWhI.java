//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 
// 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-
//sequence/ 
//
// Related Topics 并查集 数组 哈希表 👍 90 👎 0

 
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet; /**
 * 最长连续序列
 * @author wangliang
 * @date 2025-02-11 10:37:48
 */
public class TLCR119_WhsWhI{
	 public static void main(String[] args) {

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// 使用HashSet存储数组元素,并进行去重
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums){
			set.add(num);
		}
		int maxLen = 0;

		// 循环遍历数组元素,如果当前元素前面没有元素,则开始计算连续序列的长度
		for (int num : set){

			if (!set.contains(num - 1)){
				int currentNum = num;
				int currentLen = 1;

				while (set.contains(currentNum + 1)){
					currentNum++;
					currentLen++;
				}

				maxLen = Math.max(maxLen, currentLen);
			}
		}
		return maxLen;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}