package uz.module.commerce.inventory.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.module.commerce.inventory.exception.CustomException;
import uz.module.commerce.inventory.model.dto.PrivilegeDto;
import uz.module.commerce.inventory.model.payload.Response;
import uz.module.commerce.inventory.service.PrivilegeService;

import java.util.List;

@RestController
@RequestMapping("/module/privilege")
@Api(value = "Privilege Controller", description = "Managing privileges of particular type of user")
public class PrivilegeController extends BaseController{
    @Autowired
    private PrivilegeService privilegeService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @ApiOperation(value = "Fetch privileges by id of the user type")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Successfully fetched privileges by user type"),
            @ApiResponse(code = 1001, message = "User type for corresponding id not found"),
            @ApiResponse(code = 9999, message = "Failed to fetch privilege by user type")
    })
    @GetMapping("/find/user-type/{userTypeId}")
    public ResponseEntity<Response<List<PrivilegeDto>>>
                                    findPrivilegesByUserType(@ApiParam(value = "User type id to be fetched", required = true)
                                                             @PathVariable Long userTypeId){
        logger.info("PrivilegeController -> findPrivilegesByUserType -> userTypeId", userTypeId);

        Response response = new Response();

        try {
            List<PrivilegeDto> privileges = privilegeService.findPrivilegesByUserTypeId(userTypeId);

            logger.info("PrivilegeController -> findPrivilegesByUserType -> response", privileges);

            response.setResponse(privileges);
            response.setCode(getIntProperty("code_0"));
            response.setMessage(getProperty("message_0"));
        } catch (Exception e) {
            response.setCode(getIntProperty("code_9999"));
            response.setMessage(getProperty("message_9999"));
        }finally {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    @ApiOperation(value = "Fetch all privileges")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Successfully fetched all privileges"),
            @ApiResponse(code = 9999, message = "Failed to fetch privileges from database")
    })
    @GetMapping("/find/all")
    public ResponseEntity<Response<List<PrivilegeDto>>> findAllPrivileges(){

        Response response = new Response();

        try {

            List<PrivilegeDto> privileges = privilegeService.findAllPrivileges();

            logger.info("PrivilegeController -> findAllPrivileges -> response", privileges);

            response.setResponse(privileges);
            response.setCode(getIntProperty("code_0"));
            response.setMessage(getProperty("message_0"));
        } catch (Exception e) {
            response.setCode(getIntProperty("code_9999"));
            response.setMessage(getProperty("message_9999"));
        }finally {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Deleting privilege by its id", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Privilege successfully deleted"),
            @ApiResponse(code = 9999, message = "Failed to delete privilege")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePrivilegeById(@ApiParam(value = "Privilege id to be deleted", required = true)
                                                        @PathVariable Long id){
        logger.info("PrivilegeController -> deletePrivilegeById -> id: {}", id);

        Response response = new Response();

        try {
            privilegeService.deletePrivilegeById(id);

            response.setCode(getIntProperty("code_0"));
            response.setMessage(getProperty("message_0"));

        } catch (Exception e) {
            response.setCode(getIntProperty("code_9999"));
            response.setMessage(getProperty("message_9999"));
        }finally {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Adding new privilege or updating existing one", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Privilege successfully saved or updated"),
            @ApiResponse(code = 1000, message = "One or more required fields are empty"),
            @ApiResponse(code = 9999, message = "Failed to save or update privilege")
    })
    @PostMapping("/save")
    public ResponseEntity<Response> save(@ApiParam(value = "Privilege object to be deleted", required = true)
                                             @RequestBody PrivilegeDto request){
        logger.info("PrivilegeController -> save -> request: {}", request);

        Response response = new Response();

        try {

            privilegeService.createOrUpdatePrivilege(request);

            response.setCode(getIntProperty("code_0"));
            response.setMessage(getProperty("message_0"));

        }catch (CustomException e){
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setCode(getIntProperty("code_9999"));
            response.setMessage(getProperty("message_9999"));
        }finally {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
