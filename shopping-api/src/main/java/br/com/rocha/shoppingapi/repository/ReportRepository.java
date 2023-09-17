package br.com.rocha.shoppingapi.repository;


import br.com.rocha.shoppingapi.model.Shop;
import br.com.rocha.shoppingclient.dto.ShopReportDTO;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(final Date dataInicio, final Date dataFim, final Float valorMinimo);
    public ShopReportDTO getReportByDate(final Date dataInicio, final Date dataFim);

}