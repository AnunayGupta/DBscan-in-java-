import com.sun.jdi.ArrayReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
1 - Core point
2 - Border point
3 - Noise point
 */
public class DBSCAN{
    public ArrayList<ArrayList<Fruits>> dbscan(ArrayList<Fruits> fruits,ArrayList<Fruits> clone,double eps,int minpts,HashMap <String,Integer> Enum)
    {
        ArrayList<ArrayList<Fruits>> clusterlist = new ArrayList<ArrayList<Fruits>>() ;
        for(int i = 0 ; i  < fruits.size() ; i++)
        {
            if(!fruits.get(i).visited)
            {
                if(iscore(fruits,fruits.get(i), eps,Enum).size()>= minpts)
                {
                    ArrayList<Fruits> x = dbscan_helper(fruits,clone,fruits.get(i),eps,minpts,Enum) ;
                    clusterlist.add(x) ;
                }
                else
                {
                    Fruits g = fruits.get(i) ;
                    g.stat = 3 ;
                    fruits.set(i,g) ;
                    clone.set(g.no,g) ;
                }
            }
        }
        return clusterlist ;
    }
    public ArrayList<Fruits> dbscan_helper(ArrayList<Fruits> fruits,ArrayList<Fruits> clone,  Fruits f , double eps, int minpts , HashMap <String,Integer> Enum)
    {
        Queue<Fruits> q = new LinkedList<>();
        ArrayList<Fruits> k = new ArrayList<>() ;
        q.add(f) ;
        while(!q.isEmpty())
        {
            Fruits r  = q.peek() ;
            q.remove() ;
            ArrayList<Fruits> neighborhood = iscore(fruits,r,eps,Enum) ;
            if(neighborhood.size() >= minpts)
            {
                r.stat = 1 ;
                clone.set(r.no,r) ;
            }
            else
            {
                r.stat = 2 ;
                clone.set(r.no,r) ;
            }
            if(!r.visited)
            {
                r.visited = true ;
                k.add(r) ;
            }
            for(int i = 0 ; i < neighborhood.size();i++)
            {
                if(!(neighborhood.get(i).visited))
                {
                    q.add(neighborhood.get(i)) ;
                }
            }
        }
        return k ;
    }
    public double distance(Fruits f,Fruits g,HashMap <String,Integer> Enum)
    {
        ArrayList<Double> f1 = getfeature(f,Enum) ;
        ArrayList<Double> f2 = getfeature(g,Enum) ;
        double sum = 0 ;
        for(int i = 0 ; i < f1.size();i++){
            sum += Math.pow((f1.get(i) - f2.get(i)),2) ;
        }
        return Math.pow(sum,.5);
    }
    public ArrayList<Double> getfeature(Fruits s, HashMap<String,Integer> Enum){
        ArrayList<Double> q  = new ArrayList<>() ;
        q.add(s.mass) ;
        q.add(s.width) ;
        q.add(s.height) ;
        q.add(s.color_score) ;
        int k  = Enum.get(s.sub1)-1 ;
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
    public ArrayList<Fruits> iscore(ArrayList<Fruits> fruits,Fruits f,double eps,HashMap<String,Integer> Enum)
    {
        ArrayList<Fruits> f1 = new ArrayList<>() ;
        for(int i = 0 ; i < fruits.size();i++)
        {
            if((distance(fruits.get(i),f,Enum)) <= eps)
            {
                f1.add(fruits.get(i)) ;
            }
        }
        return f1 ;
    }

}
