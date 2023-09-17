package br.com.rocha.shoppingapi.service;

import br.com.rocha.shoppingapi.converter.DTOConverter;
import br.com.rocha.shoppingapi.model.Shop;
import br.com.rocha.shoppingapi.repository.ShopRepository;
import br.com.rocha.shoppingclient.dto.ItemDTO;
import br.com.rocha.shoppingclient.dto.ProductDTO;
import br.com.rocha.shoppingclient.dto.ShopDTO;
import br.com.rocha.shoppingclient.dto.ShopReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(final String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(final ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public ShopDTO findById(final long id) {
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent()) {
            return DTOConverter.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(final ShopDTO shopDTO, final String key) {
        userService.getUserByCpf(shopDTO.getUserIdentifier(), key);
        validateProducts(shopDTO.getItems());
        shopDTO.setTotal(shopDTO.getItems().stream().map(x -> x.getPrice()).reduce((float) 0, Float::sum));
        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = shopRepository.save(shop);
        return DTOConverter.convert(shop);
    }

    public List<ShopDTO> getShopByFilter(final Date startDate, final Date endDate, final Float minValue) {
        List<Shop> shops = shopRepository.getShopByFilters(startDate, endDate, minValue);
        return shops.stream().map(DTOConverter::convert).collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(final Date startDate, final Date endDate) {
        return shopRepository.getReportByDate(startDate, endDate);
    }

    private boolean validateProducts(final List<ItemDTO> items) {
        for (ItemDTO item : items) {
            ProductDTO productDTO = productService.getProductByIdentifier(item.getProductIdentifier());
            if (productDTO == null) {
                return false;
            }
            item.setPrice(productDTO.getPrice());
        }
        return true;
    }

}