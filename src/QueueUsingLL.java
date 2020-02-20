class Node<T>{
	T data;
	Node<T> next;
	Node(T data)
		{
	  this.data=data;
	next=null;	
		}
}
//class QueueFullException extends Exception {
//
//	/**
//	 * 
//	 */
//private static final long serialVersionUID = 1L;
//
//}
//class QueueEmptyException extends Exception {
//
//		/**
//		 * 
//		 */
//private static final long serialVersionUID = 1L;
//
//	}

public class QueueUsingLL<T>{
private Node<T> front;
private Node<T> rear;
	int size;
	
	public 	QueueUsingLL(){
		front=null;
		rear=null;
		size=0;
	}
	public int size(){
		return size;	
	}
	
public 	boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
	
public 	T front() throws QueueEmptyException{
	if(size==0){
		throw new  QueueEmptyException();
	}
	return front.data;
	}
	
	public void enqueue(T value){
		Node<T> newNode=new Node<T>(value);
		if(rear==null){
			front=newNode;
			rear=newNode;
		}
		else{
			rear.next=newNode;
			rear=newNode;
		}
		size++;
		
	}
	
	public T dequeue() throws QueueEmptyException{
		if(size==0){
			throw new QueueEmptyException();
		}
		T temp= front.data;
		front=front.next;
		if(size==1){
			rear=null;
		}
		size--;
		return temp;
	}
	
}
