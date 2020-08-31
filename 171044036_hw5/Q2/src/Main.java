public class Main {
    public static void main(String[] args) throws Exception {
        ExpressionTree expTreePost = new ExpressionTree("10 5 15 * + 20 +");
        ExpressionTree expTreePre = new ExpressionTree("+ + 10 * 5 15 20");


        System.out.println("Prefix test for  + + 10 * 5 15 20");
        System.out.println("toString method");
        System.out.println(expTreePre.toString());

        System.out.println("toString2 method");
        System.out.println(expTreePre.toString2());

        System.out.println("result of evaluation");
        System.out.println(expTreePre.eval());


        System.out.println("==================================");


        System.out.println("Postfix test for  10 5 15 * + 20 +");
        System.out.println("toString method");
        System.out.println(expTreePost.toString());

        System.out.println("toString2 method");
        System.out.println(expTreePost.toString2());

        System.out.println("result of evaluation");
        System.out.println(expTreePost.eval());

        ExpressionTree invalidExp = new ExpressionTree("10 5 X * + 20 +");

        ExpressionTree expTreePost2 = new ExpressionTree("10 2 8 * + 3 -");
        ExpressionTree expTreePre2 = new ExpressionTree("+ 9 * 2 6");

        System.out.println("Postfix for 10 2 8 * + 3 - must be 23");
        System.out.println(expTreePost2.eval());

        System.out.println("Prefix for + 9 * 2 6 must be 21");
        System.out.println(expTreePre2.eval());



    }
}
