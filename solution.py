class Solution:
    def evalRPN(self, tokens):
        stack = [0] * len(tokens)
        top = -1
        for t in tokens:
            tkn = t[len(t) - 1]
            if tkn >= "0" and tkn <= "9":
                top += 1
                stack[top] = int(t)
            else:
                op2 = stack[top]
                top -= 1
                op1 = stack[top]

                if tkn == "+":
                    stack[top] = op1 + op2
                elif tkn == "-":
                    stack[top] = op1 - op2
                elif tkn == "*":
                    stack[top] = op1 * op2
                else:
                    stack[top] = int(op1 / op2)
        
        return(stack[top])
