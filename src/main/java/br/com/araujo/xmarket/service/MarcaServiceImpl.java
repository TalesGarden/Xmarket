package br.com.araujo.xmarket.service;

import br.com.araujo.xmarket.dao.MarcaDao;
import br.com.araujo.xmarket.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MarcaServiceImpl implements IMarcaService {

    @Autowired
    public MarcaDao dao;

    @Override
    public Marca criaNovo(Marca novo) {
        if(novo.getNome_marca() != null) {
            return dao.save(novo);
        }
        return null;
    }

    @Override
    public Marca AtualizarDados(Marca dados) {
        if(dados.getId_marca() != null && dados.getNome_marca() != null){
            return dao.save(dados);
        }
        return null;
    }

    @Override
    public ArrayList<Marca> buscarTodos() {
        return (ArrayList<Marca>)dao.findAll();
    }

    @Override
    public Marca buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void excluirMarca(Integer id) {

    }
}
