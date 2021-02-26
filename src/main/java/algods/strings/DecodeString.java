package algods.strings;

public class DecodeString {
    int index = 0;
    public String decodeString(String s){

        StringBuilder result = new StringBuilder();

        while(index<s.length() &&s.charAt(index)!=']'){

            if(!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else{
                int k = 0;
                while(index<s.length() && Character.isDigit(s.charAt(index))){
                    k=k*10+s.charAt(index++)-'0';

                    //ignore the opening bracket
                    index++;
                    String decodedString = decodeString(s);
                    //ignore closing bracket
                    index++;
                    // build k[decodestring] and append to the result
                    while (k -- >0)
                        result.append(decodedString);

                }
            }
        }
        return result.toString();
    }
}
