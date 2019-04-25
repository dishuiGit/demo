import gen.CalculatorBaseVisitor;
import gen.CalculatorParser;

public class MyCalculatorVisitor extends CalculatorBaseVisitor<Object> {
    @Override
    public Object visitAddOrSubtract(CalculatorParser.AddOrSubtractContext ctx) {
        Object obj0 = ctx.expr(0).accept(this);
        Object obj1 = ctx.expr(1).accept(this);
        System.out.println("obj0: "+obj0);
        System.out.println("obj1: "+obj1);
        Object res = 0f;
        switch (ctx.getChild(1).getText()) {
            case "+":
                res = (Float)obj0 + (Float)obj1;
                break;
            case "-":
                res = (Float)obj0 - (Float)obj1;
                break;
        }

        return res;
    }

    @Override
    public Object visitMultOrDiv(CalculatorParser.MultOrDivContext ctx) {
        Object obj0 = ctx.expr(0).accept(this);
        Object obj1 = ctx.expr(1).accept(this);
        System.out.println("obj0: "+obj0);
        System.out.println("obj1: "+obj1);
        Object res = 0f;
        switch (ctx.getChild(1).getText()) {
            case "*":
                res = (Float)obj0 * (Float)obj1;
                break;
            case "/":
                res = (Float)obj0 / (Float)obj1;
                break;
        }

        return res;
    }

    @Override
    public Object visitFloat(CalculatorParser.FloatContext ctx) {
        return Float.parseFloat(ctx.getText());
    }
}
