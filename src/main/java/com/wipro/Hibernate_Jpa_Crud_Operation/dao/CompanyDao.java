package com.wipro.Hibernate_Jpa_Crud_Operation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.wipro.Hibernate_Jpa_Crud_Operation.dto.Company;


/**
 * @author Irfan
 */

public class CompanyDao {
	
	/**
	 * This line is used to read the connection from persistence.xml file where jpa is persistence unit name...
	 */
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Company saveCompanyDao(Company company) {
		et.begin();
		em.persist(company);
		et.commit();
	
		return company;
	}
	/**
	 * Select * form company where id=?;
	 * @param id
	 * @return
	 */
	public Company getCompanyByIdDao(int id) {

		return em.find(Company.class, id);
	}
	/**
	 * 
	 * 
	 * 
	 */
	
	public boolean deleteCompanyByIdDao(int id) {
		Company company=getCompanyByIdDao(id);
		
		if(company!=null) {
			et.begin();
			em.remove(company);
			et.commit();
			return true;
		}else {
			return false;
		}
	}
	public Company updateCompanyByIdDao(int id,String name) {
		Company comp=getCompanyByIdDao(id);
		if(comp!=null) {
		comp.setName(name);
		et.begin();
		em.merge(comp);
		et.commit();
		
		return comp;
		}else {
			return null;
		}
	}
	public List<Company> getAllCompanyDetailsDao(){
		String selectQuery="Select c from Company c";
		Query query=em.createQuery(selectQuery);
		
		return query.getResultList();
	}
	public int deleteCompanyByIdJPQLDao(int companyId) {
		String deleteQuery="delete Company c where c.id=?1";
				Query query=em.createQuery(deleteQuery);
		query.setParameter(1, companyId);
		et.begin();
		int a=query.executeUpdate();
		et.commit();
		return a;
		
	}
	public int updateCompanyNameByJPQLDao(int companyId,String name) {
		String updateQuery="update Company c set c.name=?1 where c.id=:cId";
		Query query=em.createQuery(updateQuery);
		query.setParameter("cId", companyId);
		query.setParameter(1, name);
		et.begin();
		int a=query.executeUpdate();
		et.commit();
		return a;
		
	}
	
	


}
