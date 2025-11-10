class Solution {
    public int evalRPN(String[] tokens) {
        String[] stack = new String[tokens.length];
        int top = -1;
        for(int i = 0; i < tokens.length; i++){
            char t = tokens[i].charAt(tokens[i].length() - 1);
            if(t >= '0' && t <= '9'){
                stack[++top] = tokens[i];
            }
            else{
                int op2 = Integer.parseInt(stack[top--]);
                int op1 = Integer.parseInt(stack[top--]);
                int push = 0;
                switch(t){
                    case '+':
                        push = op1 + op2;
                        break;

                    case '-':
                        push = op1 - op2;
                        break;
                    
                    case '*':
                        push = op1 * op2;
                        break;

                    case '/':
                        push = op1 / op2;
                }

                stack[++top] = String.valueOf(push);
            }
        }

        return(Integer.parseInt(stack[top]));
    }
}
