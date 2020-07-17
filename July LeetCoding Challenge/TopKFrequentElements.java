/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*/
class Solution {
        class pair implements Comparable<pair>{
            int data, freq;
            pair(int data, int freq){
                this.data = data;
                this.freq = freq;
            }
             public int compareTo(pair o){
            return o.freq-this.freq;
        }
        }
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);

            PriorityQueue<pair> queue = new PriorityQueue<>();
            for(int key : map.keySet())
                queue.add(new pair(key, map.get(key)));
            int[] ans = new int[k];
            int index = 0;
            while(k-- > 0){
                pair it = queue.poll();
                ans[index++] = it.data;
            }
            return ans;
        }
    }
