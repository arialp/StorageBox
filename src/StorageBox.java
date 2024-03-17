/**
 * A generic storage box class that uses an array to store elements.
 *
 * @param <T> The type of elements to be stored in the storage box.
 */

public class StorageBox<T> {
	private final T[] storageBox;
	private int capacity;
	private int usedSpace;

	/**
	 * Constructor for the StorageBox class. Initializes the storageBox array with a default capacity of 5.
	 */
	@SuppressWarnings("unchecked")
	public StorageBox() {
		this.usedSpace = 0;
		this.capacity = 5;
		storageBox = (T[])new Object[this.capacity];
	}

	/**
	 * Constructor for the StorageBox class. Initializes the storageBox array with a specified capacity.
	 *
	 * @param customCap The capacity of the storageBox array.
	 */
	@SuppressWarnings("unchecked")
	public StorageBox(int customCap) throws CustomExceptions.InvalidCapacityException {
		if (customCap>0) {
			this.usedSpace = 0;
			this.capacity = customCap;
			storageBox = (T[])new Object[customCap];
			return;
		}
		throw new CustomExceptions.InvalidCapacityException("Capacity must be greater than 0.");
	}

	/**
	 * Adds an element to the storageBox array if there is space available.
	 *
	 * @param t The element to be added to the storageBox array.
	 */
	public void set(T t) throws CustomExceptions.StorageFullException {
		if (this.usedSpace<this.capacity) {
			storageBox[this.usedSpace] = t;
			this.usedSpace++;
			System.out.println("Element \""+t+"\" added.");
			return;
		}
		throw new CustomExceptions.StorageFullException("Cannot add element. Storage is full.");
	}

	/**
	 * Adds an element to the storageBox array at a specified index if there is space available.
	 *
	 * @param t The element to be added to the storageBox array.
	 * @param index The index at which the element is to be added.
	 */
	public void set(T t, int index) throws CustomExceptions.StorageFullException, CustomExceptions.IndexOutOfBoundsException {
		if (index>=0 && index<this.capacity) {
			if (this.usedSpace<this.capacity) {
				System.arraycopy(storageBox, index, storageBox, index+1, this.usedSpace-index);
				storageBox[index] = t;
				this.usedSpace++;
				System.out.println("Element \""+t+"\" added at index "+index+".");
			} else {
				throw new CustomExceptions.StorageFullException("Cannot add element. Storage is full.");
			}
		} else {
			throw new CustomExceptions.IndexOutOfBoundsException("Index out of bounds.");
		}
	}

	/**
	 * Retrieves the last element in the storageBox array.
	 *
	 * @return the last element or null if the storage box is empty.
	 */
	public T get() throws CustomExceptions.StorageEmptyException {
		if (this.usedSpace>0) {
			return storageBox[this.usedSpace-1];
		} else {
			throw new CustomExceptions.StorageEmptyException("Storage is empty. No element to get.");
		}
	}

	/**
	 * Retrieves the element at the specified index from the storageBox array.
	 *
	 * @param index The index of the element to be retrieved.
	 *
	 * @return The element at the specified index or null if the index is out of bounds.
	 */
	public T get(int index) throws CustomExceptions.IndexOutOfBoundsException {
		if (index>=0 && index<this.usedSpace) {
			return storageBox[index];
		}
		throw new CustomExceptions.IndexOutOfBoundsException("Index out of bounds.");
	}

	/**
	 * Retrieves the capacity of the StorageBox object.
	 *
	 * @return An integer representing the capacity of the object.
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Retrieves the used space of the StorageBox object.
	 *
	 * @return An integer representing the used space of the object.
	 */
	public int getUsedSpace() {
		return this.usedSpace;
	}

	/**
	 * Retrieves the StorageBox array.
	 *
	 * @return Array of StorageBox object.
	 */
	public T[] getStorageBox() {
		return this.storageBox;
	}

	/**
	 * Removes the last element from the storageBox array.
	 */
	public void remove() throws CustomExceptions.StorageEmptyException {
		if (this.usedSpace>0) {
			storageBox[this.usedSpace-1] = null;
			this.usedSpace--;
			System.out.println("Last element removed.");
			return;
		}
		throw new CustomExceptions.StorageEmptyException("Storage is empty. No element to remove.");
	}

	/**
	 * Removes the first occurrence of an element from the storageBox array starting from index 0.
	 *
	 * @param t The element to be removed from the storageBox array.
	 */
	public void remove(T t) throws CustomExceptions.ElementNotFoundException {
		for (int i = 0;i<this.usedSpace;i++) {
			if (storageBox[i].equals(t)) {
				System.arraycopy(storageBox, i+1, storageBox, i, this.usedSpace-i-1);
				storageBox[this.usedSpace-1] = null;
				this.usedSpace--;
				System.out.println("Element \""+t+"\" removed.");
				return;
			}
		}
		throw new CustomExceptions.ElementNotFoundException("Element not found.");
	}

	/**
	 * Removes the element at a specified index from the storageBox array.
	 *
	 * @param index The index at which the element is to be removed.
	 * @param byIndex A dummy parameter to differentiate this method from the one that removes by value.
	 */
	public void remove(int index, boolean byIndex) throws CustomExceptions.IndexOutOfBoundsException {
		if (byIndex && index>=0 && index<this.usedSpace) {
			System.arraycopy(storageBox, index+1, storageBox, index, this.usedSpace-index-1);
			storageBox[this.usedSpace-1] = null;
			this.usedSpace--;
			System.out.println("Element at index "+index+" removed.");
			return;
		}
		throw new CustomExceptions.IndexOutOfBoundsException("Index out of bounds.");
	}
}