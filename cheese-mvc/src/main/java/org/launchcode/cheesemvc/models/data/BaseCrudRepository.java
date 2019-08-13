package org.launchcode.cheesemvc.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCrudRepository <T, ID> extends CrudRepository<T, ID> {
    default T findOne(ID id) {
        return (T) findById(id).orElse(null);
    }
}