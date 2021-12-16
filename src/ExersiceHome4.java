public class ExersiceHome4 {
    public static boolean fullArray(int [] array){
        boolean check = false;
        if (array.length>1)
        {
            int[] array1 = sort(array);
            for (int i = 0; i < array1.length - 1; i++) {
                if (array1[i] + 1 == array1[i + 1]) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
        }
        else {
            check=false;
        }
        return check;
        }
    public static int[] sort(int[] arr)
    {
        int temp;
        for(int a = 0; a <= arr.length - 1; a++)
        {
            for(int b = 0; b <= arr.length - 2; b++)
            {
                if(arr[b] > arr[b + 1])
                {
                    temp = arr[b];
                    arr[b] = arr[b + 1];
                    arr[b + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] array ={10,12,11,14,13,16,15};
        //sort(array);
        boolean check = fullArray(array);
        System.out.println(check);
    }




}
