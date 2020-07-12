package question3;


import java.util.*;
import question1.*;

public class VisiteurRestitution implements question1.Visiteur<Cotisant> { 
    private HashMap<Cotisant, Integer> s; 
    
    public VisiteurRestitution(HashMap<Cotisant, Integer> state)
    {                             
        s=state; 
    } 
    public Cotisant visite(Contributeur c){ 
        int somme = s.get(c);                            
        c.affecterSolde(somme); 
        return c ; 
    } 
    public Cotisant visite(GroupeDeContributeurs g)
    { 
        for(Cotisant c : g.getChildren())
        {
            c.accepter(this); 
        } 
        return g; 
    } 
} 