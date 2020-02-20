import java.util.Stack;
public class SortStack {

	public static void sortStack(Stack<Integer> input){
		Stack<Integer> tmpstack = new Stack<Integer>();
		while(!input.isEmpty()){
			int temp=input.pop();
			while(!tmpstack.isEmpty() && tmpstack.peek() < temp){
				
			input.push(tmpstack.pop());	
				
				
				
			}
			tmpstack.push(temp);
			
			
		}
	 while(!tmpstack.isEmpty()){
		System.out.print(tmpstack.pop()+" "); 
		 
		 
		 
	 }
		
	}
	
	
	public static void main(String[] args) {
	 Stack<Integer> stack=new Stack<>();
	  stack.add(34); 
	  stack.add(3); 
	  stack.add(31); 
	  stack.add(98); 
	  stack.add(92); 
	  stack.add(23);
	  sortStack(stack);
	 
	 
		
		}

}
