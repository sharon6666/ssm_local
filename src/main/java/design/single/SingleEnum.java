package design.single;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: ssm
 * @Package: design.single
 * @Description: note
 * @Author:
 * @date: 2019-10-30 9:35
 * @UpdateUser:
 * @UpdateDate: 2019-10-30 9:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public enum SingleEnum {
    Instance;
    public void getInstance(){

    }

    public static void main(String[] args){
        SingleEnum ss = SingleEnum.Instance;
        SingleEnum sss = SingleEnum.Instance;
        System.out.println(ss == sss);
    }
}
