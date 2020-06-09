package com.home.server;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageConverter {

    private final Pattern cyrillic = Pattern.compile("^[а-яА-Я]+$");
    private final Pattern latin = Pattern.compile("^[a-zA-Z]+$");

    public String layoutChange(String message) {
        Matcher mCyrillic = cyrillic.matcher(message.replaceAll("[^A-Za-zА-Яа-я]", ""));
        Matcher mLatin = latin.matcher(message.replaceAll("[^A-Za-zА-Яа-я]", ""));
        if (mCyrillic.find() && !mLatin.find()) {
            return replaceToLatin(message);
        } else if (!mCyrillic.find() && mLatin.find()) {
            return replaceToCyrillic(message);
        }
        return "null";
    }

    private String replaceToLatin(String message) {
        String oldMessage = new String(message);
        String str = message.toLowerCase();

        str = str.replace('й', 'q');
        str = str.replace('ц', 'w');
        str = str.replace('у', 'e');
        str = str.replace('к', 'r');
        str = str.replace('е', 't');
        str = str.replace('н', 'y');
        str = str.replace('г', 'u');
        str = str.replace('ш', 'i');
        str = str.replace('щ', 'o');
        str = str.replace('з', 'p');
        str = str.replace('х', '[');
        str = str.replace('ъ', ']');
        str = str.replace('ф', 'a');
        str = str.replace('ы', 's');
        str = str.replace('в', 'd');
        str = str.replace('а', 'f');
        str = str.replace('п', 'g');
        str = str.replace('р', 'h');
        str = str.replace('о', 'j');
        str = str.replace('л', 'k');
        str = str.replace('д', 'l');
        str = str.replace('ж', ';');
        str = str.replace('э', '\'');
        str = str.replace('я', 'z');
        str = str.replace('ч', 'x');
        str = str.replace('с', 'c');
        str = str.replace('м', 'v');
        str = str.replace('и', 'b');
        str = str.replace('т', 'n');
        str = str.replace('ь', 'm');
        str = str.replace('б', ',');
        str = str.replace('ю', '.');

        char ch;
        char ch2;
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(message.charAt(i))) {
                ch = str.toUpperCase().charAt(i);
                list.add(ch);
            }
            if (Character.isLowerCase(message.charAt(i))) {
                ch2 = str.toLowerCase().charAt(i);
                list.add(ch2);
            }
            if (message.charAt(i) == ' ') {
                list.add(' ');
            }
            if (message.charAt(i) == '}') {
                list.add('ъ');
            }
            if (message.charAt(i) == '{') {
                list.add('х');
            }
            if (message.charAt(i) == ':') {
                list.add('ж');
            }
            if (message.charAt(i) == '"') {
                list.add('э');
            }
            if (message.charAt(i) == '<') {
                list.add('б');
            }
            if (message.charAt(i) == '>') {
                list.add('ю');
            }
            if (message.charAt(i) == '1') {
                list.add('1');
            }
            if (message.charAt(i) == '2') {
                list.add('2');
            }
            if (message.charAt(i) == '3') {
                list.add('3');
            }
            if (message.charAt(i) == '4') {
                list.add('4');
            }
            if (message.charAt(i) == '5') {
                list.add('5');
            }
            if (message.charAt(i) == '6') {
                list.add('6');
            }
            if (message.charAt(i) == '7') {
                list.add('7');
            }
            if (message.charAt(i) == '8') {
                list.add('8');
            }
            if (message.charAt(i) == '9') {
                list.add('9');
            }
            if (message.charAt(i) == '0') {
                list.add('0');
            }
            if (message.charAt(i) == '@') {
                list.add('@');
            }
            if (message.charAt(i) == '#') {
                list.add('#');
            }
            if (message.charAt(i) == '$') {
                list.add('$');
            }
            if (message.charAt(i) == '%') {
                list.add('%');
            }
            if (message.charAt(i) == '^') {
                list.add('^');
            }
            if (message.charAt(i) == '&') {
                list.add('&');
            }
            if (message.charAt(i) == '?') {
                list.add('?');
            }
            if (message.charAt(i) == '*') {
                list.add('*');
            }
            if (message.charAt(i) == '(') {
                list.add('(');
            }
            if (message.charAt(i) == ')') {
                list.add(')');
            }
            if (message.charAt(i) == '-') {
                list.add('-');
            }
            if (message.charAt(i) == '=') {
                list.add('=');
            }
            if (message.charAt(i) == '/') {
                list.add('/');
            }
            if (message.charAt(i) == '+') {
                list.add('+');
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Character list1 : list) {
            stringBuilder.append(list1);
        }
        int length = oldMessage.length() - stringBuilder.length();
        return stringBuilder + oldMessage.substring(message.length() - length);
    }


    private String replaceToCyrillic(String message) {
        String oldMessage = new String(message);
        String str = message.toLowerCase();

        message = message.replace(',', '<');
        message = message.replace('.', '>');
        message = message.replace(';', ':');
        message = message.replace('\'', '"');
        message = message.replace('[', '{');
        message = message.replace(']', '}');

        str = str.replace('q', 'й');
        str = str.replace('w', 'ц');
        str = str.replace('e', 'у');
        str = str.replace('r', 'к');
        str = str.replace('t', 'е');
        str = str.replace('y', 'н');
        str = str.replace('u', 'г');
        str = str.replace('i', 'ш');
        str = str.replace('o', 'щ');
        str = str.replace('p', 'з');
        str = str.replace('a', 'ф');
        str = str.replace('s', 'ы');
        str = str.replace('d', 'в');
        str = str.replace('f', 'а');
        str = str.replace('g', 'п');
        str = str.replace('h', 'р');
        str = str.replace('j', 'о');
        str = str.replace('k', 'л');
        str = str.replace('l', 'д');
        str = str.replace('z', 'я');
        str = str.replace('x', 'ч');
        str = str.replace('c', 'с');
        str = str.replace('v', 'м');
        str = str.replace('b', 'и');
        str = str.replace('n', 'т');
        str = str.replace('m', 'ь');
        str = str.replace('<', 'б');
        str = str.replace('>', 'ю');
        str = str.replace(':', 'ж');
        str = str.replace('"', 'э');
        str = str.replace('{', 'х');
        str = str.replace('}', 'ъ');

        char ch;
        char ch2;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(message.charAt(i))) {
                ch = str.toUpperCase().charAt(i);
                list.add(ch);
            }
            if (Character.isLowerCase(message.charAt(i))) {
                ch2 = str.toLowerCase().charAt(i);
                list.add(ch2);
            }
            if (message.charAt(i) == ' ') {
                list.add(' ');
            }
            if (message.charAt(i) == '}') {
                list.add('ъ');
            }
            if (message.charAt(i) == '{') {
                list.add('х');
            }
            if (message.charAt(i) == ':') {
                list.add('ж');
            }
            if (message.charAt(i) == '"') {
                list.add('э');
            }
            if (message.charAt(i) == '<') {
                list.add('б');
            }
            if (message.charAt(i) == '>') {
                list.add('ю');
            }
            if (message.charAt(i) == '1') {
                list.add('1');
            }
            if (message.charAt(i) == '2') {
                list.add('2');
            }
            if (message.charAt(i) == '3') {
                list.add('3');
            }
            if (message.charAt(i) == '4') {
                list.add('4');
            }
            if (message.charAt(i) == '5') {
                list.add('5');
            }
            if (message.charAt(i) == '6') {
                list.add('6');
            }
            if (message.charAt(i) == '7') {
                list.add('7');
            }
            if (message.charAt(i) == '8') {
                list.add('8');
            }
            if (message.charAt(i) == '9') {
                list.add('9');
            }
            if (message.charAt(i) == '0') {
                list.add('0');
            }
            if (message.charAt(i) == '@') {
                list.add('@');
            }
            if (message.charAt(i) == '#') {
                list.add('#');
            }
            if (message.charAt(i) == '$') {
                list.add('$');
            }
            if (message.charAt(i) == '%') {
                list.add('%');
            }
            if (message.charAt(i) == '^') {
                list.add('^');
            }
            if (message.charAt(i) == '&') {
                list.add('&');
            }
            if (message.charAt(i) == '?') {
                list.add('?');
            }
            if (message.charAt(i) == '*') {
                list.add('*');
            }
            if (message.charAt(i) == '(') {
                list.add('(');
            }
            if (message.charAt(i) == ')') {
                list.add(')');
            }
            if (message.charAt(i) == '-') {
                list.add('-');
            }
            if (message.charAt(i) == '=') {
                list.add('=');
            }
            if (message.charAt(i) == '/') {
                list.add('/');
            }
            if (message.charAt(i) == '+') {
                list.add('+');
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character list1 : list) {
            stringBuilder.append(list1);
        }
        int len = oldMessage.length() - stringBuilder.length();
        return stringBuilder + oldMessage.substring(message.length() - len);
    }
}
