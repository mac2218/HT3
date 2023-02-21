class Stack:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[-1]

    def size(self):
        return len(self.items)

def infix_to_postfix(infix_expr):
    prec = {"^": 4, "*": 3, "/": 3, "+": 2, "-": 2, "(": 1}
    op_stack = Stack()
    postfix_list = []
    token_list = infix_expr.split()

    for token in token_list:
        if token in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" or token in "0123456789":
            postfix_list.append(token)
        elif token == '(':
            op_stack.push(token)
        elif token == ')':
            top_token = op_stack.pop()
            while top_token != '(':
                postfix_list.append(top_token)
                top_token = op_stack.pop()
        else:
            while (not op_stack.is_empty()) and (prec[op_stack.peek()] >= prec[token]):
                postfix_list.append(op_stack.pop())
            op_stack.push(token)

    while not op_stack.is_empty():
        postfix_list.append(op_stack.pop())

    return " ".join(postfix_list)

def postfix_to_infix(postfix_expr):
    op_stack = Stack()
    token_list = postfix_expr.split()

    for token in token_list:
        if token in "+-*/^":
            operand2 = op_stack.pop()
            operand1 = op_stack.pop()
            infix_expr = "({} {} {})".format(operand1, token, operand2)
            op_stack.push(infix_expr)
        else:
            op_stack.push(token)

    return op_stack.pop()

infix_expr = "A + B * C + D"
postfix_expr = infix_to_postfix(infix_expr)
print("Postfix: ", postfix_expr)
infix_expr = postfix_to_infix(postfix_expr)
print("Infix: ", infix_expr)
