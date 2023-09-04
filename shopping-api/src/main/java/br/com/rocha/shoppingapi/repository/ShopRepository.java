package br.com.rocha.shoppingapi.repository;



import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rocha.shoppingapi.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    public List<Shop> findAllByUserIdentifier(final String userIdentifier);
    public List<Shop> findAllByTotalGreaterThan(final Float total);
    List<Shop> findAllByDateGreaterThan(final Date date);

}