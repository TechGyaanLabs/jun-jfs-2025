package com.careerit.cbook.api;

import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.records.ContactCount;
import com.careerit.cbook.service.ContactService;
import com.careerit.cbook.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cbook")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public ApiResponse<List<ContactDto>> getContacts() {
        return ApiResponse.success(contactService.getContacts(), "Contacts retrieved successfully");
    }

    @GetMapping("/count")
    public ApiResponse<ContactCount> getCount() {
        return ApiResponse.success(contactService.getCount(), "Contact count retrieved successfully");
    }

    @GetMapping("/search")
    public ApiResponse<List<ContactDto>> searchContactsByName(@RequestParam(name = "name", defaultValue = "") String name) {
        List<ContactDto> contacts = contactService.searchContactsByName(name);
        String message = contacts.isEmpty() ? "No contacts found" : "Contacts found successfully";
        return ApiResponse.success(contacts, message);
    }

    @GetMapping("/contact/{id}")
    public ApiResponse<ContactDto> getContactById(@PathVariable("id") UUID id) {
        ContactDto contact = contactService.getContactById(id);
        return ApiResponse.success(contact, "Contact retrieved successfully");
    }

    @PostMapping("/contact")
    public ApiResponse<ContactDto> createContact(@RequestBody ContactDto contactDto) {
        ContactDto createdContact = contactService.create(contactDto);
        return ApiResponse.success(createdContact, "Contact created successfully");
    }

    @PutMapping("/contact")
    public ApiResponse<ContactDto> updateContact(@RequestBody ContactDto contactDto) {
        ContactDto updatedContact = contactService.update(contactDto);
        return ApiResponse.success(updatedContact, "Contact updated successfully");
    }

    @DeleteMapping("/contact/{id}")
    public ApiResponse<String> deleteContact(@PathVariable("id") UUID id) {
        contactService.delete(id);
        return ApiResponse.success("Contact deleted successfully", "Contact deleted successfully");
    }
}
