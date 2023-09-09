# 利用队列层序遍历整棵树，最后翻转一下即可。

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtypr: List[List[int]]
        """
        
        self.results = []
        if not root:
            return self.results
        
        q = [root]
        while q:
            self.results.append([n.val for n in q])
            
            new_q = []
            for node in q:
                if node.left:
                    new_q.append(node.left)
                if node.right:
                    new_q.append(node.right)
                
            q = new_q
            
        return list(reversed(self.results))

