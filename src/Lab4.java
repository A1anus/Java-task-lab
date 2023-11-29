import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class Lab4 {
	public static void main(String[] args) {
		ArrayAverage();
		fopenAndCopy();
		CustomStack<Integer> stack = new CustomStack<>(2);
		stack.push(10);
		System.out.println(stack.pop());
	}
	public static void ArrayAverage() {
		int[] arr = {1, 2, 3, 4, 5};
		double sum = 0;
		int i;

		try {
			for (i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			sum = (double) sum / i;
			System.out.println("Average = "+sum);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Выход за массив");
		} catch (NullPointerException e) {
			System.out.println("Не является числом");
		}

	}
	public static void fopenAndCopy() {
		String sourceFile = "/Users/alantolparov/Java-task-lab/IdeaProjects/Task4/src/cat.txt";
		String destinationFile = "gat.txt";

		try {
			Path sourcePath = Paths.get(sourceFile);
			Path destinationPath = Paths.get(destinationFile);

			// Проверяем существование исходного файла
			if (!Files.exists(sourcePath)) {
				System.err.println("Исходный файл не существует");
				return;
			}

			// Проверяем существование целевого файла и, если он существует, удаляем его
			if (Files.exists(destinationPath)) {
				Files.delete(destinationPath);
				System.out.println("Старый целевой файл удален");
			}

			// Копируем файл
			Files.copy(sourcePath, destinationPath);
			System.out.println("Файл успешно скопирован");
		} catch (IOException e) {
			System.err.println("Произошла ошибка ввода-вывода: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

class CustomEmptyStackException extends RuntimeException {
	public CustomEmptyStackException(String message) {
		super(message);
	}

}
class CustomStack<T> {
	private T[] arr;
	private int top;

	CustomStack(int capacity) {
		arr = (T[]) new Object[capacity];
		top = -1;
	}

	public void push(T item) {
		if (top == arr.length - 1) {
			throw new IllegalStateException("Stack is full");
		}
		arr[++top] = item;
	}

	public T pop() {
		if (isEmpty()) {
			throw new CustomEmptyStackException("Stack is empty");
		}
		return arr[top--];
	}

	public T peek() {
		if (top == -1) {
			throw new IllegalStateException("Stack is empty");
		}
		return arr[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return (top + 1);
	}


}
