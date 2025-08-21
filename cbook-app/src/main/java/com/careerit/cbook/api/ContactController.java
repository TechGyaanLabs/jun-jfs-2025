package com.careerit.cbook.api;

import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cbook")
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDto>> getContacts() {
        return ResponseEntity.ok(contactService.getContacts());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(contactService.getCount());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContactDto>> searchContactsByName(@RequestParam(name = "name",defaultValue = "")
                                                                     String name) {
        return ResponseEntity.ok(contactService.searchContactsByName(name));
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(contactService.getContactById(id));
    }


}
