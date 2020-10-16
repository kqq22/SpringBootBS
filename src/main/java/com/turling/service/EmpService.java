package com.turling.service;

import com.turling.entity.EasyUIDataGrid;
import com.turling.entity.Emp;

public interface EmpService {

    public EasyUIDataGrid findEmp(Integer curPage, Integer pageSize);

    /**
     * 添加员工
     * @param emp
     */
    public void addEmp(Emp emp);

    /**
     * 修改员工信息
     * @param emp
     */
    public void updateEmp(Emp emp);

    /**
     * 删除员工
     * @param empno
     */
    public void delEmp(Integer empno);
}
