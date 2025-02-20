class Solution {
    List<String> A;
    public List<String> letterCombinations(String digits) {
        A = new ArrayList<>();
        if(digits.length() == 0) {
            return A;
        }
        recursion(0 , digits , new StringBuilder());
        return A;
    }

    private void recursion(int currIndex, String digits, StringBuilder curr) {
        if(currIndex >= digits.length()) {
            A.add(curr.toString());
            return ;
        }
        char all[] = getAll(digits.charAt(currIndex) - '0');
        for(char c : all) {
            recursion(currIndex+1 , digits , curr.append(c));
            curr.deleteCharAt(curr.length()-1);
        }
    }

    private char[] getAll(int digit) {
        switch(digit) {
            case 2:
                return new char[]{'a','b','c'};
            case 3:
                return new char[]{'d','e','f'};
            case 4:
                return new char[]{'g','h','i'};
            case 5:
                return new char[]{'j','k','l'};
            case 6:
                return new char[]{'m','n','o'};
            case 7:
                return new char[]{'p','q','r','s'};
            case 8:
                return new char[]{'t','u','v'};
            case 9:
                return new char[]{'w','x','y','z'};
            default: return new char[]{};
        }
    }
}