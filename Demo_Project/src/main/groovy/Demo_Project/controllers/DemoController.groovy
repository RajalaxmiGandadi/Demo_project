package Demo_Project.controllers

import com.google.gson.JsonObject
import com.mysql.cj.mysqlx.protobuf.Mysqlx

import Demo_Project.services.DemoService
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
@Slf4j
class DemoController {

    @Autowired DemoService demoService

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    ResponseEntity<JsonObject> get(){
        Object result = mysqlService.getAllRecord()
        return (new ResponseEntity<JsonObject>(result,HttpStatus.OK))

    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity delete(@PathVariable Integer id)
    {
        int status = mysqlService.delete(id)
        if(status==1)
            return ResponseEntity.ok("True");
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }



    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    ResponseEntity update(@PathVariable int id, HttpServletRequest req, HttpServletResponse resp)
    {
        long phNo = 0;
        String name = req.getParameter("name");
        String mailId = req.getParameter("email_id");
        if(req.getParameter("phNo")!=null)
         phNo = Long.parseLong(req.getParameter("phNo"));


        int status = mysqlService.update(id,name,mailId,phNo)
        if(status==1)
        return ResponseEntity.ok("True")
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }



    @RequestMapping(value = "create/{name}/{phNo}/{mailId}",method = RequestMethod.POST)
    ResponseEntity create(@PathVariable String name, @PathVariable long phNo, @PathVariable String mailId)
    {
        int status = mysqlService.create(name,phNo,mailId)
        if(status ==1)
        return new ResponseEntity((HttpStatus.CREATED))
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST)

    }


}