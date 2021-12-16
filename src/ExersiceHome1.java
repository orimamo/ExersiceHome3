public class ExersiceHome1 {
   public static boolean switcher(int num1){
       boolean check=false;
       String s1 = "" +num1;
       for (int i=0;i<s1.length();i=i+2){
           if((s1.charAt(i)%2==1)&&s1.charAt(i+1)%2==0){
               check=true;
           }else if ((s1.charAt(i)%2==0)&&s1.charAt(i+1)%2==1){
               check=true;
           }
           else {
               if (s1.charAt(i)%2==1 && s1.charAt(i+1)%2==1)
               {
                   check=false;
                   break;
               }
               else {
                   if (s1.charAt(i)%2==0 && s1.charAt(i+1)%2==0){
                       check=false;
                       break;
                   }
               }

           }

       }
        return check;
    }
    public static int smallestIndex(int [] arr){
       int index=0;
       int min=0;
       int sum = 0;
       boolean check=false;
       for (int i=0;i<arr.length;i++){
          check = switcher(arr[i]);
          if (check=true)
          {
              sum = sum(arr[i]);
          }
          if(i==0){
              min=sum;
          }else {
              min=Math.min(min,sum);
          }

          if(min==sum){
              index=i;
          }
          else {
              continue;
          }
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
       int [] a= {45,23,67};
       System.out.println(smallestIndex(a));
    }
}
