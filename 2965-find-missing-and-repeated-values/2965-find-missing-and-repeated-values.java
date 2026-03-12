class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n=grid.length;
        int total=n*n;

        long sum=0;
        long sumsq=0;
        
        for(int[] row: grid){
            for(int num : row){
            sum += num;
            sumsq += (long)num *num;
        }
        
        }
    

        long S= (long)total* (total+1)/2;
        long Ssq= (long)total* (total+1) *(2*total +1)/6;

        long diff= sum -S;
        long sqdiff= sumsq-Ssq;

        long sumxy= sqdiff/ diff;

        int repeat=(int)((diff + sumxy)/2);
        int missing= (int)(sumxy- repeat);

        return new int[]{repeat, missing};
    }
}