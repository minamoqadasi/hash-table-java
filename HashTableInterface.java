public interface HashTableInterface<Key, Value> {

	public void put(Key k, Value v);
	public void remove(Key k);
	public Value get(Key k);
	public boolean contains(Key k);
	public boolean isEmpty();
	public int size();

}