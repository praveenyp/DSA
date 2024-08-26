// Linked list life cycle
   
class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public class Main {
    public static class lifeCycle {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
        public static void main(String[] args) {
            lifeCycle list = new lifeCycle();

            ListNode node1 = new ListNode(3);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(0);
            ListNode node4 = new ListNode(-4);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node2;

            boolean result = list.hasCycle(node3);

            if (result) {
                System.out.println("Cycle detected in the linked list.");
            }else{
                System.out.println("No cycle is detected in the linked list.");
            }
        }
    }
}