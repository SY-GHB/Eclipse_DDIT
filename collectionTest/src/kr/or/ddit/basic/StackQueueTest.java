package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import print.Print;

public class StackQueueTest extends Print {

	/*
	 * - Stack == First IN Last out (FILO)선입후출, LIF(후입선출)
	 * 
	 * - Queue == FIFO(선입선출)의 자료구조.
	 */
	public static void main(String[] args) {
		/*
		 * -Stack의 명령 
		 * 1. 자료를 입력: .push(입력값)
		 * 
		 * 2. 자료 출력: .pop() ==> 자료를 꺼내온 후 꺼내온 자료를 STack에서 삭제한다.
		 * 			   .peek() ==> 삭제 없이 자료를 꺼내온다.
		 * 
		 */
		Stack<String> stack = new Stack<String>(); // stack클래스를 이용하기
//			LinkedList<String> stack2 = new LinkedList<String>(); //LinkedList를 이용하기

		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");

		System.out.println("stack ==> " + stack);
		
		String data = stack.pop();
		System.out.println(data);
		System.out.println("stack ==> " + stack);
		System.out.println("stack ==> " + stack.pop());
		System.out.println("stack ==> " + stack);
		
		stack.push("성춘향");
		System.out.println("stack ==> " + stack);
		System.out.println("stack ==> " + stack.pop());
		System.out.println("stack ==> " + stack);
		
		System.out.println("삭제없이 꺼내온 값: " + stack.peek());
		System.out.println("stack ==> " + stack);
		printVar();
		
		/*
		 * -Queue의 명령
		 * 1. 자료 입력: offer(입력값)
		 * 2. 자료 출력: poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
		 * 			   peek() ==> 삭제없이 자료를 꺼내온다.
		 */
		 
		Queue<String> queue = new LinkedList<String>();
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		System.out.println("queue ==> " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값: " + temp);
		System.out.println("꺼내온 값: " + queue.poll());
		System.out.println("queue ==> " + queue);
		
		queue.offer("성춘향");
		temp = queue.poll();
		System.out.println("queue ==> " + queue);
		
		
		System.out.println("삭제없이 꺼내온 값: " + queue.peek());
		System.out.println("queue ==> " + queue);
		printVar();
		
		//isEmpty() ==> Collection에 자료가 없으면 true, 있으면 false를 반환한다.
	
		System.out.println("스택이 비었는지의 여부: " + stack.isEmpty());
		stack.clear();
		System.out.println("스택이 비었는지의 여부: " + stack.isEmpty());
		
		System.out.println("큐가 비었는지의 여부: " + queue.isEmpty());
		queue.clear();
		System.out.println("큐가 비었는지의 여부: " + queue.isEmpty());
		
	}

}
