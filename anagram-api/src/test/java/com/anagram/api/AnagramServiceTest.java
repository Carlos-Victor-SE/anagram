package com.anagram.api;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anagram.api.core.AnagramService;

class AnagramServiceTest {

    private AnagramService anagramService;

    @BeforeEach
    void setUp() {
        anagramService = new AnagramService();
    }

    @Test
    void testCreateAnagramStream() {
        String input = "abc";
        Stream<String> resultStream = anagramService.createAnagramStream(input);
        List<String> resultList = resultStream.collect(Collectors.toList());

        Set<String> expectedAnagrams = Set.of("abc", "acb", "bac", "bca", "cab", "cba");

        assertEquals(expectedAnagrams.size(), resultList.size(), "Quantidade de anagramas incorreta");
        assertTrue(resultList.containsAll(expectedAnagrams), "Anagramas gerados incorretamente");
    }

    @Test
    void testCountAnagrams() {
        assertEquals(1, anagramService.countAnagrams("a"), "Erro na contagem de anagramas 'a'");
        assertEquals(2, anagramService.countAnagrams("ab"), "Erro na contagem de anagramas 'ab'");
        assertEquals(6, anagramService.countAnagrams("abc"), "Erro na contagem de anagramas 'abc'");
        assertEquals(24, anagramService.countAnagrams("abcd"), "Erro na contagem de anagramas 'abcd'");
    }

    @Test
    void testCreateAnagramStream_EmptyString() {
        Stream<String> resultStream = anagramService.createAnagramStream("");
        List<String> resultList = resultStream.collect(Collectors.toList());

        assertEquals(1, resultList.size(), "String vazia deveria ter um único anagrama");
        assertEquals("", resultList.get(0), "Anagrama da string vazia deveria ser uma string vazia");
    }
}