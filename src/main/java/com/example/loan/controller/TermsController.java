package com.example.loan.controller;

import com.example.loan.dto.ResponseDTO;
import com.example.loan.dto.TermsDTO.Request;
import com.example.loan.dto.TermsDTO.Response;
import com.example.loan.service.TermsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/terms")
public class TermsController extends AbstractController {

    private final TermsService termsService;

    @PostMapping
    public ResponseDTO<Response> create(@RequestBody Request request) {
        return ok(termsService.create(request));
    }

    @GetMapping()
    public ResponseDTO<List<Response>> getAll() {
        return ok(termsService.getAll());
    }
}
