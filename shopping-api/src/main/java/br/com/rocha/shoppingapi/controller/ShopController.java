package br.com.rocha.shoppingapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocha.shoppingapi.dto.ShopDTO;
import br.com.rocha.shoppingapi.dto.ShopReportDTO;
import br.com.rocha.shoppingapi.service.ShopService;
import jakarta.validation.Valid;

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
    public ShopDTO getShopById(@PathVariable long id) {

        return shopService.findById(id);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO) {

        return shopService.save(shopDTO);
    }

    @GetMapping('/shopping/search')
    public List<ShopDTO>getShopsByFilter(
        @RequestParam(name = "startDate", required =true)
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date startDate,
        @RequestParam(name = "endDate", required =false)
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date endDate,
        @RequestParam(name = "minValue", required =false)
        Float minValue)
        {
            return shopService.getShopsByFilter(startDate, endDate, minValue);
        }

        @GetMapping("/shopping/report")
        public ShopReportDTO getReportByDate(
            @RequestParam(name = "startDate", required =true)
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            Date startDate,
            @RequestParam(name = "endDate", required =false)
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            Date endDate)
            {
                return shopService.getReportByDate(startDate, endDate);
            }

}
