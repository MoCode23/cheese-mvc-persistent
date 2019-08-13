package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//Takes in Cheese objects and the keys will be integers. CrudRepository allows work with database.
@Repository
@Transactional
public interface CheeseDao extends BaseCrudRepository<Cheese,Integer> {

}
