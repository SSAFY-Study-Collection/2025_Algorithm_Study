public class Lv2_124나라 {
    static String token = "124";
    static String answer;
    StringBuilder sb;
    public String solution(int n) {
        sb = new StringBuilder();
        nnary(n);
        return sb.reverse().toString();
    }
    
    void nnary(int n){
        if(n==0) return;
        
        int mod = n%3;
        
        if(mod==0){
            sb.append("4");
            nnary(n/3-1);
        } else{
            sb.append(token.charAt(mod-1));
            nnary(n/3);
        }
        
    }    
}
