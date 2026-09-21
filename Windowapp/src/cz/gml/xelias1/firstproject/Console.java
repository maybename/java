package cz.gml.xelias1.firstproject;

/**
 *
 * @author xelias1
 */
public class Console {
    public static boolean solution = false;
    public static String greetings[] = {"Hello ","Ahoj ","Dobrý den "};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(calc_text("2+2-1"));
    }
    public static int text_pointer = 0;
    
    public static float read_num(String text){
        float num = 0;
        int dec = 0;
        for (int i = text_pointer; i < text.length(); i ++){
            char c = text.charAt(i);
            if(c == '.'){
                dec = 1;
                continue;
            }
            if(c<='9' && c >= '0'){
                if(dec == 0){
                    num = num * 10 + c - '0';
                }
                else {
                    num = num + c/Math.powExact(10, dec);
                    dec += 1;
                }
                continue;
            }
            text_pointer = i-1; //set pointer to last index of the number, not to leading character
            return num;
        }
        return num;
    }
    
    
    public static float proc_part(String text){
        float out = 0;      // var for final value
        int operation = 0;  // var to store what operation it should currently do
        /*  0 ~ +, 
            1 ~ -, 
            2 ~ *, 
            3 ~ / 
        */              // curretnly works only +
        float c_num1 = 0;
        float c_num2 = 0;        
        
        while(text_pointer < text.length()){
            char c = text.charAt(text_pointer);
            System.out.print(text_pointer);
            System.out.print(" ");
            System.out.println(c);

            if(c<='9' && c >= '0'){
                c_num1 = read_num(text);
            }else if(c == '+' || c == '*' || c == '/' || c == '-'){
                System.out.println(operation);
                switch(operation){
                    case 0 -> out += c_num1;
                    case 1 -> out -= c_num1;
                    default -> System.out.println(operation);
                }
                c_num1 = 0;
                
                switch(c){
                    case '+' -> operation = 0;
                    case '-' -> operation = 1;
                    //case '*' -> {operation = 2; c_num2 = c_num1;}
                    //case '/' -> {operation = 3; c_num2 = c_num1;}
                }
                System.out.println(out);
            }
            text_pointer += 1;
        }
        switch(operation){
            case 0 -> out += c_num1;
            case 1 -> out -= c_num1;
            default -> System.out.println(operation);
        }
        return out;
    }
    
    
    public static float calc_text(String text){
        solution = true;
        text_pointer = 0;
        System.out.print("solving: ");
        System.out.println(text);
        float out = proc_part(text);
        System.out.print("solution: ");
        System.out.println(out);
        return out;
    }
    
}
