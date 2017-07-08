   /* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */
static Node insert(Node root, int val) {
	if (root == null) {
		Node temp = new Node();
		temp.val = val;
		temp.ht = 0;
		temp.left = null;
		temp.right = null;
		return temp;
	}
	int cmp = val - root.val;

	if (cmp < 0) {
		root.left = insert(root.left, val);
	} else if (cmp > 0) {
		root.right = insert(root.right, val);
	}
	root.ht = Math.max(root.right != null ? root.right.ht : -1, root.left != null ? root.left.ht : -1) + 1;
	root = ifAffectedDoBalancing(root);
	return root;
}

static private Node ifAffectedDoBalancing(Node node) {
	int nodebf = (node.left != null ? node.left.ht : -1) - (node.right != null ? node.right.ht : -1);
	if (nodebf < -1) {
		int noderightbf = (node.right.left != null ? node.right.left.ht : -1) - (node.right.right != null ? node.right.right.ht : -1);
		if (noderightbf < 0) {
			node = leftRotation(node);
		} else {
			node.right = rightRotation(node.right);
			node = leftRotation(node);
		}
	} else if (nodebf > 1) {
		int nodeleftbf = (node.left.left != null ? node.left.left.ht : -1) - (node.left.right != null ? node.left.right.ht : -1);
		if (nodeleftbf > 0) {
			node = rightRotation(node);
		} else {
			node.left = leftRotation(node.left);
			node = rightRotation(node);
		}
	}
	return node;
}

static private Node leftRotation(Node A) {
	Node B = A.left;
	Node C = A.right;
	Node temp = C.left;
	A.right = temp;
	C.left = A;
	A.ht = Math.max(A.left != null ? A.left.ht : -1, A.right != null ? A.right.ht : -1) + 1;
	C.ht = Math.max(C.left != null ? C.left.ht : -1, C.right != null ? C.right.ht : -1) + 1;
	return C;
}

static private Node rightRotation(Node A) {
	Node B = A.left;
	Node C = A.right;
	Node temp = B.right;
	A.left = temp;
	B.right = A;
	A.ht = Math.max(A.left != null ? A.left.ht : -1, A.right != null ? A.right.ht : -1) + 1;
	B.ht = Math.max(B.left != null ? B.left.ht : -1, B.right != null ? B.right.ht : -1) + 1;
	return B;
}