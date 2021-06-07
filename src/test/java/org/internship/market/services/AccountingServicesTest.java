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

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountingServicesTest {

    @Mock
    AccountingDAO accountingDAO;

    @Mock
    AccountingMapper mapper;

    @Mock
    AccountingDTO accountingDTO;

    @InjectMocks
    AccountingServicesImpl accountingServices;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(accountingDAO, mapper, accountingDTO);
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

    @Test
    void shouldReturnAccountingDtoList() {
        List<AccountingDTO> listDto = Collections.singletonList(new AccountingDTO());
        List<AccountingEntity> listEntity = Collections.singletonList(new AccountingEntity());

        when(accountingDAO.getAll()).thenReturn(listEntity);
        when(mapper.entitiesToDtoS(listEntity)).thenReturn(listDto);

        List<AccountingDTO> list = accountingServices.getAllAccounting();

        verify(accountingDAO).getAll();
        verify(mapper).entitiesToDtoS(listEntity);

        assertThat(list).isNotEmpty();
    }

    @Test
    void shouldDeleteAccounting() {
        accountingServices.deleteAccounting();

        verify(accountingDAO).deleteAccounting();
    }

    @Test
    void shouldUpdateCosts() {
        accountingServices.updateCosts(10.5);

        verify(accountingDAO).updateCosts(10.5);
    }

    @Test
    void shouldUpdateIncome() {
        accountingServices.updateIncome(10.5);

        verify(accountingDAO).updateIncome(10.5);
    }


}
