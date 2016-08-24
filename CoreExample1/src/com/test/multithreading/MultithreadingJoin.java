package com.test.multithreading;

public class MultithreadingJoin extends Thread {

	public void run(){
		for(int i=1;i<=5;i++){  
			   try{  
			    Thread.sleep(500);  
			   }catch(Exception e){System.out.println(e);}  
			  System.out.println(i);  
			  }  
	}
	
	public static void main(String args[]){  
		MultithreadingJoin t1=new MultithreadingJoin();  
		MultithreadingJoin t2=new MultithreadingJoin();  
		MultithreadingJoin t3=new MultithreadingJoin();  
		 t1.start();  
		 try{  
		  t1.join();  
		 }catch(Exception e){System.out.println(e);}  
		  
		 t2.start();  
		 t3.start();  
		 }  
		}  

