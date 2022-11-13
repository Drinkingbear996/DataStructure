package 算法.单源最短路径;

/**
 * 航班类
 */
public class Flight {
    private String start, end;
    private int id, price;

    private Flight(int i, String s, String e, int p) {
        id = i; start = s; end = e; price = p;
    }

    // 获取唯一标识符（id）
    public int getId() {
        return id;
    }

    // 获取起点名称
    public String getStart() {
        return start;
    }

    // 获取终点名称
    public String getEnd() {
        return end;
    }

    // 获取从起点到终点的机票价格
    public int getPrice() {
        return price;
    }

    // 读入测试数据，转换成对象数组类型
    public static Flight[] readInput(String s) {
        String[] tokens = s.substring(2, s.length() - 2)
            .split("\\]\\,\\[");
        Flight[] fs = new Flight[tokens.length];
        for (int i = 0; i < tokens.length; ++i) {
            String[] t = tokens[i].split("\\,");
            if ('0' <= t[0].charAt(0) && t[0].charAt(0) <= '9') {
                int a = Integer.parseInt(t[0]), 
                    b = Integer.parseInt(t[1]),
                    c = Integer.parseInt(t[2]);
                fs[i] = new Flight(i, FlightEX.convertToTitle(a), FlightEX.convertToTitle(b), c);
            } else {
                int c = Integer.parseInt(t[2]);
                fs[i] = new Flight(i, t[0], t[1], c);
            }
        }

        return fs;
    }
}

final class FlightEX {
    // 力扣168：数字转EXCEL表格列头序号，用于数字转字母名称
    public static String convertToTitle(int n) {
        if (n == 0) return "0";
        String s = "";
        while (n-- > 0) {
            s = "" + (char)(n % 26 + 65) + s;
            n /= 26;
        }
        return s;
    }
}
