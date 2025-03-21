package com.sucodev.web.endpoint;


import com.sucodev.lop.domain.Lop;
import com.sucodev.lop.payload.request.LopRequest;
import com.sucodev.lop.service.LopService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@RestController
@RequestMapping("/v1/lops")
public class LopController {


    private final LopService lopService;


    @PostMapping
    public Lop createLop(@RequestBody LopRequest lopRequest) {
        return lopService.createLop(lopRequest);
    }


    @PatchMapping("/{lopId}")
    public Lop updateLop(@PathVariable("lopId") UUID lopId, @RequestBody LopRequest lopRequest) {
        return lopService.updateLop(lopId, lopRequest);
    }


    @DeleteMapping("/{lopId}")
    public void deleteLop(@PathVariable("lopId") UUID lopId) {
        lopService.deleteLopById(lopId);
    }


    @GetMapping
    public List<Lop> getLops() {
        return lopService.findAllLops();
    }
}
