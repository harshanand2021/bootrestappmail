package org.harsh.bootrestapp1.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.harsh.bootrestapp1.dto.ContactDTO;
import org.harsh.bootrestapp1.entity.Contact;
import org.harsh.bootrestapp1.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public ContactDTO getContactById(int id) {
		System.out.println("Contact Repo = " + contactRepository);
		Optional<Contact> optContact = contactRepository.findById(id);

		if (optContact.isPresent()) {
			ContactDTO dtoContact = new ContactDTO();
			BeanUtils.copyProperties(optContact.get(), dtoContact);
			return dtoContact;
		}
		return null;
	}

	@Override
	public List<ContactDTO> getAllContacts(int pageNo, int pageSize) {
		Pageable page = PageRequest.of(pageNo - 1, pageSize);

		Iterator<Contact> allContacts = contactRepository.findAll(page).iterator();
		ArrayList<ContactDTO> allDTO = new ArrayList<>();

		while (allContacts.hasNext()) {
			Contact objContact = allContacts.next();
			ContactDTO dtoContact = new ContactDTO();

			BeanUtils.copyProperties(objContact, dtoContact);
			allDTO.add(dtoContact);
		}

		return allDTO;
	}

	@Override
	public void addNewContact(ContactDTO dto) {
		Contact objContact = new Contact();
		BeanUtils.copyProperties(dto, objContact);
		contactRepository.save(objContact);

	}

	@Override
	public ContactDTO getContactByName(String firstName) {

		Contact objContact = contactRepository.findByFirstName(firstName);

		if (objContact != null) {
			ContactDTO dtoContact = new ContactDTO();
			BeanUtils.copyProperties(objContact, dtoContact);
			return dtoContact;
		}

		return null;
	}

	@Override
	public List<ContactDTO> getAllLikeName(String name) {
		Iterator<ContactDTO> allContacts = contactRepository.findByLikeName(name).iterator();

		ArrayList<ContactDTO> allDTO = new ArrayList<>();

		while (allContacts.hasNext()) {
			ContactDTO objContact = allContacts.next();
			ContactDTO dtoContact = new ContactDTO();

			BeanUtils.copyProperties(objContact, dtoContact);
			allDTO.add(dtoContact);
		}

		return allDTO;
	}

}
