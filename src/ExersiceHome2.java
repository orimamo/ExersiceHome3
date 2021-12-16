public class ExersiceHome2 {
    public static int brother(int []arr1,int [] arr2){
        int index=0;
        int max=0;
        int sum=0;
        int sum2=0;

        for(int i=0;i<arr1.length;i++){
            int countBrother=0;
            sum = sum(arr1[i]);
            for (int j=0;j<arr2.length;j++)
            {
                sum2 = sum(arr2[j]);
                if (sum==sum2){
                    countBrother++;
                }
            }
            max=Math.max(max,countBrother);
            if (max==countBrother){
                index = i;
            }
            else {
                continue;
            }
        }
        if (max==0){
            index=0;
        }

        return index;

    }
    public static int sum(int num){
        int sum = 0;
        while (num > 0){
            sum = sum + num%10;
            num=num/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] arr1={158,12,24,111,68};
        int [] arr2={73,591,23,841,70};

        System.out.println( brother(arr1,arr2));
    }
}
