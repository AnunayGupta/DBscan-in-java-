import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

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

    public ArrayList<Double> getfeature(HashMap<String,Integer> Enum){
        ArrayList<Double> q  = new ArrayList<>() ;
        q.add(mass) ;
        q.add(width) ;
        q.add(height) ;
        q.add(color_score) ;
        int k  = Enum.get(sub1)-1 ;
        for(int i = 0 ; i < Enum.size() ; i++){
            if(i == k){
                q.add(1.0);
            }
            else{
                q.add(0.0) ;
            }
        }
        return q ;
    }
    public double distance(Fruits f,HashMap <String,Integer> Enum)
    {
        ArrayList<Double> f1 = this.getfeature(Enum) ;
        ArrayList<Double> f2 = f.getfeature(Enum) ;
        double sum = 0 ;
        for(int i = 0 ; i < f1.size();i++){
            sum += Math.pow((f1.get(i) - f2.get(i)),2) ;
        }
        return Math.pow(sum,.5);
    }
}
