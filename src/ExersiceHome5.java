public class ExersiceHome5 {
    public static String decode (String userInput){

        int firstMax=0;
        int secondMax=0;
        char check=' ';
        char indexMax = ' ';
        char indexMaxSecond = ' ';
        for (int i=0;i<userInput.length();i++)
        {
            int counter=1;
            for (int j=i+1;j<userInput.length();j++)
            {
                if (userInput.charAt(i)==' '){
                    continue;
                }
                check = userInput.charAt(i);
                if(userInput.charAt(i)==userInput.charAt(j))
                {
                    counter++;
                }

            }
            if (secondMax < counter && check!=indexMax && check!=indexMaxSecond) {
                secondMax=Math.max(counter,secondMax);
                indexMaxSecond = check ;
                if (firstMax<secondMax) {
                    counter=firstMax;
                    firstMax=Math.max(firstMax,secondMax);
                    secondMax=counter;
                    check=indexMax;
                    indexMax=indexMaxSecond;
                    indexMaxSecond=check;
                }
            }
            else {
                continue;
            }
        }
        String newString="";
        int i=0;
    while (i!=userInput.length()){
        if (userInput.charAt(i)!=indexMax && userInput.charAt(i)!=indexMaxSecond ){
            newString =newString + userInput.charAt(i);
            i++;
        }
        else if (userInput.charAt(i)== indexMax){
            newString =newString + indexMaxSecond;
            i++;
        }
        else {
            if (userInput.charAt(i)== indexMaxSecond){
                newString =newString + indexMax;
                i++;
            }
        }
        }
        return newString;
    }

    public static void main(String[] args) {
        String str = "rt";
        System.out.println(decode(str));
    }

}
