import java.util.*;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length <= 0) {
            return new ArrayList<String>();
        }
        //return value
        List<String> result = new ArrayList<>();
        
        //the starting word's index in words[] for the current line
        int start = 0;
        
        //the length of the current line
        int len = words[0].length();
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            //two conditions 1. add to current line  update len
            if (len + 1 + word.length() <= maxWidth) {
                len += (1 + word.length());
            }
            // condition 2. Can't add to current line, from start to i - 1 add to current line, update len to word.length() 
            //              update start to i
            else {
                StringBuilder sb = new StringBuilder();
                int numWords = i - start;
                int remainder = maxWidth - len;
                //every split has at least this many spaces
                int numSpaces = (numWords == 1) ? remainder : 1 + remainder / (numWords - 1);
                //the first leading splits may have one more depends on the value of oneMore 
                int oneMore = (numWords == 1) ? 0 : remainder - (numSpaces - 1) * (numWords - 1);
                for (int j = start; j < i; j++) {
                    sb.append(words[j]);
                    if (j == i - 1 && numWords != 1)
                        continue;
                    for (int k = 0; k < numSpaces; k++)
                        sb.append(" ");
                    if (j - start + 1 <= oneMore) {
                        sb.append(" ");
                    }
                }
                result.add(sb.toString());
                
                //update references
                start = i;
                len = word.length();
            }
        }
        
        //now deal with the last line
        //we have len and start
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(" ");
            } else {
                for (int j = 0; j < maxWidth - len; j++)
                    sb.append(" ");
            }
        }
        result.add(sb.toString());
        
        return result;
    }
}
