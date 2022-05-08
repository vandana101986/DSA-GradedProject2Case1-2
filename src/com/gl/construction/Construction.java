package com.gl.construction;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Construction {

	public void orderOfConstruction(Deque<Integer> dq) {
		
		Stack<Integer> st=new Stack<Integer>();
		int dqSize=dq.size();
		
		int i=1;
	    while(i<=dqSize) {
	    	//save head of deque into temp
	     int temp=dq.remove();
	     
	     //if deque is empty, print stack elements
	     if(dq.isEmpty()) {
	    	 st.push(temp);
	    	 printStack(st,i,dq);
	    	 break;
	     }
	     
	     //if a floor size is smaller than the next,
	     //no construction happens on that day
	     if(temp<dq.getFirst()) {
	    	 st.push(temp);
	    	 System.out.println("Day "+i+" - ");	    	 
	     }
	     
	      //if a floor size is greater than the next,
	     //print all floors from stack
	     if(dq.isEmpty() || temp>=dq.getFirst()){
	    	 st.push(temp);
	    	 printStack(st,i,dq);	    	 	
	     	}
	     i++;
	    }
	}

	public void printDeque(Deque<Integer> dq)
	{
	    System.out.println("Floor Sizes provided on different days : ");
	   //Iterate through deque
	    int i=1;
	    while(i<=dq.size()) {
	     int temp=dq.remove();
	     System.out.println("Day "+i+" - "+ temp);
	     dq.addLast(temp);
	     i++;
	    }	 
	}
	
	public void printStack(Stack<Integer> st,int day,Deque<Integer> dq) {
		
		System.out.print("Day "+day+" - ");		
		while(!st.isEmpty()) {
			//check for any larger value than top of stack
			//in deque.If not present, continue popping stack
			//else stop popping from stack
			if(!hasLargerFloor(dq,st.peek()))
				System.out.print(st.pop()+" ");	
			else 
				break;			
		}			
		System.out.println("");
	}
	
	public boolean hasLargerFloor(Deque<Integer> dq,int num) {
		Iterator<Integer> it=dq.iterator();
		while(!dq.isEmpty() && it.hasNext()) {
			if(it.next()>num) 
				return true;				
			}
		return false;
	}
}




