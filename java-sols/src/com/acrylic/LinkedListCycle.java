package com.acrylic;

import java.util.HashSet;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        HashSet<ListNode> visited = new HashSet<>();
        ListNode current = head;
        do {
            if (visited.contains(current))
                return true;
            visited.add(current);
            current = current.next;
        } while (current != null);
        return false;
    }

}
