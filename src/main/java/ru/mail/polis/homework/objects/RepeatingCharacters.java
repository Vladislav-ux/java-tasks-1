package ru.mail.polis.homework.objects;

import java.util.Objects;

/**
 * Нужно найти символ, который встречается подряд в строке чаще всего, и указать количество повторений.
 * Если более одного символа с максимальным значением, то нужно вернуть тот символ,
 * который первый встречается в строчке
 * Если строка пустая или null, то вернуть null
 * Пример abbasbdlbdbfklsssbb -> (s, 3)
 */
public class RepeatingCharacters {

    public static Pair<Character, Integer> getMaxRepeatingCharacters(String str) {

        if ((str == null) || (str.length() == 0)) {
            return null;
        }

        Pair<Character, Integer> answer = new Pair<>('a', 0);
        char charValue;
        int repetitions;
        int index = 0;

        while (index < str.length()) {
            charValue = str.charAt(index++);
            repetitions = 1;

            while (index < str.length() && str.charAt(index) == charValue) {
                index++;
                repetitions++;
            }

            if (answer.getSecond() < repetitions) {
                answer = new Pair<>(charValue, repetitions);
            }
        }
        return answer;
    }

    public static class Pair<T, V> {
        private final T first;
        private final V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

    }
}
