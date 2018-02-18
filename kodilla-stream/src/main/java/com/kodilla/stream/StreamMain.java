package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

import static jdk.nashorn.internal.objects.NativeString.*;

public class StreamMain {
    public static void main(String[] args) {

        System.out.println("Beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Tekst do upiększenia nr 1", text -> toUpperCase(text));
        poemBeautifier.beautify("Tekst do upiększenia nr 2", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("Tekst do upiększenia nr 3", text -> toLowerCase(text));
        poemBeautifier.beautify("Tekst do upiększenia nr 4", text -> {
            return substring(text, 0, 5) + substring(text, 20, 26);
            });

    }
}