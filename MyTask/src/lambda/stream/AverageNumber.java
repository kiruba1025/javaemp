package lambda.stream;

import java.util.Scanner;

public class AverageNumber {

	public static void main(String[] args) {
		Scanner number = new Scanner(System.in);
		System.out.println("Enter List");
        int num=number.nextInt();
        System.out.println("Enter number");
        int i = 1;
        for(int j=0;j<num;j++) {
        int y=number.nextInt();
        i *=y;
        
	}
        System.out.println(i);
        if(i==3 || i==5){
            System.out.println("FizzBuzz");
        }
        else if(i!=5){
             System.out.println("Fizz");
        }
       else if(i!=3){
           System.out.println("Buzz");
       }
       else {
           System.out.println(i);
       }
	}
}
		
//		Scanner number = new Scanner(System.in);
//		System.out.println("Enter List");
//		int num=number.nextInt();
//		System.out.println("Enter number");
//		int x = 0;
//		for(int i=0;i<num;i++) {
//		int	n=number.nextInt();
//		
//		  x*=n;
//		  
//		}
//		
//		System.out.println("Average"+ " "+ x/num);
//	}
//}
