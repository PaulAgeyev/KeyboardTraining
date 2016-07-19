package com.teaminternational.dao;

import com.teaminternational.domain.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Created by Nikitos on 18.07.2016.
 */

public interface ModeratorRepository extends JpaRepository <Moderator, Long>{
}
