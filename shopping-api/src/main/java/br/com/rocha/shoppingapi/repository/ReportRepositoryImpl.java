package br.com.rocha.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import br.com.rocha.shoppingapi.model.Shop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date startDate, Date endDate, Float minValue) {
        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.date >= :startDate ");

        if (endDate != null) {
            sb.append("and s.date <= :endDate ");
        }

        if (minValue != null) {
            sb.append("and s.total >= :minValue");
        }

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("startDate", startDate);

        if (endDate != null) {
            query.setParameter("endDate", endDate);
        }

        if (minValue != null) {
            query.setParameter("minValue", minValue);
        }

        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(Date starDate, Date endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        sb.append("from shop sp ");
        sb.append("where sp.date >= :startDate ");
        sb.append("and sp.date <= :endDate ");

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        Object[] result = (Object[]) query.getSingleResult();

        ShopReportDTO shopReportDTO = new ShopReportDTO();
        shopReportDTO.setCount(((Long) result[0]).intValue());
        shopReportDTO.setTotal((Double) result[1]);
        shopReportDTO.setMean((Double) result[2]);

        return shopReportDTO;
    }

}