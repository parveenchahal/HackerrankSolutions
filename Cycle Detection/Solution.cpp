int HasCycle(Node* head)
{
    Node *slow = head, *fast = head;
    while(fast != NULL) {
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast) {
            return 1;
        }
    }
    return 0;
}
