package expression.generic;

public class Main {
    public static void log(final String msg) {
        System.out.println(msg);
    }

    public static Object[][][] eval(final String flag, final String expression) throws Exception {
        final Tabulator tb = new GenericTabulator();
        return tb.tabulate(flag, expression, -2, 2, -2, 2, -2, 2);
    }

    public static void dump(final Object[][][] lst) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.println("x: " + (i - 2) + " y: " + (j - 2) + " z: " + (k - 2) + " = "+ lst[i][j][k]);
                }
            }
        }
    }
    public static void main(String[] args) {

        if (args.length < 2) {
            log("Not enough flags were passed");
        } else {            
            switch(args[0]) {
                case "i": break;
                case "bi": break;
                case "d": break;
                default: throw new IllegalArgumentException("Illegal flag for computation mode");
            }    

            try {
                dump(eval(args[0], args[1]));
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }       
}