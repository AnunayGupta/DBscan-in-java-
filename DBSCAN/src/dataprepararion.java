import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class dataprepararion
{
    public static void main(String[] args)
    {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        HashMap<String, Integer> Enum = new HashMap<String, Integer>();
        String file = "/Users/anunay/Desktop/Python/couese_3/fruits.csv";
        String delimiter = "\t";
        String line;
        ArrayList<Fruits> fruits = new ArrayList<>();
        ArrayList<Double> m = new ArrayList<>();
        ArrayList<Double> w = new ArrayList<>();
        ArrayList<Double> h = new ArrayList<>();
        ArrayList<Double> c = new ArrayList<>();
        int countdiff = 1;
        int counter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(delimiter));
                if (counter == 0) {
                    counter++;
                    continue;
                }
                else
                    {
                        if (values.get(2).equals("unknown"))
                        {
                            values.set(2, "spanish_belsan");
                        }
                        Fruits s = new Fruits();
                        // Can be avoided by using a constructor
                        s.fruit_label = Integer.valueOf(values.get(0));
                        s.fruit_name = values.get(1);
                        if (!hm.containsKey(values.get(1))) {
                            hm.put(s.fruit_label, values.get(1));
                        }
                        s.mass = Double.valueOf(values.get(3));
                        m.add(s.mass);
                        s.width = Double.valueOf(values.get(4));
                        w.add(s.width);
                        s.height = Double.valueOf(values.get(5));
                        h.add(s.height);
                        s.color_score = Double.valueOf(values.get(6));
                        c.add(s.color_score);
                        s.sub1 = values.get(2);
                        if (!Enum.containsKey(s.sub1)) {
                            Enum.put(s.sub1, countdiff);
                            countdiff++;
                        }
                        s.no = counter -1 ;
                        counter++ ;
                        fruits.add(s);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Double maxm = Collections.max(m);
        Double maxh = Collections.max(h);
        Double maxw = Collections.max(w);
        Double maxc = Collections.max(c);
        Double minm = Collections.min(m);
        Double minh = Collections.min(h);
        Double minw = Collections.min(w);
        Double minc = Collections.min(c);
        //scaling
        ArrayList<Fruits> clone  = new ArrayList<>();
        Fruits x = new Fruits() ;
        x.mass = 10000.0;
        x.width = 11110.0 ;
        x.height = 111233.0;
        x.color_score = 0.0 ;
        x.no = counter - 1 ;
        x.sub1 = "New" ;
        Enum.put(x.sub1,countdiff) ;
        fruits.add(x) ;
        //Collections.shuffle(fruits, new Random(0));
        for (int i = 0; i < fruits.size(); i++)
        {
            Fruits f = fruits.get(i);
            //f.labeled = Enum.get(f.sub1) ;
            f.mass = (f.mass - minm) / (maxm - minm);
            f.width = (f.width - minw) / (maxw - minw);
            f.height = (f.height - minh) / (maxh - minh);
            f.color_score = (f.color_score - minc) / (maxc - minc);
            fruits.set(i, f);
        }
        //clone.addAll(fruits) ;
        DBSCAN a = new DBSCAN()  ;
        staticmaps.x = Enum ;
        ArrayList<ArrayList<Fruits>> n = a.dbscan(fruits,.7,3) ;
        int counter1 = 0 ;
        for(int i = 0; i< n.size();i++)
        {
            for(int j = 0 ; j < n.get(i).size(); j++)
            {
                System.out.print(counter1 + " ");
                n.get(i).get(j).displayname();
                counter1++ ;
            }
            System.out.println("\n");
        }
        for(Fruits g :fruits)
        {
            if(g.stat == 3)
            {
                g.display();
            }
        }
    }
}







