# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
 
class Solution:
    def _is_symmetric(self, l, r):
        """
        :type l: NodeTree
        :type r: NodeTree
        :rtype: bool
        """
        if not l and not r:
            return True
        if l and not r:
            return False
        if r and not l:
            return False
        if l.val != r.val:
            return False
        return self._is_symmetric(l.right, r.left) and self._is_symmetric(l.left, r.right)
        
    def isSymmetric(self, root):
        """
        :type root: NodeTree
        :rtype: bool
        """
        if not root:
            return True
        return self._is_symmetric(root.left, root.right)
 
