class Solution {
    public int trap(int[] height) {
        int length=height.length;
        int l=0, r=length-1;
        int result=0;
        int leftHeight=height[l], rightHeight=height[r];
        while (l<r){
            if(leftHeight<=rightHeight){
                l++;
                int n=height[l];
                leftHeight=Math.max(n, leftHeight);
                result+=leftHeight-n;
            }else{
                r--;
                int n=height[r];
                rightHeight=Math.max(n, rightHeight);
                result+=rightHeight-n;
            }
        }
        return result;
    }
}
