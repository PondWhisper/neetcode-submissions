

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder(str);
        List<String> ls = new ArrayList<>();
        while(!sb.isEmpty()){
            int i = 0;
            while(sb.charAt(i) != '#'){
                i++;
            }
            int length = Integer.parseInt(sb.substring(0, i));
            ls.add(sb.substring(i + 1, i + 1 + length));
            sb.delete(0, i + 1 + length);
        }
        return ls;
    }
}