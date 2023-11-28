public class Algos {

		public static int switchNums(int num1, int num2) {
			// Преобразуем числа в строки для удобства манипуляций с символами
			String strNum1 = String.valueOf(num1);
			String strNum2 = String.valueOf(num2);

			// Получаем длины строк
			int len1 = strNum1.length();
			int len2 = strNum2.length();

			// Находим минимальную из длин
			int minLength = Math.min(len1, len2);

			// Создаем массивы символов для чисел
			char[] charArray1 = strNum1.toCharArray();
			char[] charArray2 = strNum2.toCharArray();

			// Переключаем цифры в числах
			for (int i = 0; i < minLength; i++) {
				char temp = charArray1[i];
				charArray1[i] = charArray2[i];
				charArray2[i] = temp;
			}

			// Объединяем символы обратно в строки и преобразуем их в числа
			int switchedNum1 = Integer.parseInt(new String(charArray1));
			int switchedNum2 = Integer.parseInt(new String(charArray2));

			// Возвращаем сумму переключенных чисел
			return switchedNum1 + switchedNum2;
		}

		public static void main(String[] args) {
			System.out.println(switchNums(519, 723));    // ➞ 953
			System.out.println(switchNums(491, 3912));   // ➞ 9942
			System.out.println(switchNums(6274, 71259)); // ➞ 77659
		}


}
