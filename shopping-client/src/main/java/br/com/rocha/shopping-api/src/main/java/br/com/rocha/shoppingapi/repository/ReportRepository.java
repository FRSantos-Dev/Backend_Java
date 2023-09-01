package br.com.rocha.shoppingapi.repository;

import java.util.Date;
import java.util.List;

import br.com.rocha.shoppingapi.dto.ShopReportDTO;
import br.com.rocha.shoppingapi.model.Shop;

public interface ReportRepository {

    public List<Shop>getShopByFilters(Date startDate, Date endDate, Float minValue);

    public ShopReportDTO gReportDTOByDate(Date startDate, Date endDate);
    
}
