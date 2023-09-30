package com.kuryeraze.kuryeraze.service.impl.finance;

import com.kuryeraze.kuryeraze.dao.finance.AdminDeptToShopBalanceRepository;
import com.kuryeraze.kuryeraze.dto.finance.AdminDeptToShopBalanceDto;
import com.kuryeraze.kuryeraze.model.finance.AdminDeptToShopBalance;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminDeptToShopBalanceImpl {

    private final AdminDeptToShopBalanceRepository repository;
    private final ModelMapper modelMapper;

    public AdminDeptToShopBalanceImpl(AdminDeptToShopBalanceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    // All
    public List<AdminDeptToShopBalanceDto> getAllAdminDeptToShopBalance() {
        List<AdminDeptToShopBalance> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, AdminDeptToShopBalanceDto.class))
                .toList();
    }

    // By id
    public AdminDeptToShopBalanceDto getAdminDeptToShopById(Long id) {
        Optional<AdminDeptToShopBalance> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, AdminDeptToShopBalanceDto.class)).orElse(null);
    }

    // Save
    public AdminDeptToShopBalanceDto saveAdminDeptToShop(AdminDeptToShopBalanceDto dto) {
        AdminDeptToShopBalance deptToShopBalance = modelMapper.map(dto, AdminDeptToShopBalance.class);
        deptToShopBalance = repository.save(deptToShopBalance);
        return modelMapper.map(deptToShopBalance, AdminDeptToShopBalanceDto.class);
    }

    // Delete
    public Boolean deleteAdminDeptToShop(Long id) {
        Optional<AdminDeptToShopBalance> optional = repository.findById(id);
        if (optional.isPresent()) {
            AdminDeptToShopBalance deptToShopBalance = optional.get();
            repository.delete(deptToShopBalance);
            return true;
        }
        return false;
    }
}
