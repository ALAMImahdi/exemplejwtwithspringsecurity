package ma.formations.domaine;

import ma.formations.service.model.Client;
import ma.formations.service.model.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitConverter {
    public static ProduitVo toVo(Produit bo) {
        if (bo == null || bo.getId() == null)
            return null;
        ProduitVo vo = new ProduitVo();
        vo.setId(bo.getId());
        vo.setName(bo.getName());
        vo.setPrix(bo.getPrix());
        vo.setDescription(bo.getDescription());
        return vo;
    }

    public static Produit toBo(ProduitVo vo) {
        Produit bo = new Produit();
        bo.setId(vo.getId());
        bo.setName(vo.getName());
        bo.setPrix(vo.getPrix());
        bo.setDescription(vo.getDescription());
        return bo;
    }

    public static List<ProduitVo> toListVo(List<Produit> listBo) {
        List<ProduitVo> listVo = new ArrayList<>();
        for (Produit produit : listBo) {
            listVo.add(toVo(produit));
        }
        return listVo;
    }
}
