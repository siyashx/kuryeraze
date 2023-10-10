package com.kuryeraze.kuryeraze.service.impl.finance;

import com.kuryeraze.kuryeraze.dao.finance.ShopDeptToAdminBalanceRepository;
import com.kuryeraze.kuryeraze.dto.finance.ShopDeptToAdminBalanceDto;
import com.kuryeraze.kuryeraze.model.finance.ShopDeptToAdminBalance;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopDeptToAdminBalanceImpl {

    private final ShopDeptToAdminBalanceRepository repository;
    private final ModelMapper modelMapper;

    public ShopDeptToAdminBalanceImpl(ShopDeptToAdminBalanceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    // All
    public List<ShopDeptToAdminBalanceDto> getAllShopDeptToAdmin() {
        List<ShopDeptToAdminBalance> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, ShopDeptToAdminBalanceDto.class))
                .toList();
    }

    // By id
    public ShopDeptToAdminBalanceDto getShopDeptToAdminBalanceById(Long id) {
        Optional<ShopDeptToAdminBalance> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, ShopDeptToAdminBalanceDto.class)).orElse(null);
    }

    // Save
    public ShopDeptToAdminBalanceDto saveShopDeptToAdminBalance(ShopDeptToAdminBalanceDto dto) {
        ShopDeptToAdminBalance det = modelMapper.map(dto, ShopDeptToAdminBalance.class);
        det = repository.save(det);
        return modelMapper.map(det, ShopDeptToAdminBalanceDto.class);
    }

    // Delete
    public Boolean deleteShopDeptToAdminBalance(Long id) {
        Optional<ShopDeptToAdminBalance> optional = repository.findById(id);
        if (optional.isPresent()) {
            ShopDeptToAdminBalance det = optional.get();
            repository.delete(det);
            return true;
        }
        return false;
    }
}
