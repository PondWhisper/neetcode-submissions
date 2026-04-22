class Solution {
    public int maxArea(int[] heights) {
        int primePointer=0;
        int lastPointer=heights.length-1;
        double max=Double.MIN_EXPONENT;
        while (lastPointer>primePointer){
            double height=Math.min(heights[ lastPointer], heights[ primePointer]);
            double area=height*(lastPointer-primePointer);
            double primeHeight=(double)heights[primePointer];
            double lastHeight=(double)heights[lastPointer];
            if(lastHeight>primeHeight){
                primePointer++;
            }else if(primeHeight>lastHeight){
                lastPointer--;
            }else{
                primePointer++;
                lastPointer--; 
            }
            if(area>max){
                max=area;
            }
            
        }
        return (int)max;
    }

}