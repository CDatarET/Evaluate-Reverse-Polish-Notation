public class Solution {
    public int EvalRPN(string[] tokens) {
        string[] stack = new string[tokens.Length];
        int top = -1;
        for(int i = 0; i < tokens.Length; i++){
            char t = tokens[i][tokens[i].Length - 1];
            if(t >= '0' && t <= '9'){
                stack[++top] = tokens[i];
            }
            else{
                int op2 = int.Parse(stack[top--]);
                int op1 = int.Parse(stack[top--]);
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
                        break;
                }

                stack[++top] = "" + push;
            }
        }

        return(int.Parse(stack[top]));
    }
}
