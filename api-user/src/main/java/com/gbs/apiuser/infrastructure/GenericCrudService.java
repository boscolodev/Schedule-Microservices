package com.gbs.apiuser.infrastructure;

import com.gbs.apiuser.shared.exceptions.DatabaseNotFoundException;
import com.gbs.apiuser.shared.utils.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface GenericCrudService<T, ID> {

    JpaRepository<T, ID> getRepository();

    @Transactional(readOnly = true)
    default T findById(final ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new DatabaseNotFoundException("Erro ao localizar o registro " + id));
    }

    default void delete(final ID id) {
        findById(id);
        getRepository().deleteById(id);
    }

    @Transactional
    default T save(final T entity) {
        beforeSave();
        return getRepository().save(entity);
    }

    @Transactional
    default T update(final ID id, final T entity) {
        T result = findById(id);
        Mapper.copyEntity(entity, result);
        return save(result);
    }

    @Transactional(readOnly = true)
    default Page<T> findAll(final Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    default void beforeSave() {
    }

}
