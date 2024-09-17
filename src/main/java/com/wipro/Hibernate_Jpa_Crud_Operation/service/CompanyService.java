package com.wipro.Hibernate_Jpa_Crud_Operation.service;

import java.util.List;

import com.wipro.Hibernate_Jpa_Crud_Operation.dao.CompanyDao;
import com.wipro.Hibernate_Jpa_Crud_Operation.dto.Company;

public class CompanyService {
	CompanyDao dao=new CompanyDao();
	public Company saveCompanyService(Company company) {
		return dao.saveCompanyDao(company);
	}
	/**
	 * Select * form company where id=?;
	 * @param id
	 * @return
	 */
	public Company getCompanyByIdService(int id) {
		return dao.getCompanyByIdDao(id);
	}
	public boolean deleteCompanyByIdService(int id) {
		return dao.deleteCompanyByIdDao(id);
	}
	public Company updateCompanyByIdService(int id,String name) {
		return dao.updateCompanyByIdDao(id, name);
	}public List<Company> getAllCompanyDetailsService(){
		return dao.getAllCompanyDetailsDao();
	}
	

}
