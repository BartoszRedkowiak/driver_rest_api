package org.exercise.driver_rest_api.advice;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/api/tutorials", produces = "application/json")
public class TutorialController {

    private final TutorialService tutorialService;
    private final ModelMapper modelMapper;

    @Autowired
    public TutorialController(TutorialService tutorialService, ModelMapper modelMapper) {
        this.tutorialService = tutorialService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(params = { "page", "size" })
    @ApiOperation(value = "Finds a page of tutorials with specified size", notes = "", responseContainer = "List", response = TutorialDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "Couldn't find any tutorials")})
    public ResponseEntity getPaginated(@RequestParam(name = "page") int page,
                                       @RequestParam(name = "size") int size) throws EntityNotFoundException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Tutorial> resultPage = tutorialService.getPage(pageable);
        if (page > resultPage.getTotalPages()) {
            throw new EntityNotFoundException();
        }
        List<TutorialDto> responseBody = resultPage.getContent().stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.status(200).body(responseBody);
    }

    private TutorialDto toDto(Tutorial tutorial) {
        return modelMapper.map(tutorial, TutorialDto.class);
    }

    private Tutorial fromDto(TutorialDto tutorialDto) {
        return modelMapper.map(tutorialDto, Tutorial.class);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds one tutorial", notes = "", response = TutorialDto.class)
    @ApiImplicitParam(name = "id", value = "Tutorial's id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Tutorial with given id doesn't exist")
    })
    public ResponseEntity getOne(@PathVariable Long id) throws EntityNotFoundException {
        Tutorial tutorial = tutorialService.getOne(id);
        TutorialDto response = toDto(tutorial);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new tutorial", notes = "Id and createdDate properties are set on the server side", response = TutorialDto.class)
    public ResponseEntity createAdvice(@RequestBody TutorialDto tutorialDto) {
        //TODO find better solution
        tutorialDto.setId(null);
        tutorialDto.setCreatedDate(null);
        tutorialService.createOrUpdate(fromDto(tutorialDto));
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updates existing advice", notes = "", response = TutorialDto.class)
    public ResponseEntity updateAdvice(@RequestBody TutorialDto tutorialDto,
                                       @PathVariable Long id) throws EntityNotFoundException {
        tutorialService.getOne(id); //throws 404 EntityNotFoundException if there's no record in database
        tutorialDto.setId(id);
        tutorialService.createOrUpdate(fromDto(tutorialDto));
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes an tutorial with provided id", notes = "", response = TutorialDto.class)
    public ResponseEntity deleteAdvice(@PathVariable Long id) throws EmptyResultDataAccessException {
        tutorialService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
