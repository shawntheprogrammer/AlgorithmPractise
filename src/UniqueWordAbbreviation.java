import java.util.*;

public class UniqueWordAbbreviation {
    HashMap<String, HashSet<String>> map = new HashMap<>();
    public UniqueWordAbbreviation(String[] dictionary) {
        if (dictionary == null || dictionary.length == 0)
            return;
            
        for (String word : dictionary) {
            String abbreviation = getAbbreviation(word);
            if (!map.containsKey(abbreviation))
                map.put(abbreviation, new HashSet<String>());
            map.get(abbreviation).add(word);
        }
    }
    
    public String getAbbreviation(String word) {
        if (word == null || word.length() < 2) {
            return word;
        }    
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        
        return sb.toString();
    }
    
    public boolean isUnique(String word) {
        if (word == null)
            return true;
        String abbreviation = getAbbreviation(word);
        
        if (!map.containsKey(abbreviation))
            return true;
        if (map.get(abbreviation).size() == 1 && map.get(abbreviation).contains(word))
            return true;
        return false;
    }
}
