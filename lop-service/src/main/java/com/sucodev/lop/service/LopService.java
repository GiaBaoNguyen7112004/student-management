package com.sucodev.lop.service;

import com.sucodev.lop.domain.Lop;
import com.sucodev.lop.payload.request.LopRequest;

import java.util.List;
import java.util.UUID;

public interface LopService {
    Lop createLop(LopRequest lopRequest);
    Lop findLopById(UUID id);
    Lop updateLop(UUID id, LopRequest lopRequest);
    void deleteLopById(UUID id);
    List<Lop> findAllLops();
}


