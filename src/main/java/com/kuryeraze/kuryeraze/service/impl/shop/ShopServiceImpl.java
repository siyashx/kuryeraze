package com.kuryeraze.kuryeraze.service.impl.shop;

import com.kuryeraze.kuryeraze.dao.shop.ShopRepository;
import com.kuryeraze.kuryeraze.dto.shop.ShopDto;
import com.kuryeraze.kuryeraze.model.shop.Shop;
import com.kuryeraze.kuryeraze.service.inter.shop.ShopServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopServiceInter {

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<ShopDto> createShop(ShopDto shopDto) {
        Shop shopEntity = modelMapper.map(shopDto, Shop.class);
        if (isShopEmailTaken(shopEntity.getEmail()) || isShopUsernameTaken(shopEntity.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        shopEntity.setIsDisable(false);
        Shop savedShop = shopRepository.save(shopEntity);
        return ResponseEntity.ok(modelMapper.map(savedShop, ShopDto.class));
    }

    @Override
    public List<ShopDto> getAllShops() {
        List<ShopDto> listDto = new ArrayList<>();

        List<Shop> listEntity = shopRepository.findAll();

        for (Shop entity : listEntity) {
            ShopDto dto = modelMapper.map(entity, ShopDto.class);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public ShopDto getShopById(Long id) {
        Shop entity = shopRepository.findById(id).orElse(null);
        if (entity != null) {
            return modelMapper.map(entity, ShopDto.class);
        }
        return null;
    }

    @Override
    public Boolean isShopEmailTaken(String email) {
        return shopRepository.findShopByEmail(email) != null;
    }

    @Override
    public Boolean isShopUsernameTaken(String username) {
        return shopRepository.findShopByUsername(username) != null;
    }

    @Override
    public ShopDto findShopByEmail(String email) {
        Shop shop = shopRepository.findShopByEmail(email);
        if (shop != null) {
            return modelMapper.map(shop, ShopDto.class);
        }
        return null;
    }

    @Override
    public ShopDto findShopByUsername(String username) {
        Shop shop = shopRepository.findShopByUsername(username);
        if (shop != null) {
            return modelMapper.map(shop, ShopDto.class);
        }
        return null;
    }

    @Override
    public ShopDto updateShop(Long id, ShopDto shopDto) {
        Optional<Shop> shopOptional = shopRepository.findById(id);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();

            if (shopDto.getOneSignal() != null) {
                shop.setOneSignal(shopDto.getOneSignal());
            }
            if (shopDto.getFirstName() != null) {
                shop.setFirstName(shopDto.getFirstName());
            }
            if (shopDto.getLocation() != null) {
                shop.setLocation(shopDto.getLocation());
            }
            if (shopDto.getPhoneNumber() != null) {
                shop.setPhoneNumber(shopDto.getPhoneNumber());
            }
            if (shopDto.getLatLong() != null) {
                shop.setLatLong(shopDto.getLatLong());
            }
            if (shopDto.getUsername() != null) {
                shop.setUsername(shopDto.getUsername());
            }
            if (shopDto.getEmail() != null) {
                shop.setEmail(shopDto.getEmail());
            }
            if (shopDto.getPassword() != null) {
                shop.setPassword(shopDto.getPassword());
            }

            if (shopDto.getCreatedDate() != null) {
                shop.setCreatedDate(shopDto.getCreatedDate());
            }

            if (shopDto.getIsDisable() != null) {
                shop.setIsDisable(shopDto.getIsDisable());
            }

            shop = shopRepository.save(shop);
            return modelMapper.map(shop, ShopDto.class);


        }
        return null;
    }

    @Override
    public void deleteShopById(Long id) {
        shopRepository.deleteById(id);
    }


}
