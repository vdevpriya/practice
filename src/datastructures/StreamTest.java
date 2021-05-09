package datastructures;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> values = Arrays.asList(1,2,3,4);
		List<Integer> t;
		values.stream().filter(i -> {
			System.out.println(i);
			return true;
		});
		
		//t.forEach(System.out::println);
	}

}
