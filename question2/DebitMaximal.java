package question2;
import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import question1.Cotisant;
import java.util.*;
public class DebitMaximal implements Visiteur<Integer>{

    public Integer visite(Contributeur c){
        if(c == null)return 0;
        return c.solde();
    }

    public Integer visite(GroupeDeContributeurs g){
        int res = 0;
        if(g == null)
            return res;
        List<Cotisant> liste = g.getChildren();
        res = liste.get(0).accepter(this);
        for(Cotisant cotisant : liste.subList(1, liste.size())){
            Integer valeurDuSolde = cotisant.accepter(this);
            if(valeurDuSolde < res)
                res = valeurDuSolde;
        }
        return res ;
    }
}