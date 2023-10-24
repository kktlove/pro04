package kr.ed.haebeop.util;

import java.util.*;
public class PaymentLoad {
    public List<Payment> getPaymentList(String type){
        List<Payment> payList = new ArrayList<>();
        if(type.equals("credit")){
            Payment pay1 = new Payment();
            pay1.setStype("credit");
            pay1.setScomn(1);
            pay1.setScom("삼성카드");

            payList.add(pay1);

            Payment pay2 = new Payment();
            pay2.setStype("credit");
            pay2.setScomn(2);
            pay2.setScom("KB국민카드");
            payList.add(pay2);

            Payment pay3 = new Payment();
            pay3.setStype("credit");
            pay3.setScomn(3);
            pay3.setScom("신한카드");
            payList.add(pay3);

            Payment pay4 = new Payment();
            pay4.setStype("credit");
            pay4.setScomn(4);
            pay4.setScom("우리카드");
            payList.add(pay4);

            Payment pay5 = new Payment();
            pay5.setStype("credit");
            pay5.setScomn(5);
            pay5.setScom("하나카드");
            payList.add(pay5);

            Payment pay6 = new Payment();
            pay6.setStype("credit");
            pay6.setScomn(6);
            pay6.setScom("롯데카드");
            payList.add(pay6);

            Payment pay7 = new Payment();
            pay7.setStype("credit");
            pay7.setScomn(7);
            pay7.setScom("현대카드");
            payList.add(pay7);

            Payment pay8 = new Payment();
            pay8.setStype("credit");
            pay8.setScomn(8);
            pay8.setScom("NH농협카드");
            payList.add(pay8);

            Payment pay9 = new Payment();
            pay9.setStype("credit");
            pay9.setScomn(9);
            pay9.setScom("BC카드");
            payList.add(pay9);

            Payment pay10 = new Payment();
            pay10.setStype("credit");
            pay10.setScomn(10);
            pay10.setScom("마스터카드");
            payList.add(pay10);

            Payment pay11 = new Payment();
            pay11.setStype("credit");
            pay11.setScomn(11);
            pay11.setScom("VISA카드");
            payList.add(pay11);

            Payment pay12 = new Payment();
            pay12.setStype("credit");
            pay12.setScomn(12);
            pay12.setScom("아멕스카드");
            payList.add(pay12);
        } else if(type.equals("check")) {
            Payment pay1 = new Payment();
            pay1.setStype("check");
            pay1.setScomn(1);
            pay1.setScom("삼성카드");
            payList.add(pay1);

            Payment pay2 = new Payment();
            pay2.setStype("check");
            pay2.setScomn(2);
            pay2.setScom("KB국민카드");
            payList.add(pay2);

            Payment pay3 = new Payment();
            pay3.setStype("check");
            pay3.setScomn(3);
            pay3.setScom("신한카드");
            payList.add(pay3);

            Payment pay4 = new Payment();
            pay4.setStype("check");
            pay4.setScomn(4);
            pay4.setScom("우리카드");
            payList.add(pay4);

            Payment pay5 = new Payment();
            pay5.setStype("check");
            pay5.setScomn(5);
            pay5.setScom("하나카드");
            payList.add(pay5);

            Payment pay6 = new Payment();
            pay6.setStype("check");
            pay6.setScomn(6);
            pay6.setScom("롯데카드");
            payList.add(pay6);

            Payment pay7 = new Payment();
            pay7.setStype("check");
            pay7.setScomn(7);
            pay7.setScom("현대카드");
            payList.add(pay7);

            Payment pay8 = new Payment();
            pay8.setStype("check");
            pay8.setScomn(8);
            pay8.setScom("NH농협카드");
            payList.add(pay8);

            Payment pay9 = new Payment();
            pay9.setStype("check");
            pay9.setScomn(9);
            pay9.setScom("BC카드");
            payList.add(pay9);

            Payment pay10 = new Payment();
            pay10.setStype("check");
            pay10.setScomn(10);
            pay10.setScom("신협카드");
            payList.add(pay10);

            Payment pay11 = new Payment();
            pay11.setStype("check");
            pay11.setScomn(11);
            pay11.setScom("새마을금고카드");
            payList.add(pay11);

            Payment pay12 = new Payment();
            pay12.setStype("check");
            pay12.setScomn(12);
            pay12.setScom("우체국카드");
            payList.add(pay12);

            Payment pay13 = new Payment();
            pay13.setStype("check");
            pay13.setScomn(13);
            pay13.setScom("IBK기업");
            payList.add(pay13);

            Payment pay14 = new Payment();
            pay14.setStype("check");
            pay14.setScomn(14);
            pay14.setScom("SC제일");
            payList.add(pay14);

            Payment pay15 = new Payment();
            pay15.setStype("check");
            pay15.setScomn(15);
            pay15.setScom("경남");
            payList.add(pay15);

            Payment pay16 = new Payment();
            pay16.setStype("check");
            pay16.setScomn(16);
            pay16.setScom("부산");
            payList.add(pay16);

            Payment pay17 = new Payment();
            pay17.setStype("check");
            pay17.setScomn(17);
            pay17.setScom("대구");
            payList.add(pay17);

            Payment pay18 = new Payment();
            pay18.setStype("check");
            pay18.setScomn(18);
            pay18.setScom("광주");
            payList.add(pay18);

            Payment pay19 = new Payment();
            pay19.setStype("check");
            pay19.setScomn(19);
            pay19.setScom("제주");
            payList.add(pay19);

            Payment pay20 = new Payment();
            pay20.setStype("check");
            pay20.setScomn(20);
            pay20.setScom("수협");
            payList.add(pay20);
        } else if(type.equals("bank")){
            Payment pay1 = new Payment();
            pay1.setStype("bank");
            pay1.setScomn(1);
            pay1.setScom("KB국민은행");
            payList.add(pay1);

            Payment pay2 = new Payment();
            pay2.setStype("bank");
            pay2.setScomn(2);
            pay2.setScom("하나은행");
            payList.add(pay2);

            Payment pay3 = new Payment();
            pay3.setStype("bank");
            pay3.setScomn(3);
            pay3.setScom("신한은행");
            payList.add(pay3);

            Payment pay4 = new Payment();
            pay4.setStype("bank");
            pay4.setScomn(4);
            pay4.setScom("우리은행");
            payList.add(pay4);

            Payment pay5 = new Payment();
            pay5.setStype("bank");
            pay5.setScomn(5);
            pay5.setScom("IBK기업은행");
            payList.add(pay5);

            Payment pay6 = new Payment();
            pay6.setStype("bank");
            pay6.setScomn(6);
            pay6.setScom("KDB산업은행");
            payList.add(pay6);

            Payment pay7 = new Payment();
            pay7.setStype("bank");
            pay7.setScomn(7);
            pay7.setScom("NH농협은행");
            payList.add(pay7);

            Payment pay8 = new Payment();
            pay8.setStype("bank");
            pay8.setScomn(8);
            pay8.setScom("SC제일은행");
            payList.add(pay8);

            Payment pay9 = new Payment();
            pay9.setStype("bank");
            pay9.setScomn(9);
            pay9.setScom("BNK부산은행");
            payList.add(pay9);

            Payment pay10 = new Payment();
            pay10.setStype("bank");
            pay10.setScomn(10);
            pay10.setScom("DGB대구은행");
            payList.add(pay10);

            Payment pay11 = new Payment();
            pay11.setStype("bank");
            pay11.setScomn(11);
            pay11.setScom("수협은행");
            payList.add(pay11);

            Payment pay12 = new Payment();
            pay12.setStype("bank");
            pay12.setScomn(12);
            pay12.setScom("카카오뱅크");
            payList.add(pay12);

            Payment pay13 = new Payment();
            pay13.setStype("bank");
            pay13.setScomn(13);
            pay13.setScom("BMK경남은행");
            payList.add(pay13);

            Payment pay14 = new Payment();
            pay14.setStype("bank");
            pay14.setScomn(14);
            pay14.setScom("한국시티은행");
            payList.add(pay14);

            Payment pay15 = new Payment();
            pay15.setStype("bank");
            pay15.setScomn(15);
            pay15.setScom("광주은행");
            payList.add(pay15);

            Payment pay16 = new Payment();
            pay16.setStype("bank");
            pay16.setScomn(16);
            pay16.setScom("토스뱅크");
            payList.add(pay16);

            Payment pay17 = new Payment();
            pay17.setStype("bank");
            pay17.setScomn(17);
            pay17.setScom("전북은행");
            payList.add(pay17);

            Payment pay18 = new Payment();
            pay18.setStype("bank");
            pay18.setScomn(18);
            pay18.setScom("케이뱅크");
            payList.add(pay18);

            Payment pay19 = new Payment();
            pay19.setStype("bank");
            pay19.setScomn(19);
            pay19.setScom("제주은행");
            payList.add(pay19);

            Payment pay20 = new Payment();
            pay20.setStype("bank");
            pay20.setScomn(20);
            pay20.setScom("신협");
            payList.add(pay20);

            Payment pay21 = new Payment();
            pay21.setStype("bank");
            pay21.setScomn(21);
            pay21.setScom("새마을금고");
            payList.add(pay21);

            Payment pay22 = new Payment();
            pay22.setStype("bank");
            pay22.setScomn(22);
            pay22.setScom("우체국");
            payList.add(pay22);

        } else {
            Payment pay1 = new Payment();
            pay1.setStype("point");
            pay1.setScomn(1);
            pay1.setScom("천재포인트");
            payList.add(pay1);

            Payment pay2 = new Payment();
            pay2.setStype("point");
            pay2.setScomn(2);
            pay2.setScom("해피포인트");
            payList.add(pay2);

            Payment pay3 = new Payment();
            pay3.setStype("point");
            pay3.setScomn(3);
            pay3.setScom("OK캐시백");
            payList.add(pay3);

            Payment pay4 = new Payment();
            pay4.setStype("point");
            pay4.setScomn(4);
            pay4.setScom("KT");
            payList.add(pay4);

            Payment pay5 = new Payment();
            pay5.setStype("point");
            pay5.setScomn(5);
            pay5.setScom("SKT");
            payList.add(pay5);

            Payment pay6 = new Payment();
            pay6.setStype("point");
            pay6.setScomn(6);
            pay6.setScom("LGT");
            payList.add(pay6);
        }
        return payList;
    }

    public String getBankIdLoad(int num){
        String[] bankArr = {"", "KB국민은행","하나은행","신한은행","우리은행","IBK기업은행","KDB산업은행","NH농협은행","SC제일은행","BNK부산은행","DGB대구은행","수협은행","카카오뱅크","BMK경남은행","한국시티은행","광주은행","토스뱅크","전북은행","케이뱅크","제주은행","신협","새마을금고","우체국"};
        String[] idArr = {"","121438-08-63761","123-456114-84231","116-953-127931","1172-557-637895","181-254357-18-995","020-0238-9276-310","112-58-511927","028-27-415386","245-4256-8712-19","563-58-201423-4","0210-4158-7602","3333-245786145","135-4728-2354-67","672-354867-224","672-483-596789","8608-1253-6945","613-36-0428263","352-178-211936","035-672-125436","121-022-0748886","223-6758-891268","025543-16-498127"};
        String bankId = bankArr[num] + ":" + idArr[num] + ", 예금주:김천재";
        return bankId;
    }
}
