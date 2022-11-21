public class Test {
    public static void main(String[] args) {
        String c,co = "D5";
        System.out.println(co);
        System.out.println(Cordinate.getRowFromCoordinate(co));
        System.out.println(Cordinate.getColumnFromCoordinate(co));

        c = Cordinate.getUp(co);
        System.out.println(c);
        System.out.println(Cordinate.isCordinateValid(c));
        c = Cordinate.getDown(co);
        System.out.println(c);
        System.out.println(Cordinate.isCordinateValid(c));
        c = Cordinate.getRight(co);
        System.out.println(c);
        System.out.println(Cordinate.isCordinateValid(c));
        c = Cordinate.getLeft(co);
        System.out.println(c);
        System.out.println(Cordinate.isCordinateValid(c));



    }
}
