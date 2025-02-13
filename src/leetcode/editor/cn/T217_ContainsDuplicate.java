//给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,1] 
// 
//
// 输出：true 
//
// 解释： 
//
// 元素 1 在下标 0 和 3 出现。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,4] 
// 
//
// 输出：false 
//
// 解释： 
//
// 所有元素都不同。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,1,1,3,3,4,3,2,4,2] 
// 
//
// 输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 排序 👍 1113 👎 0

 
package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 存在重复元素
 * @author wangliang
 * @date 2025-02-13 22:13:43
 */
public class T217_ContainsDuplicate{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new T217_ContainsDuplicate().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 哈希表
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int num : nums){
			if (map.get(num) > 1){
				return true;
			}
		}
		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}