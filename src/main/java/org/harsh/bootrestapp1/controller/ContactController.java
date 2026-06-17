package org.harsh.bootrestapp1.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.harsh.bootrestapp1.dto.ContactDTO;
import org.harsh.bootrestapp1.entity.Contact;
import org.harsh.bootrestapp1.services.ContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contacts")
public class ContactController {

	@Autowired
	ContactService contactService;

	@GetMapping("contactById/{cid}")
	public ContactDTO getContactById(@PathVariable("cid") int contactId) {
		return contactService.getContactById(contactId);
	}

	@GetMapping("likename/{name}")
	public List<ContactDTO> getLikeName(@PathVariable("lname") String name) {
		return contactService.getAllLikeName(name);

	}

	@GetMapping("allContacts/{pageno}/{pagesize}")
	public List<ContactDTO> getAllContacts(@PathVariable("pageno") int pageno, @PathVariable("pagesize") int pageSize) {
		return contactService.getAllContacts(pageno, pageSize);
	}

	public List<ContactDTO> getAllContact(int pageNo, int pageSize) {
		Pageable page = PageRequest.of(pageNo - 1, pageSize,
				Sort.by("firstname").ascending().and(Sort.by("lastname").ascending()));
		

		Iterator<Contact> allContact = contactRepository.findAll(page).iterator();

		ArrayList<ContactDTO> allDTO = new ArrayList<>();

		while (allContact.hasNext()) {
			Contact objContact = allContact.next();
			ContactDTO dtoContact = new ContactDTO();

			BeanUtils.copyProperties(objContact, dtoContact);

			allDTO.add(dtoContact);
		}

		return allDTO;
	}
}
