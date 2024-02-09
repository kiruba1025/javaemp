package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
	int no;
	String name;
	int salary;
	
	public StreamDemo(int no,String name, int salary) {
		this.no=no;
		this.name=name;
		this.salary=salary;
		
	}
	

public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


public static void main (String[] args) {
	int[] ar = {8,5,7,4,3,8,2};
//	IntStream s= Arrays.stream(ar).sorted();
//	s.forEach(no->System.out.println(no));
	
	Arrays.stream(ar) //Intermediate Operation
	.sorted()       //Intermediate Operation
	.forEach(System.out::println);// Terminal
	
	
	
//	List<String> strList = Arrays.asList("kiruba", "Deepa", "kalai", "", "madhavan", "kavidhas"); 
//	strList.stream()
//	.collect(Collectors.toList());
//	System.out.println(strList);
	
//List<Integer> inte= Arrays.asList(0,1,2,3);
//Stream<Integer> fiter =inte.stream().filter(y -> y % 2 != 0);
//System.out.println(inte);
	
//	List<Integer> inte = Arrays.asList(0, 1, 2, 3);
//    List<Integer> filteredList = inte.stream()
//            .filter(y -> y % 2 == 0) 
//            .collect(Collectors.toList());
//    
//    System.out.println(filteredList);
	
	List<StreamDemo> employeesList = Arrays.asList(
            new StreamDemo(1, "Deepa", 100),
            new StreamDemo(2, "Kalai", 100),
            new StreamDemo(3, "Kavidhas", 200),
            new StreamDemo(4, "Madhavan", 200),
            new StreamDemo(5, "Najeela", 300),
            new StreamDemo(6, "Radhika", 300),
            new StreamDemo(7, "kiruba",400)
            
            
            
  
        );
	
	

List<Integer> distinctSalaries = employeesList.stream()
.map( e -> e.getSalary() )
.distinct()
.collect(Collectors.toList());

System.out.println(distinctSalaries);
}





}

