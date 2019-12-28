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
    public ArrayList<ArrayList<Fruits>> dbscan(ArrayList<Fruits> fruits,double eps,int minpts,HashMap <String,Integer> Enum)
    {
        ArrayList<ArrayList<Fruits>> clusterlist = new ArrayList<ArrayList<Fruits>>() ;
        for(int i = 0 ; i  < fruits.size() ; i++)
        {
            if(!fruits.get(i).visited)
            {
                if(iscore(fruits,fruits.get(i), eps,Enum).size()>= minpts)
                {
                    ArrayList<Fruits> x = dbscan_helper(fruits,fruits.get(i),eps,minpts,Enum) ;
                    clusterlist.add(x) ;
                }
                else
                {
                    Fruits g = fruits.get(i) ;
                    g.stat = 3 ;
                    fruits.set(g.no,g) ;
                }
            }
        }
        return clusterlist ;
    }
    public ArrayList<Fruits> dbscan_helper(ArrayList<Fruits> fruits,Fruits f , double eps, int minpts , HashMap <String,Integer> Enum)
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
                fruits.set(r.no,r) ;
            }
            else
            {
                r.stat = 2 ;
                fruits.set(r.no,r) ;
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
    public ArrayList<Fruits> iscore(ArrayList<Fruits> fruits,Fruits f,double eps,HashMap<String,Integer> Enum)
    {
        ArrayList<Fruits> f1 = new ArrayList<>() ;
        for(int i = 0 ; i < fruits.size();i++)
        {
            if(f.distance(fruits.get(i),Enum) <= eps)
            {
                f1.add(fruits.get(i)) ;
            }
        }
        return f1 ;
    }

}
