class Solution {
    public int trap(int[] height) {
        int length=height.length;
        int l=0;
        int r=length-1;
        int result=0;
        int leftHeight=height[l];
        int rightHeight=height[r];
        while (l<r){
            int currLeft=height[l];
            int currRight=height[r];
            if(currLeft<=currRight){
                l++;
                int n=height[l];
                if(n>=leftHeight){
                    leftHeight=n;
                }else{
                    result+=leftHeight-n;
                }
            }else{
                r--;
                int n=height[r];
                if(n>=rightHeight){
                    rightHeight=n;
                }else{
                    result+=rightHeight-n;
                }
            }
        }
        return result;
    }
}
