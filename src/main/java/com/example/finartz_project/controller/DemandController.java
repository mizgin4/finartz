//package com.example.finartz_project.controller;
//
//import com.example.finartz_project.controller.request.CreateDemandRequest;
//import com.example.finartz_project.controller.response.DemandResponse;
//import com.example.finartz_project.service.DemandService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/demand")//kaldrı
//public class DemandController {
//    private final DemandService demandService;
//
////member'a taşınacaklar
//    public DemandController(DemandService demandService) {
//        this.demandService = demandService;
//    }
//
//    //updating
//    //@PostMapping(value = DemandControllerEndpoint.CREATE_DEMAND)
//    @PostMapping("/demandrequest")
//    public ResponseEntity<DemandResponse> createDemand(@RequestBody CreateDemandRequest request) {
//        return ResponseEntity.ok(demandService.createDemand(request));
//
//    }
//
//
//}
//
//
//
