class QueueUsingArray1 {
private int data[];
private int front;
private int rear;
private int size;

public QueueUsingArray1(){
	data=new int[10];
	front=-1;
	rear=-1;
	size=0;
}
public QueueUsingArray1(int capacity){
	data=new int[capacity];
	front=-1;
	rear=-1;
	size=0;
}
int size(){
	return size;
}
boolean isEmpty(){
	return size==0;
}

int front() throws QueueEmptyException{
	if(size==0){
		// agar khali queue hai to throw exception 
		throw new QueueEmptyException();
	}
	
	return data[front];
}
 void enqueue(int element) throws QueueFullException{
	 // if full ho gya to
	 if(size==data.length){
		 throw new QueueFullException();
	 }
	 
	 if(size==0){
		 front=0;
	 }
	 size++;
	 
	 rear=(rear+1) % data.length;
//	 rear++;
// agar index valid nahi hai 
//	 if(rear==data.length){
//		 rear=0;
//	 }
	 data[rear]=element;
 }
 
 int dequeue() throws  QueueEmptyException{
	 if(size==0){
			// agar khali queue hai to throw exception 
			throw new QueueEmptyException();
		}
	int temp=data[front];
	front++;
	if(front==data.length){
		front=0;
	}
	size--;
	// agar size 0 ho gya to
	if(size==0){
		front=-1;
		rear=-1;
	}
	return temp;
	 
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

public class QueueUse1 {

	public static void main(String[] args) {
		QueueUsingArray1  queue= new  QueueUsingArray1();
		for(int i=1;i<=5;i++){
			try{
				queue.enqueue(i);
			}
			catch(QueueFullException e){
				
			}
			
			
		}
		while(!queue.isEmpty()){
			try{
				System.out.println(queue.dequeue());
			}catch(QueueEmptyException e){
				
			}
		}

	}

	}


