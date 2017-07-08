private Integer temp = null;
boolean checkBST(Node root) {
    if(root == null) {
        return true;
    }
    boolean flag = checkBST(root.left);
    if(temp == null) {
        temp = root.data;
    } else if(temp >= root.data) {
        return false;
    } else {
        temp = root.data;
    }
    if(flag)
    flag = checkBST(root.right);
    return flag;
}
