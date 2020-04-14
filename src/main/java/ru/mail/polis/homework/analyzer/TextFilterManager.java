package ru.mail.polis.homework.analyzer;


import java.util.Arrays;

/**
 * ������� �������� ������� ���������� ������������.
 * ���� ����������� ��� ���� ������������ ��������
 * 1) ������ ��� ������� ������� ������� (����� �������� ��� ��������) (TOO_LONG)
 * 2) ������ ��� ����� (���������� ������ ������ ����, ������� �� ������ ���� � ������) (SPAM)
 * 3) ������ ��� ������� � ������� ��������. (� ������ �� ������ ���� ����� �������:
 * "=(", ":(", ":|" (NEGATIVE_TEXT)
 * + ������� ����� ���� ������ (CUSTOM)
 * <p>
 * ����� TextFilterManager ������ ��������� ��� �������, ������� ���������� ��� � ������������,
 * � ��� ������� ������ ����� ����� analyze ������ �������� ������ "��������" ������,
 * ���� �� ���� �� ������, �� ���������� ��� GOOD.
 * �������������� �������: ����� ���� ����� �������� ������ ���������
 * (SPAM, TOO_LONG, NEGATIVE_TEXT, CUSTOM - � ����� �������) � ���������� ��� � ������������ �����������.
 * ������������� ������� ����� � ������� �������
 * Arrays.sort(filter, (filter1, filter2) -> {
 * if (filter1 < filter2) {
 * return -1;
 * } else if (filter1 == filter2) {
 * return 0;
 * }
 * return 1;
 * }
 * ��� ������ ��������� ����� �������� ������ ���� ���������� �����-�� �������������� ���������� �������
 * <p>
 * 2 ����� ( + 2 ����� �� ��� ���������)
 * ����� 15 ������ + 2 ��������������
 */
public class TextFilterManager {
    private TextAnalyzer[] filters;

    /**
     * ��� ������ � ������ ��������� �������, ����� ������������ ���� for-each
     * ������� ��������, ��� ��� �� ������ �� �����, ����� ��������� ��� ������� ��������, ����� ������ ��,
     * ��� � ��� ���������� ��������� TextAnalyzer
     */
    public TextFilterManager(TextAnalyzer[] filters) {
        this.filters = filters.clone();

        Arrays.sort(this.filters, (filter1, filter2) -> {
            int priority1 = filter1.getFilterType().getPriority();
            int priority2 = filter2.getFilterType().getPriority();
            if (priority1 < priority2) {
                return -1;
            } else if (priority1 == priority2) {
                return 0;
            }
            return 1;
        });
    }

    /**
     * ���� ���������� ����� ������ �� ���������, �� ��� ��������, ��� �� ���� ������ �� ��������
     */
    public FilterType analyze(String text) {

        if (text == null || text.isEmpty()) {
            return FilterType.GOOD;
        }

        for (TextAnalyzer filter : filters) {
            if (filter.filterIsPassed(text)) {
                return filter.getFilterType();
            }
        }

        return FilterType.GOOD;
    }
}
