package util;

public class Utile {
    public static int  pozMaxVec(int[]arr){
        int maximElement=arr[0];
        int  position=0;
        for (int i=0;i< arr.length;i++){
            if(arr[i]>maximElement){
                maximElement=arr[i];

                position=i;
            }
        }
        return position;
    }
}
