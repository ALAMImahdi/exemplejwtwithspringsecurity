package ma.formations.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.formations.service.model.Client;

public class ClientConverter {
	public static ClientVo toVo(Client bo) {
		if (bo == null || bo.getId() == null)
			return null;
		ClientVo vo = new ClientVo();
		vo.setId(bo.getId());
		vo.setName(bo.getName());
		vo.setAdresse(bo.getAdresse());
		vo.setEmail(bo.getEmail());
		vo.setTel(bo.getTel());
		return vo;
	}

	public static Client toBo(ClientVo vo) {
		Client bo = new Client();
		bo.setId(vo.getId());
		bo.setName(vo.getName());
		bo.setAdresse(vo.getAdresse());
		bo.setEmail(vo.getEmail());
		bo.setTel(vo.getTel());
		return bo;
	}

	public static List<ClientVo> toListVo(List<Client> listBo) {
		List<ClientVo> listVo = new ArrayList<>();
		for (Client client : listBo) {
			listVo.add(toVo(client));
		}
		return listVo;
	}
}
