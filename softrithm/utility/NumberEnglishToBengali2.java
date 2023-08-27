package softrithm.utility;

public  class NumberEnglishToBengali2{
    public static String softrithm_convert_number_to_bengali(String inputNumber){
        String output = "";
        String[] numberArray = inputNumber.split("");
        for(int i = 0; i < numberArray.length; i++){
            if((numberArray[i]).equals("0")){
                output += "০";
            }else if(numberArray[i].equals("1")){
                output += "১";
            }else if(numberArray[i].equals("2")){
                output += "২";
            }else if(numberArray[i].equals("3")){
                output += "৩";
            }else if(numberArray[i].equals("4")){
                output += "৪";
            }else if(numberArray[i].equals("5")){
                output += "৫";
            }else if(numberArray[i].equals("6")){
                output += "৬";
            }else if(numberArray[i].equals("7")){
                output += "৭";
            }else if(numberArray[i].equals("8")){
                output += "৮";
            }else if(numberArray[i].equals("9")){
                output += "৯";
            }else{
                output += numberArray[i];
            }
        }
        return output;
    }
}
