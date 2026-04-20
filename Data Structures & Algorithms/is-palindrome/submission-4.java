class Solution {
    public boolean isPalindrome(String s) {
        String[] strs=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (String str:strs){
            sb.append(str);
        }
        String wholeString=sb.toString();
        int lastPointer=wholeString.length()-1;
        int primePointer=0;
        while(lastPointer>primePointer){
            char lastChar=Character.toLowerCase(wholeString.charAt(lastPointer));
            char primeChar=Character.toLowerCase(wholeString.charAt(primePointer));
            if(!(lastChar>='a'&& lastChar<='z') && !(lastChar>='0'&&lastChar<='9')){
                lastPointer--;
                continue;
            }else if(!(primeChar>='a'&& primeChar<='z') && !(primeChar>='0'&&primeChar<='9')){
                primePointer++;
                continue;
            }

            if(primeChar!=lastChar){
                return false;
            }

            lastPointer--;
            primePointer++;
        }
        return true;
    }
}
