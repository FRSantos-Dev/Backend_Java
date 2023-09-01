package br.com.rocha.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rocha.shoppingapi.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    // recupera as compras de um usuário especifico.
    public List<Shop> findAllByUserIdentifier(String userIdentifier);

    // busca todas as compras que tenham um valor total que o valor passado.
    public List<Shop> findAllByTotalGReaterThan(Float total);

    // retorna todas as compras a partir de uma data especifica.
    public List<Shop> findAllByDateGreaterThanEquals(Date date);
}
