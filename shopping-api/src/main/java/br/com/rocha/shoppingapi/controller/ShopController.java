package br.com.rocha.shoppingapi.controller;

import br.com.rocha.shoppingapi.service.ShopService;
import br.com.rocha.shoppingclient.dto.ShopDTO;
import br.com.rocha.shoppingclient.dto.ShopReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;



@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops() {
        List<ShopDTO> products = shopService.getAll();
        return products;
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier) {
        List<ShopDTO> products = shopService.getByUser(userIdentifier);
        return products;
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
        List<ShopDTO> products = shopService.getByDate(shopDTO);
        return products;
    }

    @GetMapping("/shopping/{id}")
    public ShopDTO findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(@RequestHeader(name = "key", required = true) String key,
                            @RequestBody ShopDTO shopDTO) {
        return shopService.save(shopDTO, key);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopsByFilter(@RequestParam(name = "startDate", required = true)
                                            @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                            @RequestParam(name = "endDate", required = false)
                                            @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate,
                                            @RequestParam(name = "minValue", required = false) Float minValue) {
        return shopService.getShopByFilter(startDate, endDate, minValue);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportBydate(@RequestParam(name = "startDate", required = true)
                                            @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
                                         @RequestParam(name = "endDate", required = true)
                                            @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        return shopService.getReportByDate(startDate, endDate);
    }
}