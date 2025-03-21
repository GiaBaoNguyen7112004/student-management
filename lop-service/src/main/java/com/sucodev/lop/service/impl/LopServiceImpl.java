package com.sucodev.lop.service.impl;

import com.sucodev.lop.domain.Lop;
import com.sucodev.lop.payload.request.LopRequest;
import com.sucodev.lop.repository.LopRepository;
import com.sucodev.lop.service.LopService;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class LopServiceImpl implements LopService {
    private final LopRepository lopRepository;

    @Override
    public Lop createLop(LopRequest lopRequest) {
        Lop lop = new Lop();
        lop.setName(lopRequest.getName());
        return lopRepository.save(lop);
    }


    @Override
    public Lop findLopById(UUID id) {
        return lopRepository.findById(id).orElse(null);
    }


    @Override
    public Lop updateLop(UUID id, LopRequest lopRequest) {
        Lop lop = lopRepository.findById(id).orElse(null);
        lop.setName(lopRequest.getName());
        return lopRepository.save(lop);
    }


    @Override
    public void deleteLopById(UUID id) {
        Lop lop = lopRepository.findById(id).orElse(null);
        lopRepository.delete(lop);
    }


    @Override
    public List<Lop> findAllLops() {
        return lopRepository.findAll();
    }
}
