import java.math.BigInteger;

public class TreeSet implements BigIntSet {

  private int size = 0;
  private TreeNode root;
  
  /**
  // Added this
  public TreeSet(BigInteger value){
      root = new TreeNode(value);
      size = 1;
  }
  
  // Added this
  public TreeSet(){
      root = null;
      size = 0;
  }
  */
  public void add(BigInteger value) {
    TreeNode temp = root;
    if (temp == null){
        root = new TreeNode(value);
        size++;
        return;
    }
    add(value, root);
  }
  
  private void add(BigInteger value, TreeNode node) {
    // determine if the value replaces this node's value, or should recurse to
    // the left, or recurse to the right.
    // TODO implement.
    if (value.compareTo(node.value) <= -1){
        if (node.left == null){
            node.left = new TreeNode(value);
            size++;
        }else{
            add(value, node.left);
        }
    }else if (value.compareTo(node.value) >= 1){
            if (node.right == null){
                node.right = new TreeNode(value);
                size++;
            }else{
                add(value, node.right);
            }
    }
  }
  
  public boolean contains(BigInteger value) {
    return contains(value, root);
  }
  
  private boolean contains(BigInteger value, TreeNode node) {
    // determine if the value is this node's value, or should recurse to the
    // left, or recurse to the right, or is not in this tree.
    // TODO implement.
    if (node == null){
        return false;
    }
    
    if (node.value.compareTo(value) == 0){
        return true;
    }

    if (value.compareTo(node.value) <= -1){
        return contains(value, node.left);
    }
    return contains(value, node.right);

  }
  
  public void remove(BigInteger value) {
    if (isEmpty()) {
      return;
    }
    if (value.equals(root.value)) {
      removeRoot();
      return;
    }
    remove(root, value);
  }
  
  private void remove(TreeNode parent, BigInteger value) {
    // we work through the parent node, because we need the parent to remove
    // any nodes from the tree.
    // start by comparing the value to the parent node's value - this will
    // indicate if we go right or go left.
    if (value.compareTo(parent.value) > 0) {
      if (parent.right != null) { // if no right child, there's nothing to do.
        if (parent.right.value.equals(value)) {
          // remove right node
          if (parent.right.countChildren() == 0) {
            parent.right = null;
          } else if (parent.right.countChildren() == 1) {
            parent.right = parent.right.getSingleChild();
          } else {
            // if two children, we had a harder job to do.
            complexRemove(parent.right);
          }
          size--;
        } else {
          // if there's a right value, we recurse to the next level of depth.
          remove(parent.right, value);
        }
      }
    } else {
      // same as above, but opposite side.
      if (parent.left != null) {
        if (parent.left.value.equals(value)) {
          if (parent.left.countChildren() == 0) {
            parent.left = null;
          } else if (parent.left.countChildren() == 1) {
            parent.left = parent.left.getSingleChild();
          } else {
            complexRemove(parent.left);
          }
          size--;
        } else {
          remove(parent.left, value);
        }
      }
    }
  }
  
  private void complexRemove(TreeNode node) {
    TreeNode current = node;
    // We don't always want to remove in the same direction, 
    // so we use random.
    if (Math.random() < 0.5) {
      current = node.right;
      if (current.left == null) {
        // this means that the node's right child is the left-most left child.
        // we should put its value in "node" and then remove it from the tree.
        node.value = current.value;
        node.right = current.right;
      } else {
        // find the parent of the left-most right child.
        while (current.left.left != null) {
          current = current.left;
        }
        // current is now the parent of the left-most node
        // set the value of original node to the left-most value
        node.value = current.left.value;
        // remove the left node. It's either:
        //   A) a leaf so current.left.right is null, or
        //   B) a node with 1 child, so current.left.right is OK.
        current.left = current.left.right;
      }
    } else {
      // all of the above applies, but in the opposite direction.
      current = node.left;
      if (current.right == null) {
        node.value = current.value;
        node.left = current.left;
      }
      while (current.right.right != null) {
        current = current.right;
      }
      node.value = current.right.value;
      current.right = current.right.left;
    }
  }

  private void removeRoot() {
    if (root.countChildren() == 0) {
      root = null;
    } else if (root.countChildren() == 2) {
      complexRemove(root);
    } else if (root.left != null) {
      root = root.left;
    } else {
      root = root.right;
    }
    size--;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
  
  public void clear() {
    root = null;
    size = 0;
  }
  
  public int size() {
    return size;
  }
  
  private class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public BigInteger value;
    
    public TreeNode(BigInteger value) {
      this.value = value;
    }
    
    public int countChildren() {
      if (left == null && right == null) {
        return 0;
      }
      if (left != null && right != null) {
        return 2;
      }
      return 1;
    }
    
    public TreeNode getSingleChild() {
      if (left == null) {
        return right;
      }
      return left;
    }
  }
}