package com.practice;

import java.util.Arrays;
import java.util.List;

public class App {
	

	public static void main(String[] args) {
		//List<Integer> list1 = Arrays.asList(2, 4, 3);
		//List<Integer> list2 = Arrays.asList(5, 6, 4);
		List<Integer> list1 = Arrays.asList(9,8);
		List<Integer> list2 = Arrays.asList(1);
		ListNode headNode1 = null;
		ListNode headNode2 = null;
		for (Integer i : list1) {
			headNode1 = insertElement(i, headNode1);
		}
		for (Integer i : list2) {
			headNode2 = insertElement(i, headNode2);
		}
		printList(headNode1);
		printList(headNode2);
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode sumList = atn.addTwoNumbers(headNode1, headNode2);
		printList(sumList);
	}

	public static ListNode insertElement(int val, ListNode headNode) {
		ListNode listNode = new ListNode(val);
		if (headNode == null) {
			headNode = listNode;
		} else {
			ListNode currentNode = headNode;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = listNode;
		}
		return headNode;
	}

	public static void printList(ListNode listNode) {
		ListNode currentNode = listNode;
		while (currentNode.next != null) {
			System.out.print(currentNode.val + "-->");
			currentNode = currentNode.next;
		}
		System.out.println(currentNode.val);
	}
}
