package com.photonInfotech.citiBankPOC.repository;

import com.photonInfotech.citiBankPOC.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/*
The JPA Based DAL implementation. The DAL should provide necessary query to
satisfy the operation per the requirement. Note again, while this implementation is using
JPA, there are other option to implement the DAL.
*/
public interface AccountDAL extends JpaRepository<Account, Long> {

	//Primary Key based search
	Account findById(long id);

	//SAmple of implementation in JPA to allow custom made query
	@Query(value =  "SELECT * FROM account b inner JOIN address a ON b.id = a.account_id"
			+ " inner JOIN accounttypes c ON b.id = c.account_id "
			+ " inner JOIN addresstypes d ON d.address_id=a.id Where b.enabled = true", nativeQuery = true)
	List<Account> getAllAccountsInfo();


	@Query(
			value="SELECT * FROM account b inner JOIN address a ON b.id = a.account_id"
					+ " inner JOIN accounttypes c ON b.id = c.account_id "
					+ " inner JOIN addresstypes d ON d.address_id=a.id Where b.enabled = true and b.id=:account_id ",
			nativeQuery=true)
	Account getAccountById(@Param("account_id")long id);

}


