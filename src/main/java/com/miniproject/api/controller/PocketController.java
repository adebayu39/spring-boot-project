package com.miniproject.api.controller;

import com.miniproject.api.entity.Pocket;
import com.miniproject.api.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PocketController {

    @Autowired
    PocketService pocketService;

    @GetMapping("/pockets/{id}")
    public Pocket getPocketById(@PathVariable String id) {
        return pocketService.getPocketById(id);
    }

    @PostMapping("/pockets")
    public Pocket savePocket(@RequestBody Pocket pocket) {
        return pocketService.savePocket(pocket);
    }

    @PutMapping("/pockets")
    public Pocket editPocket(@RequestBody Pocket pocket) {
        return pocketService.editPocket(pocket);
    }

    @DeleteMapping("/pockets")
    public void deletePocket(@RequestParam(name = "id") String id) {
        pocketService.deletePocket(id);
    }

}
