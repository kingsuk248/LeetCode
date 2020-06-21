package com.practice;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode current1 = l1;
		ListNode current2 = l2;

		ListNode sumListHead = null;
		ListNode sumListNode = null;
		int carryOver = 0;

		while (current1 != null && current2 != null) {
			int sum = current1.val + current2.val + carryOver;
			int sumListVal = sum % 10;
			carryOver = sum / 10;
			sumListNode = new ListNode(sumListVal);
			if (sumListHead == null) {
				sumListHead = sumListNode;
			} else {
				ListNode sumListCurrent = sumListHead;
				while (sumListCurrent.next != null) {
					sumListCurrent = sumListCurrent.next;
				}
				sumListCurrent.next = sumListNode;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		while (current1 != null) {
			carryOver = addResidual(current1, carryOver, sumListNode, sumListNode);
			current1 = current1.next;
		}

		while (current2 != null) {
			carryOver = addResidual(current2, carryOver, sumListNode, sumListNode);
			current2 = current2.next;
		}
		if (carryOver != 0) {
			sumListNode = new ListNode(1);
			ListNode sumListCurrent = sumListHead;
			while (sumListCurrent.next != null) {
				sumListCurrent = sumListCurrent.next;
			}
			sumListCurrent.next = sumListNode;
		}
		return sumListHead;
	}
	
	private int addResidual(ListNode current, int carryOver, ListNode sumListNode, ListNode sumListHead) {
		int sum = current.val + carryOver;
		int sumListVal = sum % 10;
		carryOver = sum / 10;
		sumListNode = new ListNode(sumListVal);
		ListNode sumListCurrent = sumListHead;
		while (sumListCurrent.next != null) {
			sumListCurrent = sumListCurrent.next;
		}
		sumListCurrent.next = sumListNode;
		return carryOver;
	}
}
