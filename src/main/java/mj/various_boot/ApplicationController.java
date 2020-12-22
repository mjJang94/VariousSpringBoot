package mj.various_boot;

import mj.various_boot.Info.DogInfo;
import mj.various_boot.Info.ResponseInfo;
import mj.various_boot.datebase.DogDao;
import mj.various_boot.datebase.DogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    private ResponseInfo responseInfo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DogDao dogDao;

    @RequestMapping(value = "/dog/info/add", method = RequestMethod.POST)
    public ResponseEntity addDogData(@RequestBody DogInfo info){

        responseInfo = new ResponseInfo();

        if (info != null){

            try {

                DogEntity dogEntity = new DogEntity();
                dogEntity.setName(info.name);
                dogEntity.setAge(info.age);
                dogEntity.setBreed(info.breed);
                dogEntity.setColor(info.color);
                dogEntity.setCharacter(info.character);
                dogDao.save(dogEntity);

                responseInfo.resultCode = "200";


            }catch (Exception e){
                responseInfo.resultCode = "999";
            }
        }else{
            responseInfo.resultCode = "999";
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<ResponseInfo>(responseInfo, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/dog/info/get", method = RequestMethod.POST)
    public List<DogEntity> getDogData(@RequestBody DogInfo info){

        responseInfo = new ResponseInfo();


        List<DogEntity> dogInfo = getData(info.name);

        return dogInfo;

    }

    private List<DogEntity> getData(String dogName){

        String query = String.format("SELECT * FROM dog_entity WHERE name = '%s'", dogName);

        return jdbcTemplate.query(query, new BeanPropertyRowMapper<DogEntity>(DogEntity.class));
    }
}
