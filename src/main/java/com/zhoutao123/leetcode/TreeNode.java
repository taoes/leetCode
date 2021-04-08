package com.zhoutao123.leetcode;

/** 树节点Node */
public class TreeNode {
  public Integer val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  /** 通过数组构建链表 */
  public static TreeNode build(Integer[] data) {
    TreeNode[] nodes = new TreeNode[data.length];
    nodes[0] = new TreeNode(data[0]);

    for (int i = 1; i < data.length; i++) {
      if (data[i] == null) {
        continue;
      }
      // 计算父节点索引位置
      int parentNodeIndex = (i - 1) / 2;

      TreeNode node = new TreeNode(data[i]);
      nodes[i] = node;
      if (parentNodeIndex * 2 + 1 == i) {
        nodes[parentNodeIndex].left = node;
      } else {
        nodes[parentNodeIndex].right = node;
      }
    }
    return nodes[0];
  }
}
