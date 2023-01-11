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
                            ),


                    }


            )
    })@ApiResponse(
            responseCode = "400",
            description = "Ошибка добавления на склад"

    )
    public ResponseEntity<SockStore> addSockStore(@RequestBody SockStore sockStore) {
        try {
            sockService.addSock(sockStore);
            return ResponseEntity.ok(sockStore);
        }catch (IllegalArgumentException e ){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping
    @Operation(description = "Отгрузка носков со склада")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Носки отгружены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Sock.class)
                            ),


                    }


            )
    })@ApiResponse(
            responseCode = "400",
            description = "Носки не найдены"

    )
    public ResponseEntity<Integer> putSockStore(@RequestBody SockStore sockStore) {
        try {
            sockService.putSock(sockStore);
            return ResponseEntity.ok(sockService.getQuantity(sockStore.getSock()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping
    @Operation(description = "Поиск носков по размеру , составу , и цвету")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Носки найдены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Sock.class)
                            ),


                    }


            )
    })@ApiResponse(
            responseCode = "400",
            description = "По вводимым параметрам носки не найдены"

    )
    public ResponseEntity<Integer> getSockStore(@RequestParam String color,
                                                @RequestParam int size,
                                                @RequestParam int cottonMin,
                                                @RequestParam int cottonMax) {
        try {
            int quantity = sockService.getSock(color, size, cottonMin, cottonMax);
            return ResponseEntity.ok().body(quantity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    @Operation(description = "Удаление брачных носков")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Носки удалены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Sock.class)
                            ),
                    }


            )
    })  @ApiResponse(
            responseCode = "400",
            description = "Носки не найдены"

    )
    public ResponseEntity<Integer> deleteSockStore(@RequestBody SockStore sockStore) {
        try {
            sockService.putSock(sockStore);
            return ResponseEntity.ok(sockService.getQuantity(sockStore.getSock()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }
    }
