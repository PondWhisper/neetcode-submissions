
class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!brackets.isEmpty()) {
                char lastOne = brackets.peek();
                switch (lastOne) {
                    case '(':
                        if (c == ')') {
                            brackets.pop();
                        }else {
                            brackets.push(c);
                        }
                        break;
                    case '[':
                        if (c == ']') {
                            brackets.pop();
                        }else {
                            brackets.push(c);
                        }
                        break;
                    case '{':
                        if (c == '}') {
                            brackets.pop();
                        }else {
                            brackets.push(c);
                        }
                        break;
                    default:
                        brackets.push(c);
                }
            } else {
                brackets.push(c);
            }
        }
        return brackets.isEmpty();
    }
}

