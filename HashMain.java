public class HashMain {

	public static void main(String[] args) {

		// complete all TODO methods
		// add 5 or more items to the table
		// demo all methods

		HashTable<Integer, String> hash = new HashTable<>(5);

		hash.put(50, "A");
		hash.put(21, "B");
		hash.put(76, "C");
		hash.put(4, "D");
		hash.put(32, "E");

		System.out.println("Size: " + hash.size());

		hash.remove(4);
		System.out.println("Size: " + hash.size());

		System.out.println("Get index 50: " + hash.get(50));
		System.out.println("Get index 4: " + hash.get(4));

		System.out.println("Does the Hash Table contain index " + 21 + "? " + hash.contains(21));

		System.out.println("Is the table empty? " + hash.isEmpty());
		System.out.println("Size: " + hash.size());

		hash.remove(50);
		hash.remove(21);
		hash.remove(76);
		hash.remove(32);

		System.out.println("Is the table empty? " + hash.isEmpty());

		System.out.println("Size: " + hash.size());

	}

}
