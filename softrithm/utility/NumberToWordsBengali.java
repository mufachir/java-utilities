package softrithm.utility;

import java.text.DecimalFormat;

public class NumberToWordsBengali {
    public static final String[] belowTenNames = {"এক", "দুই", "তিন", "চার", "পাঁচ", "ছয়", "সাত", "আট", "নয়"};

    public static final String[] belowHundredNames = {"দশ", "এগারো", "বারো", "তেরো", "চোদ্দ", "পনেরো", "ষোল", "সতেরো", "আঠারো", "উনিশ", "কুড়ি", "একুশ", "বাইশ", "তেইশ",
            "চব্বিশ", "পঁচিশ", "ছাব্বিশ", "সাতাশ", "আঠাশ", "ঊনত্রিশ", "ত্রিশ", "একত্রিশ", "বত্রিশ", "তেত্রিশ", "চৌত্রিশ", "পঁয়ত্রিশ", "ছত্রিশ", "সাঁয়ত্রিশ", "আটত্রিশ", "ঊনচল্লিশ", "চল্লিশ", "একচল্লিশ", "বিয়াল্লিশ",
            "তেতাল্লিশ", "চুয়াল্লিশ", "পঁয়তাল্লিশ", "ছেচল্লিশ", "সাতচল্লিশ", "আটচল্লিশ", "ঊনপঞ্চাশ", "পঞ্চাশ", "একান্ন", "বাহান্ন", "তিপ্পান্ন", "চুয়ান্ন", "পঞ্চান্ন", "ছাপ্পান্ন", "সাতান্ন", "আটান্ন", "ঊনষাট", "ষাট",
            "একষট্টি", "বাষট্টি", "তেষট্টি", "চৌষট্টি", "পঁয়ষট্টি", "ছেষট্টি", "সাতষট্টি", "আটষট্টি", "ঊনসত্তর", "সত্তর", "একাত্তর", "বাহাত্তর", "তিয়াত্তর", "চুয়াত্তর", "পঁচাত্তর", "ছিয়াত্তর", "সাতাত্তর", "আটাত্তর",
            "ঊনআশি", "আশি", "একাশি", "বিরাশি", "তিরাশি", "চুরাশি", "পঁচাশি", "ছিয়াশি", "সাতাশি", "অষ্টআশি", "ঊননব্বই", "নব্বই", "একানব্বই", "বিরানব্বই", "তিরানব্বই", "চুরানব্বই", "পঁচানব্বই",
            "ছিয়ানব্বই", "সাতানব্বই", "আটানব্বই", "নিরানব্বই"};

    public static final String[] otherNames = {"শত", "হাজার", "লক্ষ", "কোটি"};


    public static String convertToWord(String inputNumber) {
        if (inputNumber.equals("0")) {
            return "শূণ্য";
        }

        String numberBeforeDecimal = inputNumber;
        String numberAfterDecimal = "";

        Integer numberLength = inputNumber.length();

        Boolean isDecimalPointPresent = false;

        if (inputNumber.contains(".")) {
            isDecimalPointPresent = true;

            Integer indexOfDecimal = inputNumber.indexOf(".");

            numberBeforeDecimal = inputNumber.substring(0, indexOfDecimal - 1);

            numberAfterDecimal = inputNumber.substring(indexOfDecimal + 1);
        }


        String mask = "0000000000";
        DecimalFormat df = new DecimalFormat(mask);
        numberBeforeDecimal = df.format(Long.valueOf(numberBeforeDecimal));

        Integer koti = Integer.parseInt(numberBeforeDecimal.substring(0,2));
        Integer lakh = Integer.parseInt(numberBeforeDecimal.substring(3,4));
        Integer hajar = Integer.parseInt(numberBeforeDecimal.substring(5,6));
        Integer hundred = Integer.parseInt(numberBeforeDecimal.substring(7,9));



        String stringForKoti;
        switch (koti) {
            case 0:
                stringForKoti = "";
                break;
            case 1 :
                stringForKoti = convertLessThanOneThousand(String.valueOf(koti))
                        + " কোটি ";
                break;
            default :
                stringForKoti = convertLessThanOneThousand(String.valueOf(koti))
                        + " কোটি ";
        }
        String result =  stringForKoti;

        String stringForLakh;
        switch (lakh) {
            case 0:
                stringForLakh = "";
                break;
            case 1 :
                stringForLakh = convertLessThanOneThousand(String.valueOf(lakh))
                        + " লক্ষ ";
                break;
            default :
                stringForLakh = convertLessThanOneThousand(String.valueOf(lakh))
                        + " লক্ষ ";
        }
        result =  result + stringForLakh;

        String stringForHajar;
        switch (hajar) {
            case 0:
                stringForHajar = "";
                break;
            case 1 :
                stringForHajar = "এক হাজার ";
                break;
            default :
                stringForHajar = convertLessThanOneThousand(String.valueOf(hajar))
                        + " হাজার ";
        }
        result =  result + hajar;

        String stringForHundred = convertLessThanOneThousand(String.valueOf(hundred));
        result =  result + stringForHundred;


        return result;
    }


    private static String convertLessThanOneThousand(String inputNumber) {
        String soFar;
        Integer number = Integer.valueOf(inputNumber);

        if (number % 100 < 10){
            soFar = belowTenNames[number % 100];
            number /= 100;
        }
        else {
            soFar = belowHundredNames[number % 10];
            number /= 10;

            soFar = belowTenNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return belowTenNames[number] + " শত" + soFar;
    }
}