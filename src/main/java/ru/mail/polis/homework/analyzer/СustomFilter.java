package ru.mail.polis.homework.analyzer;

public class �ustomFilter implements TextAnalyzer {

    @Override
    public boolean getResult(String text) {
        if (text.toLowerCase().equals(text)) {
            return true;
        }
        return false;
    }

    @Override
    public FilterType getFilterType() {

        return FilterType.CUSTOM;
    }
}
