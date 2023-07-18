package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

class Solution4 {
    Map<String, Integer> genreMap;
    
    public int[] solution(String[] genres, int[] plays) {
        genreMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], 0);
            }
            genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
        }
        
        List<Item> items = IntStream.range(0, genres.length)
                .boxed()
                .map(i -> new Item(genres[i], plays[i], i))
                .sorted()
                .collect(Collectors.toList());
        
        List<Integer> album = new ArrayList<>();
        
        String lastGenre = "";
        int count = 0;
        for (Item item: items) {
            if (lastGenre.equals(item.genre)) {
                count++;
            } else {
                count = 1;
            }
            lastGenre = item.genre;
            
            if (count > 2) {
                continue;
            }
            
            album.add(item.index);
        }
        
        return album.stream().mapToInt(i->i).toArray();
    }
    
    class Item implements Comparable<Item> {
        String genre;
        int play;
        int index;
        
        public Item(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
        
        public int compareTo(Item o) {
            if (genre.equals(o.genre)) {
                if (play == o.play) {
                    return index - o.index;
                }
                return o.play - play;                
            }
            return genreMap.get(o.genre) - genreMap.get(genre);
        }
    }
}