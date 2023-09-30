package com.kuryeraze.kuryeraze.service.impl.finance;

import com.kuryeraze.kuryeraze.dao.finance.CourierDeptToAdminBalanceRepository;
import com.kuryeraze.kuryeraze.dto.finance.CourierDeptToAdminBalanceDto;
import com.kuryeraze.kuryeraze.model.finance.CourierDeptToAdminBalance;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierDeptToAdminBalanceImpl {

    private final CourierDeptToAdminBalanceRepository repository;
    private final ModelMapper modelMapper;

    public CourierDeptToAdminBalanceImpl(CourierDeptToAdminBalanceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    // All
    public List<CourierDeptToAdminBalanceDto> getAllCourierDeptToAdmin() {
        List<CourierDeptToAdminBalance> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, CourierDeptToAdminBalanceDto.class))
                .toList();
    }

    // By id
    public CourierDeptToAdminBalanceDto getCourierDeptToAdminBalanceById(Long id) {
        Optional<CourierDeptToAdminBalance> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, CourierDeptToAdminBalanceDto.class)).orElse(null);
    }

    // Save
    public CourierDeptToAdminBalanceDto saveCourierDeptToAdminBalance(CourierDeptToAdminBalanceDto dto) {
        CourierDeptToAdminBalance det = modelMapper.map(dto, CourierDeptToAdminBalance.class);
        det = repository.save(det);
        return modelMapper.map(det, CourierDeptToAdminBalanceDto.class);
    }

    // Delete
    public Boolean deleteCourierDeptToAdminBalance(Long id) {
        Optional<CourierDeptToAdminBalance> optional = repository.findById(id);
        if (optional.isPresent()) {
            CourierDeptToAdminBalance det = optional.get();
            repository.delete(det);
            return true;
        }
        return false;
    }
}
