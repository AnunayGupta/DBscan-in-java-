import java.util.Comparator;

public class Fruits {
    public int fruit_label;
    public String fruit_name = "Unknown";
    public Double mass ;
    public Double width ;
    public Double height;
    public Double color_score ;
    String sub1 ;
    public int stat = - 1 ;
    public int no = 0 ;
    public Boolean visited = false;
    public void display()
    {
        System.out.println("Fruit name is " + fruit_name);
        System.out.println("Fruit label is " + fruit_label);
        System.out.println("Fruit subtype is " + sub1);
        System.out.println("Fruit mass is " + mass);
        System.out.println("Fruit width is " + width);
        System.out.println("Fruit height is " + height);
        System.out.println("Fruit color_score is " + color_score);
        System.out.println("Fruit status is" + stat);
    }
    public void displayname()
    {
        System.out.print(fruit_name +"-" + sub1 + " ");
    }

    /*public static Comparator<Fruits> disscomparator = new Comparator<Fruits>() {
        @Override
        public int compare(Fruits f, Fruits g) {
            return f.distance.compareTo(g.distance);
        }
    };*/
}
