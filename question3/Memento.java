package question3;

import question1.*;
import java.util.*;

public class Memento {
    private HashMap<Cotisant,Integer> s; 
     // Note : Un usage du patron Memento, 
     //        d�un premier visiteur pour la sauvegarde et 
     //        d�un second pour la restitution du composite, 
     //        repr�sentent une solution possible. 
     
     public Memento(Cotisant c) {
      s = c.accepter(new VisiteurSauvegarde()); 
     }

     public void setState(Cotisant c) {
      c.accepter(new VisiteurRestitution(s));      
      }
    
    }