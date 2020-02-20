class QueueUsingArrayDouble {
private int data[];
private int front;
private int rear;
private int size;

public QueueUsingArrayDouble(){
	data=new int[10];
	front=-1;
	rear=-1;
	size=0;
}
public QueueUsingArrayDouble(int capacity){
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
		 doubleCapacity();
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
 private void  doubleCapacity(){
int temp[]=data;
     data=new int[2*temp.length];
      int index=0;
for(int i=front ; i< temp.length ;i++){
	data[index]=temp[i];
	index++;
	}
	
for(int i=0;i<=front-1;i++){
	data[index] =temp[i];
	index++;
}
front=0;
rear=temp.length-1;
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

public class QueueUseDoubleCapacity {

	public static void main(String[] args) {
		QueueUsingArrayDouble  queue= new  QueueUsingArrayDouble(3);
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


