package com.example.temppaper3course.controllers;


import com.example.temppaper3course.model.Sock;
import com.example.temppaper3course.model.SockStore;
import com.example.temppaper3course.service.SockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/sock")
@RestController
@Tag(name = "Носки ", description = "CRUD - операции и другие эндпоинты для отпуска и со склада , удаление брачных , и добавления носков")
public class SockController {

    private final SockService sockService;


    public SockController(SockService sockService) {
        this.sockService = sockService;
    }


    @PostMapping
    @Operation(description = "Добавление носков на склад ")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Носки были добавлены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Sock.class)
                            )

                    }


            )
    })
    public ResponseEntity<SockStore> addSockStore(@RequestBody SockStore sockStore){
        sockService.addSock(sockStore);
        return ResponseEntity.ok(sockStore);
    }
}
