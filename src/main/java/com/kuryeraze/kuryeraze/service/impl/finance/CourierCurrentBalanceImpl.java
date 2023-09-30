package com.kuryeraze.kuryeraze.service.impl.finance;

import com.kuryeraze.kuryeraze.dao.finance.CourierCurrentBalanceRepository;
import com.kuryeraze.kuryeraze.dto.finance.CourierCurrentBalanceDto;
import com.kuryeraze.kuryeraze.model.finance.CourierCurrentBalance;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierCurrentBalanceImpl {

    private final CourierCurrentBalanceRepository repository;
    private final ModelMapper modelMapper;

    public CourierCurrentBalanceImpl(CourierCurrentBalanceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    // All
    public List<CourierCurrentBalanceDto> getAllCourierCurrentBalance() {
        List<CourierCurrentBalance> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, CourierCurrentBalanceDto.class))
                .toList();
    }

    // By id
    public CourierCurrentBalanceDto getCourierCurrentBalanceById(Long id) {
        Optional<CourierCurrentBalance> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, CourierCurrentBalanceDto.class)).orElse(null);
    }

    // Save
    public CourierCurrentBalanceDto saveCourierCurrentBalance(CourierCurrentBalanceDto dto) {
        CourierCurrentBalance det = modelMapper.map(dto, CourierCurrentBalance.class);
        det = repository.save(det);
        return modelMapper.map(det, CourierCurrentBalanceDto.class);
    }

    // Delete
    public Boolean deleteCourierCurrentBalance(Long id) {
        Optional<CourierCurrentBalance> optional = repository.findById(id);
        if (optional.isPresent()) {
            CourierCurrentBalance det = optional.get();
            repository.delete(det);
            return true;
        }
        return false;
    }
}
