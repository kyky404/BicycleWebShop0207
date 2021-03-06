package service;

import common.ServiceObjectResponse;
import entity.ShifterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IShifterRepository;
import services.IShifterService;

import java.util.List;

@Service
public class ShifterService implements IShifterService {

    @Autowired
    IShifterRepository _shifterRepository;

    public ServiceObjectResponse<List<ShifterEntity>> getAll()
    {
        ServiceObjectResponse<List<ShifterEntity>> response = new ServiceObjectResponse<>();

        try
        {
            List<ShifterEntity> shifterEntities = _shifterRepository.getAll();

            response.setObject(shifterEntities);
            response.setIsSuccess(true);
            response.setMessage("No errors.");
        }
        catch (Exception ex)
        {
            response.setIsSuccess(false);
            response.setMessage(ex.getMessage());
        }

        return response;
    }


    public ServiceObjectResponse<ShifterEntity> getById(int id)
    {
        ServiceObjectResponse<ShifterEntity> response = new ServiceObjectResponse<>();

        try
        {
            ShifterEntity shifterEntity = _shifterRepository.getById(id);

            response.setObject(shifterEntity);
            response.setIsSuccess(true);
            response.setMessage("No errors.");
        }
        catch (Exception ex)
        {
            response.setIsSuccess(false);
            response.setMessage(ex.getMessage());
        }

        return response;
    }
}
