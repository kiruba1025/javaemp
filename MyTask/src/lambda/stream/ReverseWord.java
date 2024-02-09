package lambda.stream;

class  Word{
	String word = "kiruba";
	String word1[]={"kirubaa","madhavan"};

    int length=word.length();

void display() {
	
	for (int i = length - 1; i >= 0; i--) {
		 
		System.out.print(word.charAt(i));
	}	
}
void display1() {
	
	
		for (int i = word1[0].length() - 1; i>=0; i--) {
		
		System.out.print(word1[0].charAt(i));
	}
}
}

public class ReverseWord {
public static void main(String[] args) {
	Word w =new Word();
	//w.display();
	w.display1();
}
}
