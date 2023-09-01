package br.com.rocha.shoppingapi.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import br.com.rocha.shoppingapi.dto.ShopReportDTO;
import br.com.rocha.shoppingapi.model.Shop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ReportRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date startDate, Date endDate, Float minValue){

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s");
        sb.append(" FROM Shop s");
        sb.append(" WHERE s.DATE >=:startDate");

        if(endDate != null){
            sb.append(" AND s.DATE <=:endDate");
        }
        if(minValue != null){
            sb.append(" AND s.TOTAL <=:minValue");
        }

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("startDate", startDate);
        if(endDate != null){
            query.setParameter("endDate", endDate);
        }
        if(minValue != null){
            query.setParameter("minValue", minValue);
        }
        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(Date startDate, Date endDate){
            
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(sp.id), SUM(sp.TOTAL), AVG(sp.TOTAL)");
            sb.append(" FROM shopping.shop sp");
            sb.append(" WHERE sp.DATE >=:startDate");
            sb.append("and sp.date <= :endDate");

            Query query = entityManager.createNativeQuery(sb.toString());
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);

            Object[] result = (Object[]) query.getSingleResult();
            
            ShopReportDTO shopReportDTO = new ShopReportDTO();
            shopReportDTO.setCount(((BigInteger)result[0]).intValue());
            shopReportDTO.setTotal((Double)result[1]);
            shopReportDTO.setMean((Double)result[2]);

            return shopReportDTO;
            
    }
}
