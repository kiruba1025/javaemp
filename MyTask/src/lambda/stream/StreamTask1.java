package lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTask1 {

	public static void main(String[] args) {
		List<Object> alt=new ArrayList<>();
		alt.add( 1);
		alt.add( "kiruba");
		alt.add( 50.0);
		alt.add( true);
		//alt.stream().filter(n->!n.equals("kiruba")).forEach(System.out::println);
		List<Object> result=alt.stream().filter(n->!n.equals(1)).collect(Collectors.toList());
		System.out.println(result);  
	}
}
