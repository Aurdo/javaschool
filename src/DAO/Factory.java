package DAO;

import DAO.Impl.CategoryDAOImpl;

public class Factory {
	  
	  private static CategoryDAO categoryDAO = null;
	  private static Factory instance = null;

	  public static synchronized Factory getInstance(){
		    if (instance == null){
		      instance = new Factory();
		    }
		    return instance;
	  }

	  public CategoryDAO CategoryDAO(){
		    if (categoryDAO == null){
		      categoryDAO = new CategoryDAOImpl();
		    }
		    return categoryDAO;
	  }	  

}
