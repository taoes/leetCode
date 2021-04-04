package com.zhoutao123.leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Q146: Lru 缓存
 * <li>执行用时： 19 ms , 在所有 Java 提交中击败了 73.71% 的用户
 * <li>内存消耗： 46.5 MB , 在所有 Java 提交中击败了 57.80% 的用户
 *
 * @apiNote 核心思想: 使用Java的LinkedHashMap实现
 * @apiNote https://leetcode-cn.com/problems/lru-cache/
 */
public class Q146_LruCache {
  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // 缓存是 {1=1}
    lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    assert 1 == lRUCache.get(1); // 返回 1
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    assert -1 == lRUCache.get(2); // 返回 -1 (未找到)
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    assert -1 == lRUCache.get(1); // 返回 -1 (未找到)
    assert 3 == lRUCache.get(3); // 返回 3
    assert 4 == lRUCache.get(4); // 返回 4
  }

  static class LRUCache {
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
      map =
          new LinkedHashMap<Integer, Integer>(capacity, 1f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
              return this.size() >= capacity;
            }
          };
    }

    public int get(int key) {
      Integer v = map.get(key);
      return v == null ? -1 : v;
    }

    public void put(int key, int value) {
      map.put(key, value);
    }
  }
}
