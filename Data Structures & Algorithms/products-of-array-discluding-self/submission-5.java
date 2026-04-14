

class Solution {
    public int[] productExceptSelf(int[] nums) {
        Queue<Integer> queue=new LinkedList<>();
        int length=nums.length;
        for (int i = length-1;i>=0; i--) {
            queue.add(nums[i]);
        }

        int[] outPut=new int[length];
        for (int i = 0; i < length; i++) {
            double product=1;
            for (int j = 0; j < length-1; j++) {
                int currNum=queue.poll();
                product*=currNum;
                queue.add(currNum);
            }
            outPut[i]=(int)product;
        }
        return outPut;
    }
}
