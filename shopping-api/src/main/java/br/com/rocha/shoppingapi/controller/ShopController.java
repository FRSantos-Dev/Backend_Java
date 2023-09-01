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

import br.com.rocha.shoppingapi.service.ShopService;
import jakarta.validation.Valid;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops() {
        List<ShopDTO> produtos = shopService.getAll();
        return produtos;
    }

    @GetMapping("/shopping/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier) {
        List<ShopDTO> produtos = shopService.getByUser(userIdentifier);
        return produtos;
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
        List<ShopDTO> produtos = shopService.getByDate(shopDTO);
        return produtos;
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
    public List<ShopDTO> getShopsByFilter(
            @RequestParam(name = "startDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date starDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate,
            @RequestParam(name = "minValue", required = false) Float minValue) {
        return shopService.getShopByFilter(startDate, endDate, minValue);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportBydate(
            @RequestParam(name = "startDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
            @RequestParam(name = "endDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        return shopService.getReportByDate(startDate, endDate);
    }

}