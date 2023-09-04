package br.com.rocha.shoppingapi.repository;


import java.util.Date;
import java.util.List;

import br.com.rocha.shoppingapi.model.Shop;

public interface ReportRepository {

    public List<Shop> getShopByFilters(final Date dataInicio, final Date dataFim, final Float valorMinimo);
    public ShopReportDTO getReportByDate(final Date dataInicio, final Date dataFim);

}