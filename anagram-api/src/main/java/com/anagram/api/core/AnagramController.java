package com.anagram.api.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagram")
public class AnagramController {

    private final AnagramService service;

    public AnagramController(AnagramService service) {
		super();

		this.service = service;
	}

    /*  
     * O endpoint createAnagram é usada para se comunicar com o frontend, onde o service.ts pode fazer as requisições para a api do backend.
     */
    @GetMapping("/get")
    public Map<String, Object> createAnagram(
        @RequestParam String word, 
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size
    ) {
        Iterator<String> iterator = service.createAnagramStream(word).iterator();
        List<String> paginatedAnagrams = new ArrayList<>();
        
        int startIndex = page * size;
        int endIndex = startIndex + size;
        int index = 0;

        while (iterator.hasNext() && index < endIndex) {
            String anagram = iterator.next();
            if (index >= startIndex) {
                paginatedAnagrams.add(anagram);
            }
            index++;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("data", paginatedAnagrams);
        response.put("total", service.countAnagrams(word)); 

        return response;
    }
    
}
