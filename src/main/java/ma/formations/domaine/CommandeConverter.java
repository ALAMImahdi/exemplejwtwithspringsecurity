package ma.formations.domaine;

import ma.formations.service.model.Commande;
import ma.formations.service.model.Produit;

import java.util.ArrayList;
import java.util.List;

public class CommandeConverter {
    public static CommandeVo toVo(Commande bo) {
        if (bo == null || bo.getId() == null)
            return null;
        CommandeVo vo = new CommandeVo();
        vo.setId(bo.getId());
        vo.setDate(bo.getDate());
        return vo;
    }

    public static Commande toBo(CommandeVo vo) {
        Commande bo = new Commande();
        bo.setId(vo.getId());
        bo.setDate(vo.getDate());
        return bo;
    }

    public static List<CommandeVo> toListVo(List<Commande> listBo) {
        List<CommandeVo> listVo = new ArrayList<>();
        for (Commande commande : listBo) {
            listVo.add(toVo(commande));
        }
        return listVo;
    }
}
