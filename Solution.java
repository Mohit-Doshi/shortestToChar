class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int lastoccurence = s.indexOf(c);
        int[] sTC = new int[s.length()];
        
        int i = 0;
        for(; i <= lastoccurence; i++) {
            
            sTC[i] = lastoccurence-i;
            
        }
        
        while(i < s.length()) {
        
            if(i == s.length())
                return sTC;
            
            if(s.substring(i,s.length()).indexOf(c) == -1) {
                for(; i < s.length(); i++) {
                    sTC[i] = i-lastoccurence;
                }
                return sTC;
            }

            int nextoccurence = lastoccurence + s.substring(i, s.length()).indexOf(c) + 1;

            for(; i <= nextoccurence; i++) {
                
                sTC[i] = Math.min(Math.abs(nextoccurence-i), Math.abs(lastoccurence-i));
                
            }
            
            lastoccurence = nextoccurence;
            
        }
        
        return sTC;
        
    }
}
