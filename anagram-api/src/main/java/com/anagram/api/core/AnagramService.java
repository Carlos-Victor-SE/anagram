package com.anagram.api.core;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class AnagramService {

    /*  
     * O metodo CreateAnagramStream recebe uma string e retorna um Stream de Strings
     * contendo todos os anagramas possiveis da string passada como parametro.
     * o objetivo é fazer o processamento parcialmente para evitar armazenar todos os dados na memoria
     * o que pode causar problemas de memoria quando consulta uma palavra muito grande.
     */
    public Stream<String> createAnagramStream(String word) {
        return generateAnagrams(word).stream();
    }

    /*  
     * O metodo countAnagrams recebe uma string e retorna a quantidade de anagramas
     * possiveis da string passada como parametro.
     */
    public int countAnagrams(String word) {
        return factorial(word.length());
    }


    /*  
     * O metodo generateAnagrams recebe uma string e retorna um Set de Strings
     * contendo todos os anagramas possiveis da string passada como parametro.
     * a chamada do metodo permute é quem faz todas as permutas possiveis da palavra entregue.
     * o uso do hashset é para evitar duplicação de anagramas.
     */
    private Set<String> generateAnagrams(String word) {
        Set<String> anagrams = new HashSet<>();
        permute("", word, anagrams);
        return anagrams;
    }

    /*  
     * O metodo permute gera todas as permutações possiveis.
     * quando a string word fica significa que temos um anagrama completo que é armazenada no prefix e depois é adicionada no set de string.
     * o for percorre as letras possiveis para fazer as permutas de cada letra formando cada anagrama.
     */
    private void permute(String prefix, String word, Set<String> anagrams) {
        int n = word.length();
        if (n == 0) {
            anagrams.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1, n), anagrams);
            }
        }
    }

    /*  
     * O metodo factorial é usado para pegar o total de anagramas.
     * como o número de anagramas sem caracter repetidos é n! então ajuda encontrar o valor total
     * ja que buscar todos os dados diretamente para buscar o tamanho pode causar problemas de memoria.
     */
    private int factorial(int n) {
        return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
    }
    
}
