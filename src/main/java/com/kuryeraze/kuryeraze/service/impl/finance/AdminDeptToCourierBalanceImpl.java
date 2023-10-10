package com.kuryeraze.kuryeraze.service.impl.finance;

import com.kuryeraze.kuryeraze.dao.finance.AdminDeptToCourierBalanceRepository;
import com.kuryeraze.kuryeraze.dto.finance.AdminDeptToCourierBalanceDto;
import com.kuryeraze.kuryeraze.model.finance.AdminDeptToCourierBalance;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminDeptToCourierBalanceImpl {

    private final AdminDeptToCourierBalanceRepository repository;
    private final ModelMapper modelMapper;

    public AdminDeptToCourierBalanceImpl(AdminDeptToCourierBalanceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    // All
    public List<AdminDeptToCourierBalanceDto> getAllAdminDeptToCourierBalance() {
        List<AdminDeptToCourierBalance> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, AdminDeptToCourierBalanceDto.class))
                .toList();
    }

    // By id
    public AdminDeptToCourierBalanceDto getAdminDeptToCourierById(Long id) {
        Optional<AdminDeptToCourierBalance> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, AdminDeptToCourierBalanceDto.class)).orElse(null);
    }

    // Save
    public AdminDeptToCourierBalanceDto saveAdminDeptToCourier(AdminDeptToCourierBalanceDto dto) {
        AdminDeptToCourierBalance deptToShopBalance = modelMapper.map(dto, AdminDeptToCourierBalance.class);
        deptToShopBalance = repository.save(deptToShopBalance);
        return modelMapper.map(deptToShopBalance, AdminDeptToCourierBalanceDto.class);
    }

    // Delete
    public Boolean deleteAdminDeptToCourier(Long id) {
        Optional<AdminDeptToCourierBalance> optional = repository.findById(id);
        if (optional.isPresent()) {
            AdminDeptToCourierBalance deptToShopBalance = optional.get();
            repository.delete(deptToShopBalance);
            return true;
        }
        return false;
    }
}
