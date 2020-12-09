package edu.cdu.ppj.chapter7;


import java.util.Stack;

/**
 *  * 使用栈完成的简单四则运算，不带有任何括号
 *  * 测试时，请输入标准的四则运算式
 *  * 待优化的地方很多，各位大神，多提意见
 *  * @author 任强
 *  *
 *  
 */
public class TestStackSimpleOperation {


    public static void main(String[] args) {
        //简单语法
        // Stack<String> stack = new Stack<>();//创建一个栈，字符串类型
        //
        // stack.push("a");//压栈
        // stack.push("b");
        // stack.push("c");
        //
        // while(!stack.empty()){//判断是否为空
        // String s = stack.pop();//弹栈
        // System.out.println(s);
        // }
        //另一种遍历栈的方法
        // Iterator<String> it = stack.iterator();
        // while(it.hasNext()){
        // String s = it.next();
        // System.out.println(s);
        // }
        //测试自己编写的方法
        // System.out.println(simpleOperation("1+2+3*5+4*6-7/7+1"));//42
        // System.out.println(simpleOperation("1*2*3*4*5*6+1+2*5+9*6+9"));//794
        // System.out.println(simpleOperation("5+6/3*8-9+45*67+95/5+8-85"));//2969
        System.out.println(simpleOperation("1+2+3-4+5*6-7+8-9*6/2/1+99/33*55-951"));//-780
    }

    /**
     * 简单四则运算
     *
     * @param equation 四则运算式
     * @return 运算结果
     */
    public static int simpleOperation(String equation) {
        Stack<Integer> nums = new Stack<>();//保存运算数字的栈
        Stack<String> symbols = new Stack<>();//保存运算符号的栈
        while (equation != null && equation.length() > 0) {
            int symIndex = getLastIndex(equation);
            if (symIndex == -1) {//表示已经到了运算式的结尾，需要返回结果了
                int num = Integer.valueOf(equation);
                int r = getResult(num, symbols.pop(), nums.pop());
                while (!symbols.empty()) {
                    r = getResult(r, symbols.pop(), nums.pop());
                }
                return r;
            }
            int num = Integer.valueOf(equation.substring(0, symIndex));
            nums.push(num);
            String sym = equation.substring(symIndex, symIndex + 1);
            //完成计算流程
            String lastSym = symbols.empty() ? null : symbols.peek();//获取前一个运算符
            //前一个运算符存在，且它的等级是不小于当前运算符，就进行一次运算，
            //把数字栈中的后两个元素弹栈操作，使用前一个运算符完成计算
            //使用while的原因是可能在符号栈中需要继续进行往前一步的运算
            while (lastSym != null && getLevel(lastSym) >= getLevel(sym)) {
                nums.push(getResult(nums.pop(), symbols.pop(), nums.pop()));
                lastSym = symbols.empty() ? null : symbols.peek();
            }
            symbols.push(sym);
            equation = equation.substring(symIndex + 1);
        }
        return 0;
    }

    //计算结果，因为是弹栈操作，所有后弹出的数字在运算符前面
    private static int getResult(int a, String sym, int b) {
        switch (sym) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            default:
                return b / a;
        }
    }

    //运算符等级，等级越高需要越先完成计算
    private static int getLevel(String sym) {
        return sym.equals("+") || sym.equals("-") ? 1 : 2;
    }

    //最接近运算式起始的符号位置，用来确定马上要参与运算的数字和该数字之后的运算符
    private static int getLastIndex(String equation) {
        int addIndex = equation.indexOf("+");
        int symIndex = -1;
        if (addIndex > -1) {
            symIndex = addIndex;
        }
        int subIndex = equation.indexOf("-");
        if (subIndex > -1 && (symIndex == -1 || symIndex > subIndex)) {
            symIndex = subIndex;
        }
        int mulIndex = equation.indexOf("*");
        if (mulIndex > -1 && (symIndex == -1 || symIndex > mulIndex)) {
            symIndex = mulIndex;
        }
        int divIndex = equation.indexOf("/");
        if (divIndex > -1 && (symIndex == -1 || symIndex > divIndex)) {
            symIndex = divIndex;
        }
        return symIndex;
    }
}
