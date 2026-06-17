package org.harsh.bootrestapp1.services;

import java.util.List;

import org.harsh.bootrestapp1.dto.ContactDTO;

public interface ContactService {

	public ContactDTO getContactById(int id);

	public List<ContactDTO> getAllContacts(int pageNo, int pageSize);

	public void addNewContact(ContactDTO dto);

	public ContactDTO getContactByName(String firstName);

	public List<ContactDTO> getAllLikeName(String name);
}
