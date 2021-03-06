package repository;

import common.DBConnection;
import entity.ShifterEntity;
import org.springframework.stereotype.Service;
import repositories.IShifterRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShifterRepository implements IShifterRepository {


    public List<ShifterEntity> getAll() throws Exception
    {
        List<ShifterEntity> shifterEntities = new ArrayList<>();
        ShifterEntity shifterEntity = null;

        Connection connection = DBConnection.getConnection();

        String SQL = "{ CALL ShifterGetAll() }";
        CallableStatement stmt = connection.prepareCall(SQL);

        ResultSet resultSets = stmt.executeQuery();

        // Iterate through the data in the result set.
        while (resultSets.next())
        {
            shifterEntity = MapShifter(resultSets);
            shifterEntities.add(shifterEntity);
        }

        return shifterEntities;
    }

    public ShifterEntity getById(int id) throws Exception
    {
        ShifterEntity shifterEntity = null;

        Connection connection = DBConnection.getConnection();

        String SQL = "{ CALL ShifterGetId(?) }";
        CallableStatement stmt = connection.prepareCall(SQL);
        stmt.setInt("paramID", id);

        ResultSet resultSets = stmt.executeQuery();

        // Iterate through the data in the result set.
        while (resultSets.next())
        {
            shifterEntity = MapShifter(resultSets);

        }

        return  shifterEntity;
    }




    private ShifterEntity MapShifter(ResultSet dataSet) throws SQLException
    {
        ShifterEntity shifterEntity = new ShifterEntity();
        shifterEntity.Id = Integer.parseInt(dataSet.getString("id"));
        shifterEntity.Shifter = dataSet.getString("tipus");

        return  shifterEntity;
    }



}
