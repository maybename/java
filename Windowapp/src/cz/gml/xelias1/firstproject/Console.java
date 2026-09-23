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
        System.out.println(calc_text("2+2-1 /2 +2*2"));
    }
    
    public static float calc_text(String text){
        return calc_text(text, 0);
    }

    
    public static float calc_text(String text, int start){
        solution = true;
        float c_num = 0;
        String c_num_text = "";
        boolean dot = false;
        char past_op = '+';

        float out = 0;

        for (int text_p = start; text_p < text.length(); text_p ++){
            char c = text.charAt(text_p);
            if ((c >= '0' && c <= '9')){
                c_num_text += c;
                continue;
            }
            if (c == '.'){
                if (dot){
                    solution = false;
                    return 42;
                }
                dot = true;
                c_num_text += c;
                continue;
            }
            

            
            if ((c == '+' || c == '-' || c == '*' || c == '/')&& c_num_text.length() > 0){
                float f = Float.parseFloat(c_num_text);
                c_num_text = "";
                switch(past_op){
                    case '+' -> {out += c_num; c_num = f;}
                    case '-' -> {out += c_num; c_num = -f;}
                    case '*' -> {c_num *= f;}
                    case '/' -> {c_num /= f;}
                }
                
                System.out.println(past_op);

                System.out.println(out);
                System.out.println(c_num);
                System.out.println(f);
                past_op = c;
            }
        }
        if (c_num_text.length() > 0){
            float f = Float.parseFloat(c_num_text);
            switch(past_op){
                case '+' -> {out += f;}
                case '-' -> {out += -f;}
                case '*' -> {c_num *= f;}
                case '/' -> {c_num /= f;}
            }
        }
        out += c_num;
        System.out.println(past_op);
        System.out.println(out);
        System.out.println(c_num);

        return out;
    }
    
}
