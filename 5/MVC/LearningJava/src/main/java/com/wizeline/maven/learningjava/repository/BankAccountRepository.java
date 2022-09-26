/*
 * Copyright (c) 2022 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.wizeline.maven.learningjava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wizeline.maven.learningjava.model.BankAccountDTO;

/**
 * Class Description goes here.
 * Created by enrique.gutierrez on 24/09/22
 */
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccountDTO, Long> {
}
