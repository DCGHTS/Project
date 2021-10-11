package za.ac.nwu.project.web.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.project.domain.dto.ATDto;
import za.ac.nwu.project.domain.service.GeneralResponse;
import za.ac.nwu.project.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.project.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("account-type")
public class ATController
{
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public ATController(FetchAccountTypeFlow fetchAccountTypeFlow,
                        @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow)
    {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Config Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 402, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })

    public ResponseEntity<GeneralResponse<List<ATDto>>> getAll()
    {
        List<ATDto> accountTypes = fetchAccountTypeFlow.getAllAcountTypes();
        GeneralResponse<List<ATDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new AccountType.", notes = "Creates a new AccountType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<ATDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.", required = true)
            @RequestBody ATDto accountType)
    {
        ATDto accountTypeResponse =createAccountTypeFlow.create(accountType);
        GeneralResponse<ATDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
