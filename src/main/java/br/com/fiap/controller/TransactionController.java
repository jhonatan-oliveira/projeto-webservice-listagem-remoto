package br.com.fiap.controller;

import br.com.fiap.entity.Contact;
import br.com.fiap.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(path = "/add", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    @ResponseBody
    @ApiOperation(value = "Create new contact for the Collaborator")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Add new contact"),
            @ApiResponse(code = 400, message = "Some field have wrong information"),
            @ApiResponse(code = 500, message = "Some error occurred"),
    })
    public ResponseEntity<String> add(@Valid @RequestBody Contact contact) {
        return transactionService.add(contact);
    }

    @RequestMapping(path = "/Collaborator/{CollaboratorRegistrationNumber}", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    @ApiOperation(value = "Find all transactions by Collaborator registration number")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get all transactions from the Collaborator"),
            @ApiResponse(code = 400, message = "Some field have wrong information"),
            @ApiResponse(code = 500, message = "Some error occurred"),
    })
    public ResponseEntity<List<Contact>> findAllTransactionsFromCollaborator(@PathVariable Integer CollaboratorRegistrationNumber) {
        return transactionService.findAllTransactionsFromCollaborator(CollaboratorRegistrationNumber);
    }

    @RequestMapping(path = "/{transactionId}", method = RequestMethod.DELETE, produces="application/json")
    @ResponseBody
    @ApiOperation(value = "Delete the transaction by transaction ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete the transaction"),
            @ApiResponse(code = 400, message = "Some field have wrong information"),
            @ApiResponse(code = 500, message = "Some error occurred"),
    })
    public ResponseEntity<String> deleteTransactionById(@PathVariable Integer transactionId) {
        return transactionService.deleteTransactionById(transactionId);
    }
}
