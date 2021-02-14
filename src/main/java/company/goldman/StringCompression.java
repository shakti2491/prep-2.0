package company.goldman;

public class StringCompression {
    public int compress(char[] chars) {
       int anchor = 0; int write=0;
       for(int read= 0; read<chars.length;read++){
           if(read+1 == chars.length || chars[read+1]!=chars[read]){
               chars[write++] = chars[anchor];
               if(read>anchor){
                   for(char c : (""+(read-anchor+1)).toCharArray()){
                       chars[write++] = c;
                   }
               }
               anchor=read+1;
           }
       }
       return write;
    }

    public static void main(String[] args) {
        System.out.println("bab".compareTo("abab"));

    }
}
