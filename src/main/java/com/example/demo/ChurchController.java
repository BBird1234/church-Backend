package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ChurchController {

    @Autowired
    private ChurchService churchService;

    @GetMapping("/check")
    public String check() {
        return "Working...!";
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteMember(@PathVariable Long id) {
        return churchService.deleteMember(id);
    }

    @GetMapping("/allmembers")
    public ResponseEntity<List<Church>> getAll() {
        try {
            return new ResponseEntity<>(churchService.getAll(), HttpStatus.OK);
        } catch (NoMemberExistInRepository e) {
            return new ResponseEntity("List Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addmember")
    public ResponseEntity<Church> addMember(@RequestBody Church church) throws IOException {
        Church user = churchService.addmember(church);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get/by/id/{id}")
    public ResponseEntity<Church> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(churchService.getById(id), HttpStatus.OK);
        } catch (NoMemberExistInRepository e) {
            return new ResponseEntity("Member not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Church> updateMember(@PathVariable Long id, @RequestBody Church church) {
        try {
            Church updatedChurch = churchService.updateMember(id, church);
            return new ResponseEntity<>(updatedChurch, HttpStatus.OK);
        } catch (NoMemberExistInRepository e) {
            return new ResponseEntity("Member not found", HttpStatus.NOT_FOUND);
        }
    }
}
