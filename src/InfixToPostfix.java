import java.util.*;
import java.util.Stack;
public class InfixToPostfix {
	private static int get(char a) {
		// TODO Auto-generated method stub
		if(a=='+'||a=='-')
			return 1;
		else if(a=='/'||a=='*')
			return 2;
		else
			return 0;
		
	}
	private static int num(String ans) {
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<ans.length();i++) {
			if(ans.charAt(i)>='0'&&ans.charAt(i)<='9') {
				s.push(ans.charAt(i)-'0');
			}else {
				int a = s.pop();
				int b = s.pop();
				if(ans.charAt(i)=='+')
					s.push(b+a);
				else if(ans.charAt(i)=='-')
					s.push(b-a);
				else if(ans.charAt(i)=='*')
					s.push(b*a);
				else if(ans.charAt(i)=='/')
					s.push(b/a);
				else 
					s.push(0);
				
			}
		}
		return s.pop(); 
	}
 
	
	public static void infixToPostfix(String input){
		String ans = "";

		Stack<Character> s = new Stack<>();
		for(int i=0;i<input.length();i++) {
			char a = input.charAt(i);
			if(a=='('||a==')') {
				if(a=='(')
					s.push(a);
				else {
					char ch = s.pop();
					while(ch!='(') {
					ans = ans + ch;
					ch = s.pop();
					}
				}
			}
			else if(!(a>='0'&&a<='9')) {
				if(!s.isEmpty()&&s.peek()!='(') {
				char ch = s.peek();
				while(!(get(a)>get(ch))) {
					ch = s.pop();
					ans=ans+ch;
					if(!s.isEmpty()&&s.peek()!='(')
						ch = s.peek();
					else
						break;
					
				}
				}
				s.push(a);
				
			}else {
				ans = ans+a;
			}
		}
		while(!s.isEmpty()) {
			ans = ans + s.pop();
		}
		System.out.println(ans);
		int a = num(ans);
		System.out.println(a);
	}

	
	
	public static void main(String[] args) {
		 Scanner s =new Scanner(System.in);
		String str=s.nextLine();
		infixToPostfix(str);
		
	 
		
		
	}

}
