Node nextNode(Node ptr, char x) {
    if(x == '0') {
        return ptr.left;
    }
    return ptr.right;
}

void decode(String S ,Node root) {
    Node ptr = root;
    for(int i = 0; i < S.length();) {
        Node temp = nextNode(ptr, S.charAt(i));
        if(temp != null) {
            
            if(i == S.length() - 1) {
                System.out.print(temp.data);
            }
            i++;
            ptr = temp;
        } else {
            System.out.print(ptr.data);
            ptr = root;
        }
    }
}