import java.util.HashMap;

public class Maps {
	public static void main(String[] args) {
		
		HashMap<String, Integer> empIds = new HashMap<>(); //<> diamond operator

		empIds.put("John", 12345);
		empIds.put("Carl", 54321);
		empIds.put("Jerry", 8675309);

		System.out.println(empIds);

		System.out.println(empIds.get("Carl"));
		//System.out.println(empIds.containsKey(/*key(hint: name)*/));
		System.out.println(empIds.containsKey("John"));

		//System.out.println(empIds.containsValue(/*value*/));
		System.out.println(empIds.containsValue(54321));
		
		
		//empIds.put(key, value)
		//empIds.replace(key, oldValue, newValue)
		empIds.putIfAbsent(key, value)

	}
}