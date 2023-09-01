package br.com.rocha.shoppingapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocha.shoppingapi.dto.ShopDTO;
import br.com.rocha.shoppingapi.dto.ShopReportDTO;
import br.com.rocha.shoppingapi.model.Shop;
import br.com.rocha.shoppingapi.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifer) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifer);

        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThanEquals(shopDTO.getDate());

        return shops.stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO) {
        shopDTO.setTotal(shopDTO.getItems()
                .stream()
                .map(x -> x.getPrice())
                .reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = shopRepository.save(shop);

        return shopDTO.convert(shop);
    }

    public List<ShopDTO> getShopsByFilter(Date starDate, Date endDate, Float minValue){
        List<Shop> shops = reportRepository.getShopByFilters(starDate, endDate, minValue);

        return shops
                    .stream()
                    .map(DTOConverter::convert)
                    .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(Date starDate, Date endDate){
        return reportRepository.getReportByDate(starDate, endDate);
    }

}
