package ru.mail.polis.homework.analyzer;

/**
 * ���� �������� (2 �����)
 */
public enum FilterType {
    SPAM(0),
    TOO_LONG(1),
    NEGATIVE_TEXT(2),
    CUSTOM(3),
    GOOD(4);

    int priority;

    FilterType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
