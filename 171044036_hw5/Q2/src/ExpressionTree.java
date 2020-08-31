//import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;


/** Class to create an Expression Tree*/
public class ExpressionTree extends BinaryTree {
    //Data Fields
    /**
     * To check given value is operator or not
     */
    String operators = "*/+-";
    /**
     * The expression tree which type is BinaryTTree
     */
    protected BinaryTree expTree;
    //Constructor

    /**
     * Expression tree constructor it takes the string as expression and send it  to read binary tree method
     * Does not mather the given string is prefix or postfix form it returns, if the given expression is postfix it reverses the
     * string and send it to read binary tree method.
     * @param expression the given string it accepts prefix or postfix expression
     */
    public ExpressionTree(String expression){
        String[] pieces = expression.split(" ");
        String exp  ="";
        if( isOperator(pieces[0])){
            exp = expression;
        }else {
            for (int i = pieces.length - 1; i >= 0; i--) {
                exp += pieces[i];
                exp += " ";
            }
        }
        Scanner sc = new Scanner(exp);
        expTree = readBinaryTree(sc);
        root=expTree.root;

    }

    /**
     * my eval wrapper method returns the value of expression tree as integer
     * @return It converts the the node from eval helper method and returns it as integer
     */
    public int eval(){
        return Integer.parseInt(eval(this.root).data);
    }

    /**
     * My helper eval method  it takes the node and recursively calculates it according to occurred operator
     * @param nodeRef takes node firstly it takes root of expression tree
     * @return returns a new node and result of expression tree with in it
     */
    private Node eval(Node nodeRef){
        //if node is null returns null
        if (nodeRef == null)
            return null;
        //if node is not null and if it is not an operator it returns the value of it
        if (nodeRef.left == null || nodeRef.right ==null && isNumeric(nodeRef.data))
            return nodeRef;
        //it collects the data of it according to left and right and left children and in the end it sends them in h expression tree
        Node l_val = eval(nodeRef.left);
        Node r_val = eval(nodeRef.right);
        return new Node(operation(nodeRef.data,r_val,l_val));

    }

    /**
     * TO evaluates the operations, i take the children as node and convert them ito integer in operation method
     * @param operator is the operation
     * @param rOperand right node
     * @param lOperand left node
     * @return returns as string the value of operation
     */
    private String operation(String operator, Node rOperand, Node lOperand){
        int lOp;
        int rOp;
        int result = 0;
        lOp= Integer.parseInt(lOperand.data);
        rOp= Integer.parseInt(rOperand.data);
        switch (operator) {
            case "+":
                result = lOp + rOp;
                break;
            case "-":
                result = lOp - rOp;
                break;
            case "*":
                result = lOp * rOp;
                break;
            case "/":
                result = lOp / rOp;
                break;
        }
        //I do not know why but there was a problem when I calculate it as integer so I take it integer and after i returned it as string
        return String.valueOf(result);
    }

    /**
     * To check the given string is operator or not
     * @param operator given string
     * @return returns true if its operator
     */
    protected boolean isOperator(String operator){
        return operators.contains(operator);
    }

    /**
     * to check the data is numeric or not
     * @param data the given string
     * @return returns true if it provides below regular expression
     */
    public boolean isNumeric(String data){
        return  data.matches("-?\\d+(\\.\\d+)?");
    }
    /**
     * Method to read a binary tree
     *It takes the string if it is an operator which means the node can have children but number
     * so each time method call itself and when it reaches the number as last node or it has enough children it returns null
     * also if the end of the string it returns null again
     * I check the next index is number or operator if it is a number i get it and put in the node but since the numbers can not have
     * children i assign nul for its right and left child
     * @return the binary tree
     */
    public BinaryTree readBinaryTree(Scanner exp){
        try {

            String data = exp.next();
            if(data == null || data.equalsIgnoreCase("")){
                return null;
            }else
            if( isNumeric(data)){
                return new BinaryTree(data,null,null);}
            else{

                if (!isOperator(data))
                    throw new IllegalArgumentException();
                BinaryTree rightTree = readBinaryTree(exp);
                BinaryTree leftTree = readBinaryTree(exp);
                return new BinaryTree(data,leftTree,rightTree);
            }
        }catch (Exception x){
            System.out.println("The expression is invalid");
            return null;
        }

    }
}
