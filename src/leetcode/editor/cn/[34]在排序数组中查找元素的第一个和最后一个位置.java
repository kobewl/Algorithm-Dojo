//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2897 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        // 二分查找
        // 寻找左边界
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; // 防止溢出，向下取整
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return result;
        }
        result[0] = left;
        // 寻找右边界
        // 重置右边界
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // 防止溢出，向上取整
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        result[1] = right;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
