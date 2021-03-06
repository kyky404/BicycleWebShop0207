package controllers;


import common.ServiceObjectResponse;
import entity.PurchaseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import services.IPurchaseService;

import java.util.List;

@RestController
@Api(tags = {"purchase"}, value = "PurchaseService")
public class PurchaseController {
    @Autowired
    IPurchaseService _purchaseService;


    @ApiOperation(value = "all", nickname = "all")
    @GetMapping("/api/purchase/all")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public List<PurchaseEntity> GetAll() throws Exception
    {
        ServiceObjectResponse<List<PurchaseEntity>> request = _purchaseService.getAll();

        if(!request.getIsSuccess())
        {
            throw new Exception(request.getMessage());
        }
        return request.getObject();
    }

    @ApiOperation(value = "create", nickname = "create")
    @PostMapping("/api/purchase")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public PurchaseEntity CreatePurchase(@RequestBody PurchaseEntity purchaseEntity) throws Exception
    {
        ServiceObjectResponse<PurchaseEntity> request = _purchaseService.create(purchaseEntity);

        if(!request.getIsSuccess())
        {
            throw new Exception(request.getMessage());
        }
        return request.getObject();
    }


    @ApiOperation(value = "getById", nickname = "getById")
    @GetMapping("/api/purchase/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public PurchaseEntity GetPurchaseById(@PathVariable int id) throws Exception
    {
        ServiceObjectResponse<PurchaseEntity> request = _purchaseService.getById(id);

        if(!request.getIsSuccess())
        {
            throw new Exception(request.getMessage());
        }
        return request.getObject();
    }
}
