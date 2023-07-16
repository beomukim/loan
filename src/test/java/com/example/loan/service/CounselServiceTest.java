package com.example.loan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.loan.domain.Counsel;
import com.example.loan.dto.CounselDTO.Request;
import com.example.loan.dto.CounselDTO.Response;
import com.example.loan.repository.CounselRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class CounselServiceTest {

    @InjectMocks
    CounselServiceImpl counselService;

    @Mock
    private CounselRepository counselRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewCounselEntity_When_RequestCounsel() {
        Counsel entity = Counsel.builder()
                .name("beomu Kim")
                .cellPhone("010-1111-2222")
                .email("mail@abc.de")
                .memo("대출이 필요해요")
                .zipCode("123456")
                .address("서울 어딘가")
                .addressDetail("101호")
                .build();

        Request request = Request.builder()
                .name("beomu Kim")
                .cellPhone("010-1111-2222")
                .email("mail@abc.de")
                .memo("대출이 필요해요")
                .zipCode("123456")
                .address("서울 어딘가")
                .addressDetail("101호")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);

        Response actual = counselService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());
    }
}
