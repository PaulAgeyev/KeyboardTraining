package com.teaminternational.dao;

import com.teaminternational.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by pavel on 07.07.16.
 */
interface RoleRepository extends JpaRepository<Role, Long> {

}
