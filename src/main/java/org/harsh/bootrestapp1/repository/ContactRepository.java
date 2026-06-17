package org.harsh.bootrestapp1.repository;

import java.util.List;

import org.harsh.bootrestapp1.dto.ContactDTO;
import org.harsh.bootrestapp1.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	public Contact findByFirstName(String firstName);

	@Query("Select  object(oContact) from Contact oContact where oContact.firstName LIKE :name%")
	public List<ContactDTO> findByLikeName(String name);
}
