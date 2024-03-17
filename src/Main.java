public class Main {
	public static void main(String[] args) {
		System.out.println("\nStorageBox Test:\n----------------\nRunning tests...\n");
		try {
			StorageBox<Integer> defaultBox = new StorageBox<>();
			StorageBox<Integer> customBox = new StorageBox<>(10);
			StorageBox<Integer> emptyBox = new StorageBox<>();

			// Test adding elements
			defaultBox.set(10);

			// Test adding at a specific index
			defaultBox.set(20, 0);

			// Test removing the last element
			defaultBox.remove();

			// Test removing a specific element
			defaultBox.set(30);
			defaultBox.remove(20);

			// Test removing at a specific index
			defaultBox.set(40);
			defaultBox.remove(0, true);

			// Test retrieving the last element
			defaultBox.set(50);
			System.out.println("Last element: "+defaultBox.get());

			// Test retrieving an element at a specific index
			System.out.println("Element at index 0: "+defaultBox.get(0));

			// Test adding an element when the storage is full
			try {
				for (int i = 0;i<defaultBox.getCapacity();i++) {
					defaultBox.set(i);
				}
				defaultBox.set(60); // This should throw a StorageFullException
			} catch (CustomExceptions.StorageFullException e) {
				System.out.println("Caught StorageFullException: "+e.getMessage());
			}

			// Test removing an element when the storage is empty
			try {
				emptyBox.remove(); // This should throw a StorageEmptyException
			} catch (CustomExceptions.StorageEmptyException e) {
				System.out.println("Caught StorageEmptyException: "+e.getMessage());
			}

			// Test removing a non-existent element
			try {
				defaultBox.remove(100); // This should throw an ElementNotFoundException
			} catch (CustomExceptions.ElementNotFoundException e) {
				System.out.println("Caught ElementNotFoundException: "+e.getMessage());
			}

			// Test removing at an out-of-bounds index
			try {
				defaultBox.remove(defaultBox.getCapacity()+1, true); // This should throw an IndexOutOfBoundsException
			} catch (CustomExceptions.IndexOutOfBoundsException e) {
				System.out.println("Caught IndexOutOfBoundsException: "+e.getMessage());
			}

			// Test retrieving an element at an out-of-bounds index
			try {
				defaultBox.get(defaultBox.getCapacity()+1); // This should throw an IndexOutOfBoundsException
			} catch (CustomExceptions.IndexOutOfBoundsException e) {
				System.out.println("Caught IndexOutOfBoundsException: "+e.getMessage());
			}

			// Test adding with a negative index
			try {
				defaultBox.set(70, -1); // This should throw an IndexOutOfBoundsException
			} catch (CustomExceptions.IndexOutOfBoundsException e) {
				System.out.println("Caught IndexOutOfBoundsException: "+e.getMessage());
			}

			// Test adding with an index greater than the capacity
			try {
				defaultBox.set(80, defaultBox.getCapacity()+1); // This should throw an IndexOutOfBoundsException
			} catch (CustomExceptions.IndexOutOfBoundsException e) {
				System.out.println("Caught IndexOutOfBoundsException: "+e.getMessage());
			}

			// Test adding with a negative capacity
			try {
				StorageBox<Integer> negativeCapacityBox = new StorageBox<>(-1); // This should throw an InvalidCapacityException
			} catch (CustomExceptions.InvalidCapacityException e) {
				System.out.println("Caught InvalidCapacityException: "+e.getMessage());
			}
			System.out.println("\nTests complete. No unexpected exceptions.");
		} catch (Exception e) {
			System.out.println("Unexpected exception: "+e.getMessage());
		}
		System.out.println("-----------------------\nEnd of StorageBox Test.\n");
	}
}
