package org.internship.market.services;

import org.internship.market.database.dao.AccountingDAO;
import org.internship.market.database.entity.AccountingEntity;
import org.internship.market.dto.AccountingDTO;
import org.internship.market.services.impl.AccountingServicesImpl;
import org.internship.market.services.mapper.AccountingMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountingServicesTest {

    @Mock
    AccountingDAO accountingDAO;

    @Mock
    AccountingMapper mapper;

    @InjectMocks
    AccountingServicesImpl accountingServices;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
       verifyNoMoreInteractions(accountingDAO, mapper);
    }

    @Test
    void shouldInsertRecord() {
        AccountingDTO dto = new AccountingDTO();
        AccountingEntity entity = new AccountingEntity();

        when(mapper.dtoToEntity(dto)).thenReturn(entity);

        accountingServices.insert(dto);

        verify(mapper, times(1)).dtoToEntity(dto);
        verify(accountingDAO).save(entity);

    }
}
