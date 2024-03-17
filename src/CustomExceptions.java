public class CustomExceptions {
	public static class InvalidCapacityException extends Exception {
		InvalidCapacityException(String message) {
			super(message);
		}
	}
	public static class StorageEmptyException extends Exception {
		StorageEmptyException(String message) {
			super(message);
		}
	}
	public static class StorageFullException extends Exception {
		StorageFullException(String message) {
			super(message);
		}
	}
	public static class ElementNotFoundException extends Exception {
		ElementNotFoundException(String message) {
			super(message);
		}
	}
	public static class IndexOutOfBoundsException extends Exception {
		IndexOutOfBoundsException(String message) {
			super(message);
		}
	}
}
