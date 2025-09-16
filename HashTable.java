public class HashTable<Key extends Comparable<Key>, Value> implements HashTableInterface<Key,Value> {

	private HashItem[] hashTable; // the array that stores the data
	private int size; // the number of items stored in the table
	private int capacity; // the length of the array

	// Why can’t we use Java Generics for our key/val pair in the HashItem class?
	// Why is the class static? Generic arrays are prohibited by the language
	// https://www.ibm.com/developerworks/java/library/j-jtp01255/index.html
	private static class HashItem {
		private final Object key;
		private Object val;

		public HashItem(Object key, Object val) {
			this.key = key;
			this.val = val;
		}
	}

	// constructor
	public HashTable(int capacity) {
		hashTable = new HashItem[capacity];
		// member     = parameter
		this.capacity = capacity;
		size = 0; // optional
	}

	// Hash function
	private int hash(Key k) {
		return (k.hashCode() & 0x7FFFFFFF) % capacity;
	}



	// inserting a pair of value and key to hash table
	public void put(Key k, Value v) {
		if(k == null || v == null) {
			System.out.println("Unable to insert, key or value is null!");
			return;
		}

		// generate an index using the hash function
		int index = hash(k);

		// if value already exists
		if(hashTable[index] != null) {
			// Collision occured!!
			System.out.println("Collision occured at index: " + index);
			System.out.println("WARNING: value will be overwritten!!!");
			hashTable[index].val = v;
		}
		else {
			// did not collide, continue to insert if there is room
			if(size < capacity) {
				hashTable[index] = new HashItem(k,v); // create a new HashItem
				size++;
			}
			else {
				System.out.println("Table is full, unable to insert");
				// another option would be to resize the array, copy contents of old array into new array and insert item
			}
		}
	}



	// TODO (similar technique as put(..))
	public void remove(Key k) {
		if(k == null) {
			System.out.println("Unable to remove, key is null!");
			return;
		}
		// generate an index using the hash function
		// where to look
		int index = hash(k);
		// access the item/array at the index and store it in the Table
		// take what is in that index
		HashItem item = hashTable[index];
		// now remove
		if(item != null) {
			hashTable[index] = null;
			System.out.println("Item at index " + index + " was removed.");
			size--;
		}

	}



	// TODO (similar technique as put(..))
	public Value get(Key k) {
		if(k == null) {
			System.out.println("Unable to get, key is null!");
			return null;
		}
		// generate an index using the hash function
		// where to look
		int index = hash(k);
		// access the item/array at the index and store it in the Table
		// take what is in that index
		HashItem item = hashTable[index];
		// if found
		if(item != null && item.key.equals(k)) {
			return (Value) item.val;
			// OR: return (Value) hashTable[index].val;
		}
		// else key not found
		return null;
	}



	// TODO (similar technique as put(..))
	public boolean contains(Key k) {
		if(k == null) {
			System.out.println("The key doesn't exist.");
			return false;
		}
		// generate an index using the hash function
		// where to look
		int index = hash(k);
		// access the item/array at the index and store it in the Table
		// take what is in that index
		HashItem item = hashTable[index];
		// if found
		return true;
	}



	// TODO
	public boolean isEmpty(){
		return size == 0;
	}



	// TODO
	public int size(){
		return size;
	}

}
