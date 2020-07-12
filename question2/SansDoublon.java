package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;
public class SansDoublon implements Visiteur<Boolean>{
    
  public Boolean visite(Contributeur c){
    return c.solde()>= 0;
}
public Boolean visite(GroupeDeContributeurs g){
  boolean res = false;
  if(g.nombreDeCotisants()>0)
    {  
      List<Cotisant> diff =sansDoublon(g);
      for(Cotisant c : diff)
      { 
        if(c.accepter(this)){ res= true;} 
      }
    }
      return res;
}
public List<Cotisant> sansDoublon(Cotisant g)
{
  List<Cotisant> diff = new ArrayList<Cotisant>();
      if(g instanceof Contributeur )
      {
          Contributeur cont = (Contributeur)g;
              for(Cotisant c : diff)
              {
                  if(c.nom().equals(cont.nom())) break;
                  else  
                        {diff.add(cont);}
              }
      }
      else if(g instanceof GroupeDeContributeurs)
      {
          GroupeDeContributeurs gc = (GroupeDeContributeurs) g;
          Iterator<Cotisant> it = gc.iterator();
          while(it.hasNext())
          {

              Cotisant t = it.next();

            if(diff.contains(t)) break;
              for(Cotisant c : diff)
              {
                  if(c.nom().equals(gc.nom())) break;
                  else  
                        {sansDoublon(gc);}
              }
          }
      }

      return diff;
  }
}