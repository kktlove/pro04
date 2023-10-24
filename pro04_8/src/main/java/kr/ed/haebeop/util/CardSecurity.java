package kr.ed.haebeop.util;

import lombok.Data;

@Data
public class CardSecurity {
    public boolean compareCardNum(String cardNum){
        boolean ps = false;
        int[] arr = new int[60];
        int size = cardNum.length();
        int sw = (size-1) % 2;
        int lastNum = Character.getNumericValue(cardNum.charAt(size-1));
        for(int i=size-1;i>=0;i--){
            arr[i] = Character.getNumericValue(cardNum.charAt(i));
            if(i % 2 == sw){
                arr[i] = arr[i] * 2;
            } else {
                arr[i] = arr[i] * 1;
            }
        }
        for(int i=0;i<size;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println("마지막 번호 : "+lastNum);
        int total = 0;
        for(int i=0;i<cardNum.length();i++){
            int num1 = 0;
            int num2 = 0;
            int num = arr[i];
            if(arr[i]>=10){
                num1 = (int) arr[i] / 10;
                num2 = (int) arr[i] % 10;
                num = num1 + num2;
            }
            System.out.print(num);
            total+=num;
        }
        System.out.println();
        System.out.println(total);
        if((total+lastNum)%10==0){
            ps = true;
        }
        return ps;
    }
}
