package com.turling.controller;
import com.turling.entity.EasyUIDataGrid;
import com.turling.entity.Emp;
import com.turling.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/findEmp")
    @ResponseBody
    public EasyUIDataGrid findEmp(@RequestParam(name = "page",defaultValue = "1")Integer curPage,
                                  @RequestParam(name = "rows",defaultValue = "2")Integer pageSize){
        return empService.findEmp(curPage,pageSize);
    }

    @PostMapping("/addEmp")
    @ResponseBody
    public String addEmp(Emp emp){
        empService.addEmp(emp);
        return "success";
    }

    @PostMapping("/updateEmp")
    @ResponseBody
    public String updateEmp(Emp emp){
        empService.updateEmp(emp);
        return "success";
    }

    @PostMapping("/delEmp")
    @ResponseBody
    public String delEmp(Integer empno){
        empService.delEmp(empno);
        return "success";
    }
}
