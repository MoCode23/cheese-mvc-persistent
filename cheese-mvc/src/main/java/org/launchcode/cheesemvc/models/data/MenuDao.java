package org.launchcode.cheesemvc.models.data;
import org.launchcode.cheesemvc.models.Menu;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MenuDao extends BaseCrudRepository<Menu, Integer> {
}