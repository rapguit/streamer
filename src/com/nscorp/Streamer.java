package com.nscorp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raphael on 30/03/17.
 */
public class Streamer {
    private static final char vogals[] = {
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
    };
    private static final char cons[] = {
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k',
            'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K',
            'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static char previous;
    private static char beforePrevious;
    private static Map<Character, Integer> rank;

    public static char firstChar(final Stream input) {
        char choosed = '!';
        rank = initRank();

        while (input.hasNext()) {
            char c = input.getNext();

            if (rank.containsKey(c)) {
                rank.put(c, rank.get(c) + 1);
            }

            if (match(c, vogals)
                    && match(beforePrevious, vogals)
                    && match(previous, cons)){

                if(rank.get(c) == 1) choosed = c;
                else choosed = '!';
            }

            beforePrevious = previous;
            previous = c;
        }
        if(choosed == '!') System.out.println("Caracter não encontrado.");
        return choosed;
    }

    private static Map<Character, Integer> initRank() {
        return new HashMap<Character, Integer>() {{
            for (int i = 0; i < vogals.length; i++) {
                put(vogals[i], 0);
            }
        }};
    }

    private static boolean match(char c, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == c) return true;
        }

        return false;
    }
}
