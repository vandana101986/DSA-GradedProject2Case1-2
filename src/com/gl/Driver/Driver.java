package com.gl.Driver;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import com.gl.construction.Construction;

public class Driver {	

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Construction con=new Construction();
		Deque<Integer> dq=new LinkedList<Integer>();
		
		System.out.println("Enter total number of floors in the building : ");
		int floors=sc.nextInt();
		
		for(int j=0;j<floors;j++) {
			System.out.println("Enter the floor size given on day "+(j+1)+" : ");
			int ele=sc.nextInt();
			dq.add(ele);	
		}
		//print all elements of deque
		con.printDeque(dq);
		
		System.out.println("The order of construction is as follows");
		con.orderOfConstruction(dq);
		sc.close();
	}	
	
	
	
}
